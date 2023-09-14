package com.comercio.articulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/articulo")
public class ArticuloController {

    // ARTICULO
    @Autowired
    private ArticuloService artServ;

    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge=3600)
    @GetMapping(value="/mostrar")
    public List<Articulo> articulos(){
        return artServ.listar();
    }

    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge=3600)
    @GetMapping(value="/mostrar/{id}")
    public Optional<Articulo> articulos(@PathVariable int id){
        return artServ.listarId(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge=3600)
    @GetMapping(value="/mostrar/categoria/{id}")
    public List<Articulo> articulosCategoria(@PathVariable int id){
        return artServ.obtenerArticulosPorIdCategoria(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge=3600)
    @GetMapping(value="/mostrar/promocion")
    public List<Articulo> articulosPromocion(){
        return artServ.obtenerPromociones();
    }

    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge=3600)
    @PostMapping(value="/nuevo")
    public int agregarArticulo(@RequestBody Articulo art){
        Articulo artCreado = artServ.add(art);
        return artCreado.getArt_id();
    }

    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge=3600)
    @DeleteMapping(value="/eliminar/{idArticulo}")
    public void borrarArticulo(@PathVariable int idArticulo){
        artServ.delete(idArticulo);
    }
}
