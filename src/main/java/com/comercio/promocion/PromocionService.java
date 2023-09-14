package com.comercio.promocion;

import com.comercio.Categoria.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PromocionService {
    List<Promocion> listar();
    void add(Promocion p);
    Promocion listarId(int promo_id);
    void delete(int promo_id);
    void edit(Promocion p);
}
