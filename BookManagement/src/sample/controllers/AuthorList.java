/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sample.dto.Author;
import sample.dto.IAuthorList;
import sample.dto.filemanager.FileManager;
import sample.dto.filemanager.IFileManager;

/**
 *
 * @author vopha
 */
public class AuthorList extends ArrayList<Author> implements IAuthorList{

    IFileManager vFileManager;

    public AuthorList() {
        try {
            vFileManager = new FileManager("author.txt");
            loadDataFromFile(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // Read data
    public void loadDataFromFile(List<Author> listAuthor) throws Exception {
        for (String raw : vFileManager.readDataFromFile()) {
            listAuthor.add(convertStringToBook(raw));
        }
    }

    public Author convertStringToBook(String rawString) {
        String id, name;
        List<String> raw = Arrays.asList(rawString.split(","));

        id = raw.get(0).trim();
        name = raw.get(1).trim();

        return new Author(id, name);
    }
    
    @Override
    public boolean checkExist(String id) {
        for (Author author : this) {
            if (author.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        
        System.out.println("Author is not exist!");
        return false;
    }
    
}
