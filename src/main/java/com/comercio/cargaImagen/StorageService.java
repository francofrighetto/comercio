/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio.cargaImagen;
import java.io.IOException;
import java.nio.file.Path;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Franco
 */
public class StorageService {
    public String store(MultipartFile file){
        try {
            if (file.isEmpty()){
                throw new RuntimeException("archivo vacio");
            }
            String filename = file.getOriginalFilename();
            return "";
        } catch (Exception e) {
            throw new RuntimeException("");
        }
    }
}
