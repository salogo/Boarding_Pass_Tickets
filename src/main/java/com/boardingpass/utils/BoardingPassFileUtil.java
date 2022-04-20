package com.boardingpass.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

//to do
//better print out to mention file location for error catching

public class BoardingPassFileUtil {
    private final File file = new File("resources/BoardingPass.csv");
    private String[] fileRow;
    private int boardingPassNumber = 10000;

    public String[] getFirstRow(){
        try{
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);

            //this first row should be the header row with the names of columns
            if((fileRow = csvReader.readNext()) != null){
                //first row of real data should be here
                return fileRow = csvReader.readNext();
            }
            fileReader.close();
            csvReader.close();
        }
        catch (FileNotFoundException fnfe){
            System.out.println("No BoardingPass file found");
            fnfe.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //if you get an empty string array then there is no data in file
        return fileRow;
    }

    public String[] getSpecificRow(int chosenRow){
        try{
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);

            //added check to make sure the file is at least populated with the headers
            if(csvReader.readNext() != null){
                List<String[]> allData = csvReader.readAll();
                fileRow = allData.get(chosenRow - 1);
            }
            fileReader.close();
            csvReader.close();
        }
        catch (FileNotFoundException fnfe){
            System.out.println("No BoardingPass file found");
            fnfe.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //if you get an empty string array then the file has no contents
        return fileRow;
    }

    public String[] getLastRow(){
        try{
            FileReader fileReader = new FileReader(file);
            CSVReader csvReader = new CSVReader(fileReader);

            //added check to make sure the file is at least populated with the headers
            if(csvReader.readNext() != null){
                List<String[]> allData = csvReader.readAll();
                fileRow = allData.get(allData.size()-1);
            }
            fileReader.close();
            csvReader.close();
        }
        catch (FileNotFoundException fnfe){
            System.out.println("No BoardingPass file found");
            fnfe.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //if you get an empty string array then the file has no contents
        return fileRow;
    }

    public void addOneRow(String[] inputData){
        //W.I.P
        //need to add inputData + boardingPassNumber + info from BusinessLogic file into one array or list
        //then write that list to row
        try{
            FileWriter fileWriter = new FileWriter(file);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            if(getFirstRow() == null){
                csvWriter.writeNext(inputData);
            }
            fileWriter.close();
            csvWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //to do
    //add this method to go cell by cell on a specified row to input data where needed
    public void addOneItem(){}
}
