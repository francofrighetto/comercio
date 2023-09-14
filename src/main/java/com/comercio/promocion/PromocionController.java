package com.comercio.promocion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/promocion")
public class PromocionController {

    @Autowired
    private PromocionService promocionService;

    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge=3600)
    @GetMapping(value="/mostrar")
    public List<Promocion> promociones(){
        return promocionService.listar();
    }

    @CrossOrigin(origins = {"http://localhost:4200"}, maxAge=3600)
    @PostMapping(value="/nuevo")
    public void nuevaPromocion(@RequestBody Promocion promocion){
        promocionService.add(promocion);
    }
}
