package co.quipux.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class ReadExcelFile {

    public static String filepath = "data/testExcel.xlsx";
    public static List<String> dataExcel = new ArrayList<>();

    // WE CREATE A HASHMAP WITH THE KEY OF TYPE STRING AND VALUES OF TYPE ARRAYLIST
    static HashMap<String, ArrayList<String>> associatedDataScenario;
    //static HashMap<String, ArrayList<String>>datosAsociadosAlEscenario = new HashMap<String, ArrayList<String>>();

    // LIST FOR EACH VALUE OF THE SCENARIO
    public static ArrayList<String> valuesExcel = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);

    }


    /**
     * This method assigns the values associated with a specific
     * scenario to a list and removes them from the HashMap.
     * If the key does not exist in the HashMap, it prints a message indicating so.
     *
     * @param nameScenario the name of the scenario whose associated data is to be retrieved
     */
    public static void scenarioListValues(String nameScenario) {

        System.out.println("//////NOMBRE SCENARIO " + nameScenario);
        if (associatedDataScenario.containsKey(nameScenario)) {
            // ASSIGNMENT OF VALUES TO THE LIST BY MEANS OF THE KEY - SCENARIO NAME
            valuesExcel = associatedDataScenario.get(nameScenario);
            //DELETE THE VALUES ASSOCIATED WITH THE KEY
            associatedDataScenario.remove(nameScenario);
        } else {
            System.out.println("The key " + nameScenario + "  is not in the HashMap");
        }

        // Imprimir el ArrayList por consola
        System.out.println("Contenido del ArrayList:");
        for (String data : valuesExcel) {
            System.out.println(data);
        }

    }

    /**
     * If the HashMap of scenario data associated is null, a new instance
     * is created and the specified Excel file in the parameters is read to populate the HashMap.
     *
     * @param filepath  the file path of the Excel file
     * @param sheetName the name of the sheet in the Excel file
     * @throws IOException if there is an error reading the Excel file
     */
    public static void runnerList(String filepath, String sheetName) throws IOException {

        if (associatedDataScenario == null) {
            associatedDataScenario = new HashMap<String, ArrayList<String>>();
            System.out.println("// ESTA LEYENDO DATOS DE EXCEL");
            readexcel(filepath, sheetName);
        }   else if (valuesExcel.isEmpty()) {
            readexcel(filepath, sheetName);
            System.out.println("//// ESTA LEYENDO DATOS PARA OTRA FEATURE");
        }
        System.out.println("DATOS DEL HASMAP////");
        for (Map.Entry<String, ArrayList<String>> entry : associatedDataScenario.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> values = entry.getValue();
            System.out.print("Clave: " + key + ", Valores: ");
            for (String value : values) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }

    }

    /**
     * Reads data from an Excel file and stores it in a HashMap with the scenario value as
     * the key and an ArrayList of associated data as the value.
     *
     * @param filepath  the file path of the Excel file
     * @param sheetName the name of the sheet in the Excel file
     * @throws IOException if there is an error reading the Excel file
     */
    public static void readexcel(String filepath, String sheetName) throws IOException {

        String valorScenario = null;
        List<String> datosSinEscenario = new ArrayList<>();
        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        // GET NUMBER OF ROWS
        int rowCount = newSheet.getLastRowNum() + newSheet.getFirstRowNum();

        for (int i = 1; i <= rowCount; i++) {

            XSSFRow row = newSheet.getRow(i);

            // COLUMN COUNT
            for (int j = 0; j < row.getLastCellNum(); j++) {

                Cell celda = row.getCell(j);

                //IF THE CURRENT CELL IS WITHIN A MERGED REGION OF CELLS,
                //THE VALUE OF THE FIRST CELL IN THE MERGED REGION
                //WHERE THE CURRENT CELL IS LOCATED IS PRINTED AND ADDED TO THE DATAEXCEL LIST
                int mergedRegionCount = newSheet.getNumMergedRegions();
                boolean isMergedRegion = false;
                for (int k = 0; k < mergedRegionCount; k++) {
                    CellRangeAddress mergedRegion = newSheet.getMergedRegion(k);
                    if (mergedRegion.containsRow(celda.getRowIndex()) && mergedRegion.containsColumn(celda.getColumnIndex())) {
                        isMergedRegion = true;
                        dataExcel.add(newSheet.getRow(mergedRegion.getFirstRow()).getCell(mergedRegion.getFirstColumn()).getStringCellValue());
                    }

                }

                // VALIDATE THE DATA TYPE OF THE COLUMN
                if (!isMergedRegion) {
                    switch (celda.getCellTypeEnum().toString()) {

                        case "NUMERIC":
                            // CAST TO CONVERT NUMBER TO LONG
                            long num = (long) celda.getNumericCellValue();
                            dataExcel.add(String.valueOf(num));
                            break;

                        case "STRING":
                            dataExcel.add(celda.getStringCellValue());
                            break;

                        case "FORMULA":
                            dataExcel.add(celda.getCellFormula());
                            break;

                    }
                }


            }

            valorScenario = dataExcel.get(0);
            datosSinEscenario.addAll(dataExcel);
            dataExcel.clear();
            datosSinEscenario.remove(0);

            // KEY ALREADY EXISTS IN HASHMAP
            // ADD VALUE TO EXISTING LIST
            if (associatedDataScenario.containsKey(valorScenario)) {
                associatedDataScenario.get(valorScenario).addAll(datosSinEscenario);
            } else {
                // THE KEY DOES NOT EXIST IN THE HASHMAP
                // CREATE A NEW LIST WITH THE VALUES AND ADD IT TO THE HASHMAP
                List<String> nuevaLista = new ArrayList<>();
                nuevaLista.addAll(datosSinEscenario);
                associatedDataScenario.put(valorScenario, (ArrayList<String>) nuevaLista);
            }

            datosSinEscenario.clear();
        }

    }


    /**
     * This method retrieves the value of a specific cell in an Excel sheet.
     *
     * @param filepath   The file path of the Excel file to read from.
     * @param sheetName  The name of the sheet within the Excel file to read from.
     * @param rowNumber  The row number of the cell to retrieve the value from.
     * @param cellNumber The column number of the cell to retrieve the value from.
     * @return The value of the cell as a string.
     * @throws IOException if there is an error reading the file.
     * @author Yeison Adrián Rico Hernández
     */
    public static String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {

        String cellValue = "";
        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);
        XSSFRow row = newSheet.getRow(rowNumber);
        XSSFCell cell = row.getCell(cellNumber);

        // VALIDATION IF THEY ARE NUMBERS OR LETTERS
        try {
            return cellValue = cell.getStringCellValue();
        } catch (Exception e) {
            int v = (int) cell.getNumericCellValue();
            return cellValue = String.valueOf(v);
        }

    }

    /**
     * This method returns the name of the sheet in the given position in the Excel file.
     *
     * @param filepath The file path of the Excel file to read from.
     * @param number   The position of the sheet in the Excel file.
     * @return The name of the sheet in the given position.
     * @throws IOException if there is an error reading the file.
     * @author Yeison Adrián Rico Hernández
     */
    public static String excelSheetNumber(String filepath, int number) throws IOException {

        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        // Total number of sheets in the Excel file.
        //int sheetNum = workbook.getNumberOfSheets();

        return newWorkbook.getSheetName(number);

    }


    /**
     * This method returns the total number of sheets in the Excel file.
     *
     * @param filepath The file path of the Excel file to read from.
     * @return The total number of sheets in the Excel file.
     * @throws IOException if there is an error reading the file.
     * @author Yeison Adrián Rico Hernández
     */
    public static int totalExcelSheet(String filepath) throws IOException {

        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        // TOTAL NUMBER OF SHEETS IN THE EXCEL FILE.
        int sheetNum;
        return sheetNum = newWorkbook.getNumberOfSheets();

    }

}
