
package com.comercio.foto;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 *
 * @author Franco
 */
@Service
public class FotoService {

    private FotoRepositorio repo;

    public List<Foto> listar() {
        return repo.findAll();
    }

    public void add(Foto f) {
        repo.save(f);
    }


    public Foto listarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public Foto delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public Foto edit(Foto f) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String uploadPhoto(MultipartFile photo) throws IOException {
        String fileName = StringUtils.cleanPath(UUID.randomUUID().toString() + "_" + photo.getOriginalFilename());
        System.out.println(fileName);
        //Foto photoEntity = new Foto();
        //photoEntity.setFoto_nombre(fileName);
        //repo.save(photoEntity);

        return fileName;
    }
    
}
