package com.comercio.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge=3600)
    @GetMapping(value="/mostrar")
    public List<Categoria> categorias(){
        return categoriaService.listar();
    }

    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge=3600)
    @PostMapping(value="/nuevo")
    public void nuevaCategoria(@RequestBody Categoria categoria){
         categoriaService.add(categoria);
    }
}
