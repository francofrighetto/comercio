package com.comercio.promocion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocionServiceImp implements PromocionService {
    @Autowired
    PromocionRepositorio promocionRepositorio;
    @Override
    public List<Promocion> listar() {
        return promocionRepositorio.findAll();
    }

    @Override
    public void add(Promocion p) {
        promocionRepositorio.save(p);
    }

    @Override
    public Promocion listarId(int promo_id) {
        return null;
    }

    @Override
    public void delete(int promo_id) {

    }

    @Override
    public void edit(Promocion p) {

    }
}
