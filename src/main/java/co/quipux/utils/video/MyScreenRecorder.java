package co.quipux.utils.video;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;


/**
 * MyScreenRecorder is a subclass of ScreenRecorder that provides functionality for recording the screen
 * and saving it as a video file. It extends the ScreenRecorder class and overrides its createMovieFile method
 * to customize the name of the output file
 * @author Yeison Adrián Rico Hernández
 * @version 1.0
 */
public class MyScreenRecorder extends ScreenRecorder {
    public static ScreenRecorder screenRecorder;
    public String name;

    /**
     * Creates an instance of the MyScreenRecorder class with the specified graphics configuration,
     * capture area, file format, screen format, mouse format, audio format, movie folder, and movie file name.
     * @param cfg the graphics configuration for screen capture.
     * @param captureArea captureArea the area of the screen to be captured.
     * @param fileFormat fileFormat the desired file format for the movie.
     * @param screenFormat screenFormat the desired screen format for capture
     * @param mouseFormat mouseFormat the desired format for recording the mouse cursor.
     * @param audioFormat audioFormat the desired format for recording audio.
     * @param movieFolder movieFolder the folder where the movie will be stored
     * @param name name the name of the movie file.
     * @throws IOException if an error occurs while creating the movie file or if the movie folder does not exist or is not a directory.
     * @throws AWTException if an error occurs while creating the Robot instance for screen capture.
     */
    public MyScreenRecorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                            Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    /***
     * Creates a movie file with the specified file format in the movie folder.
     * @param fileFormat the desired file format for the movie.
     * @return a File object representing the created movie file.
     * @throws IOException if an error occurs while creating the movie file or if the movie folder does not exist or is not a directory.
     */
    @Override
    protected File createMovieFile(Format fileFormat) throws IOException {

        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        } else if (!movieFolder.isDirectory()) {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        return new File(movieFolder,
                name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));

    }

    /**
     * Starts recording the screen with the specified feature file name and method name.
     * @param fileNameFeature the name of the feature being tested, which will be used as the folder name for storing the recording.
     * @param methodName  the name of the method being tested, which will be used as the file name for the recording.
     * @throws Exception  if an error occurs while starting the screen recording.
     */
    public static void startRecording(String fileNameFeature,String methodName) throws Exception {

        File file = new File("./recording"+"/"+fileNameFeature+"/"+methodName+"/");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0, 0, width, height);

        //GraphicsConfiguration gc = getGraphicsConfiguration(serverIp);
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice()
                .getDefaultConfiguration();


        screenRecorder = new MyScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file, methodName);

        screenRecorder.start();

    }

    /**
     * Stops the current screen recording
     * @throws Exception if an error occurs while stopping the screen recording
     */
    public static void stopRecording() throws Exception {
        screenRecorder.stop();
    }

    /// This solution is not working in selenium grid. Do you have any solution for selenium grid?
    /// Its in beta state for Selenium Grid 4. Check for more details here - https://github.com/SeleniumHQ/docker-selenium

}