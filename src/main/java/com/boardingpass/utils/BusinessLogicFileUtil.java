package com.boardingpass.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class BusinessLogicFileUtil {

    private final File file = new File("resources/BusinessLogic.csv");

    private String[] rowData;
    private String[] filteredRowData;

    public int lastLineIndex;

    public String[] getRow(int chosenRow){
        try{
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);

            if(csvReader.readNext() != null){
                List<String[]> allData = csvReader.readAll();
                rowData = allData.get(chosenRow - 1);

                lastLineIndex = rowData.length;
            }
            fileReader.close();
            csvReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rowData;
    }

    //this method is for internal use. The boardingPass file will be calling this to get the filtered out data
    //needed to fill out the blank spots in the final document
    public String[] getFilteredRow(int chosenRow){
        int z = 0;
        try{
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);

            if(csvReader.readNext() != null){
                List<String[]> allData = csvReader.readAll();
                rowData = allData.get(chosenRow - 1);

                lastLineIndex = rowData.length;

                for(int i = 2; i < rowData.length; i++){
                    filteredRowData[z] = rowData[i];
                    z++;
                }
            }
            fileReader.close();
            csvReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return filteredRowData;
    }

    public void setRow(String[] inputData){
        try{
            FileWriter fileWriter = new FileWriter(file, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            csvWriter.writeNext(inputData);

            fileWriter.close();
            csvWriter.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
