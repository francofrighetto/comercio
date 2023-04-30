/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.comercio;

import com.comercio.Categoria.Categoria;
import com.comercio.Categoria.CategoriaService;
import com.comercio.articulo.Articulo;
import com.comercio.articulo.ArticuloService;
import com.comercio.foto.Foto;
import com.comercio.foto.FotoService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.io.File;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Franco
 */
@RestController
public class Controlador {
    
    // ARTICULO
    @Autowired
    private ArticuloService artServ;
    
    @CrossOrigin(origins = {"http://localhost:4200", "https://angular-portfolio14.web.app/"}, maxAge=3600)
    @GetMapping("/art")
    public List<Articulo> articulos(){
        return artServ.listar();
    }
    
    @CrossOrigin(origins = {"http://localhost:4200", "https://angular-portfolio14.web.app/"}, maxAge=3600)
    @GetMapping("/art/{id}")
    public Articulo articulos(@PathVariable int id){
        return artServ.listarId(id);
    }
    
    @CrossOrigin(origins = {"http://localhost:4200", "https://angular-portfolio14.web.app/"}, maxAge=3600)
    @PostMapping("/new/art")
    public int agregarArticulo(@RequestBody Articulo art){
        Articulo artCreado = artServ.add(art);
        return artCreado.getArt_id();
    }
    /*public ResponseEntity<Boolean> agregarArticulo(@RequestBody Articulo art){
      1  artServ.add(art);
        Boolean result = true;
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }*/
    
    
    @CrossOrigin(origins = {"http://localhost:4200", "https://angular-portfolio14.web.app/"}, maxAge=3600)
    @DeleteMapping("/borrar/articulo/{idArticulo}")
    public void borrarArticulo(@PathVariable int idArticulo){
        artServ.delete(idArticulo);
    }
    
    //CATEGORIA
    @Autowired
    private CategoriaService catServ;
    
    @CrossOrigin(origins = {"http://localhost:4200", "https://angular-portfolio14.web.app/"}, maxAge=3600)
    @GetMapping("/cat")
    public List<Categoria> categorias(){
        return catServ.listar();
    }
    
    
    //FOTO
    @Autowired
    private FotoService fotoServ;
    
    @CrossOrigin(origins = {"http://localhost:4200", "https://angular-portfolio14.web.app/"}, maxAge=3600)
    @PostMapping("/new/imagen")
    public void nuevaFoto(@RequestBody Foto foto_body){
    Articulo art = artServ.listarId(foto_body.getArticulo().getArt_id());
    Foto foto = new Foto();
    foto.setArticulo(art);
    foto.setFoto_nombre(foto_body.getFoto_nombre());
   
         System.out.println(foto);

        
        fotoServ.add(foto);
    }
    
    
    
    private static final String UPLOAD_DIR = "/images";

        @CrossOrigin(origins = {"http://localhost:4200", "https://angular-portfolio14.web.app/"}, maxAge=3600)
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileExtension = getFileExtension(fileName);
        String newFileName = UUID.randomUUID().toString() + fileExtension;
        Path uploadPath = Paths.get(UPLOAD_DIR).toAbsolutePath().normalize();
        Files.createDirectories(uploadPath);
        Path filePath = uploadPath.resolve(newFileName);
        Files.copy(file.getInputStream(), filePath);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/images/download/")
                .path(newFileName)
                .toUriString();

        return ResponseEntity.ok(fileDownloadUri);
    }
    
    @CrossOrigin(origins = {"http://localhost:4200", "https://angular-portfolio14.web.app/"}, maxAge=3600)
    @GetMapping("api/images/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadImage(@PathVariable String fileName, HttpServletRequest request) throws IOException {
        Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists()) {
            throw new FileNotFoundException("No se pudo encontrar el archivo " + fileName);
        }

        String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex);
    }
    
}
