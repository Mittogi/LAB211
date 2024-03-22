/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto.filemanager;

/**
 *
 * @author vopha
 */
import java.util.List;

public interface IFileManager {

    List<String> readDataFromFile() throws Exception;

    void commitFile(List<String> raws) throws Exception;
}
