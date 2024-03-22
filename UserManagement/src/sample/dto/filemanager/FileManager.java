/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto.filemanager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vopha
 */
public class FileManager implements IFileManager {

    private File inputFile;

    public FileManager(String fileName) throws IOException {
        inputFile = new File(fileName);

        if (!inputFile.exists()) {
            if (!inputFile.createNewFile()) {
                throw new RuntimeException("Can not create " + fileName + " file");
            }
        }
    }

    @Override
    public List<String> readDataFromFile() throws IOException {
        List<String> list = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(inputFile))) {
            while (dis.available() > 0) {
                list.add(dis.readUTF());
            }
        }
        return list;
    }

    @Override
    public void commitFile(List<String> raws) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(inputFile));
            for (String raw : raws) {
                dos.writeUTF(raw);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
