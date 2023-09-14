package com.comercio.foto;

import com.comercio.articulo.Articulo;
import com.comercio.articulo.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/foto")
public class FotoController {

    @Autowired
    private FotoService fotoService;
    private ArticuloService articuloService;
    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge=3600)
    @PostMapping(value="/nuevo")
    public void nuevaFoto(@RequestBody Foto foto_body) {
        Optional<Articulo> optionalArticulo = articuloService.listarId(foto_body.getArticulo().getArt_id());
        if (optionalArticulo.isPresent()) {

        Articulo art = optionalArticulo.get();
        Foto foto = new Foto();
        foto.setArticulo(art);
        foto.setFoto_nombre(foto_body.getFoto_nombre());
        fotoService.add(foto);
    }
    }
}
