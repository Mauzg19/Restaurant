package com.example.Restaurante.service;

import com.example.Restaurante.entity.Plato;
import com.example.Restaurante.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {
    @Autowired
    private PlatoRepository platoRepository;

    public List<Plato> listarPlatos() {
        return platoRepository.findAll();
    }

    public Plato guardarPlato(Plato plato) {
        return platoRepository.save(plato);
    }

    public Plato obtenerPlatoPorId(Long id) {
        return platoRepository.findById(id).orElse(null);
    }

    public void eliminarPlato(Long id) {
        platoRepository.deleteById(id);
    }
}