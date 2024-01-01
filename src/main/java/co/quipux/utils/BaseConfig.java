package co.quipux.utils;


import co.quipux.utils.video.MyScreenRecorder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;


public class BaseConfig {

    public static Logger log;

    public BaseConfig(Class className) {
        log = Logger.getLogger(className);
    }

    protected String actorName;
    protected String scenarioName;
    protected String scenarioType;
    protected static String excelFolderPath = ReadExcelFile.filepath;
    //protected static ArrayList<String> values;
    protected static int row = 1;
    protected static int column = 0;
    protected static int counter = 0;


    /**
     * Starts recording the screen with the specified scenario type and name using the
     * MyScreenRecorder utility.
     *
     * @throws Exception if there is an error starting the recording
     */
    public void startRecording() throws Exception {
        MyScreenRecorder.startRecording(scenarioType, scenarioName);
    }

    /**
     * Stops the screen recording.
     *
     * @throws Exception if there is an error stopping the recording.
     */
    public void closeRecording() throws Exception {
        MyScreenRecorder.stopRecording();
    }

    /**
     * This method captures the data from a specified row and column in an Excel file.
     *
     * @param sheetNumber The index of the sheet in the Excel file.
     * @param row         The row number where the data is located.
     * @param column      The column number where the data is located.
     * @return A String containing the data located at the specified row and column.
     * @throws IOException If there is an error accessing the Excel file.
     * @Author Yeison Adrián Rico Hernández
     */
    protected static String captureDataExcelRowColum(int sheetNumber, int row, int column) throws IOException {
        String data;
        return data = ReadExcelFile.getCellValue(excelFolderPath, ReadExcelFile.excelSheetNumber(excelFolderPath, sheetNumber), row, column);

    }

    /**
     * Reads data from an Excel file for the given sheet name and scenario name.
     *
     * @param sheetName    The name of the worksheet containing the data to be read.
     * @param scenarioName The name of the scenario for which data should be read.
     * @throws IOException if an error occurs while reading the Excel file.
     */
    public static void readExcelData(String sheetName, String scenarioName) throws IOException {
        // READ EXCEL DATA
        ReadExcelFile.runnerList(excelFolderPath, sheetName);
        ReadExcelFile.scenarioListValues(scenarioName);
    }

//    // Definición del método
//    public List<LoginData> getDataClassPosition(List<LoginData> dataClassForScenario, int counter) {
//        // Crear una nueva lista para almacenar los datos en la posición especificada
//        List<LoginData> dataClassPosition = new ArrayList<LoginData>();
//        dataClassPosition.add(dataClassForScenario.get(counter));
//        // Retornar la lista con los datos en la posición especificada
//        return dataClassPosition;
//    }


    //-------------------------------------------------------------------------------
    //                      Métodos data steps
    //-------------------------------------------------------------------------------

}
