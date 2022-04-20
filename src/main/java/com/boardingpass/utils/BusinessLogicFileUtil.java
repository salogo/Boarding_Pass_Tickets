package com.boardingpass.utils;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.util.List;

public class BusinessLogicFileUtil {

    private final File file = new File("resources/BusinessLogic.csv");

    public String[] getRow(int chosenRow){
        String [] rowData = new String[]{"no", "data", "found"};
        try{
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);

            if(csvReader.readNext() != null){
                List<String[]> allData = csvReader.readAll();
                rowData = allData.get(chosenRow - 1);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rowData;
    }
}
