package co.quipux.utils.video;

import org.junit.Test;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class SeleniumAdavnced {

    @Test
    public void captureVideo() throws IOException, AWTException, InterruptedException {

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();
        ScreenRecorder screenRecorder = new ScreenRecorder(
                gc,
                null,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,ENCODING_QUICKTIME_JPEG, CompressorNameKey, ENCODING_QUICKTIME_JPEG,   DepthKey, 24, FrameRateKey, Rational.valueOf(15), QualityKey, 0.5f, KeyFrameIntervalKey,   15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey,
                        Rational.valueOf(30)),
                null,
                new File("\\TestResults\\JavaSelenium.avi"));

        screenRecorder.start();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.ankpro.com");
        Thread.sleep(2000);
        driver.quit();
        screenRecorder.stop();

    }
}
