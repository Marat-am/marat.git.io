package com.company.repository;

import java.io.*;
import java.util.Scanner;

import static com.company.commons.constants.FileConstants.*;

public class FileRepository {
    private File dataFolder = null;
    private File dataFile = null;

    public FileRepository() {

        createDataFolder();
        createDataFile();
    }

    private void createDataFolder() {

        dataFolder = new File(System.getProperty("user.home") + File.separator + WHERE_PATH + File.separator + FOLDER_NAME);
        boolean createdFolder = true;

        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        } else if (dataFolder.exists() && !dataFolder.isDirectory()) {
            dataFolder.mkdir();
        }

    }


    private void createDataFile() {

        try {
            dataFile = new File(dataFolder.getAbsolutePath() + File.separator + USER_CV_DATA);
            dataFile.createNewFile();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    public void writeInFile(String str) {
        try {
            FileWriter myWriter = new FileWriter(dataFile.getAbsolutePath());
            myWriter.write(str);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public String readFromFile() {
        FileReader fr = null;
        String data = "";
        try {
            fr = new FileReader(dataFile.getAbsolutePath());
            Scanner sc = new Scanner(fr);

            while (sc.hasNextLine()) {
                data += sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;


    }

}
