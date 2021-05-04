package com.tycce;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SearchFiles {

    private List<String> fileList = new ArrayList<>();

    public void Search(String catalogPath) {
        File f = new File(catalogPath);
        String[] dirList = f.list();


        for (String file: dirList) {
            String filePath = catalogPath + File.separator + file;
            File f1 = new File(filePath);

            if(f1.isFile()) {
                fileList.add(file);
            } else {
                Search(filePath);
            }
        }
    }

    public boolean writeToFile(String fileResultName) {
        Collections.sort(this.fileList);

        File fileResult = new File(fileResultName);
        try {
            if(!fileResult.exists()) {
                fileResult.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(fileResult);
            for (String fileName: this.fileList) {
                fileWriter.write(fileName.split(".txt")[0]);
            }
            fileWriter.close();

        } catch (IOException e) {return false;}
        return true;
    }
}
