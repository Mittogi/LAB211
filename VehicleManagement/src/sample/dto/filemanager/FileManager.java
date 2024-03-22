/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto.filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author vopha
 */
public class FileManager implements IFileManager{

    private final File inputFile;

    public FileManager(String fileName) throws IOException {
        inputFile = new File(fileName);

        if (!inputFile.exists()) {
            if (!inputFile.createNewFile()) {
                throw new RuntimeException("Can not create " + fileName + " file");
            }
        }
    }

    @Override
    public List<String> readDataFromFile() throws Exception {
        return Files.readAllLines(inputFile.toPath(), StandardCharsets.UTF_8);
    }

    @Override
    public void commitFile(List<String> rawList) throws Exception {
        try {
            PrintWriter pw = new PrintWriter(inputFile);

            rawList.forEach((string) -> {
                pw.print(string);
            });

            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
