/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univel.FileConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliano
 */
public class FileConverter {

    public static void main(String args[]) {
//        File file = new File("C:/Users/juliano/Pictures/file.jpeg");
//        FileInputStream fis;
//        byte[] byteArray = new byte[(int) file.length()];
//        try {
//            fis = new FileInputStream(file);
//            fis.read(byteArray);
//            fis.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(FileConverter.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(FileConverter.class.getName()).log(Level.SEVERE, null, ex);
//        }

        String workingDir = System.getProperty("user.dir");
        System.out.println("Current working directory : " + workingDir);
        
        File folder = new File(workingDir+"/files");
        
        if(folder.exists() && folder.isDirectory()){
            File[] files = folder.listFiles();
        }
    }
}
