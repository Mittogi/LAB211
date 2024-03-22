/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto.filemanager;

import java.util.List;

/**
 *
 * @author vopha
 */
public interface IFileManager {

    List<String> readDataFromFile() throws Exception;

    void commitFile(List<String> raws) throws Exception;
}
