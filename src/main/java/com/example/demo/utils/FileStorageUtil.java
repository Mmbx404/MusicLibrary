package com.example.demo.utils;

import java.io.IOException;


import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.FileStorageException;

public class FileStorageUtil {
	public  static byte[] fileToBlob(MultipartFile file) {
  

        try {
            // Check if the file's name contains invalid characters
            /*if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }*/

              byte[] dbFile = file.getBytes();
         
            return dbFile;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file . Please try again!", ex);
        }
    }
	
	public static boolean fileIsAudio(MultipartFile file) {
		if (file.getContentType()=="audio/aac" || file.getContentType()=="audio/mpeg") return true;
		return false;
	}
	public static boolean fileIsPicture (MultipartFile file) {
		if (file.getContentType()=="image/jpeg" || file.getContentType()=="image/bmp") return true;
		return false;
	}
}
