package com.comercio.promocion;

import com.comercio.Categoria.Categoria;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PromocionRepositorio extends Repository<Promocion,Integer> {
    List<Promocion> findAll();
    Promocion findById(int promo_id);
    void save(Promocion p);
    void deleteById(int promo_id);
}
