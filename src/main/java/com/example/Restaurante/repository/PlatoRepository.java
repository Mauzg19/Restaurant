package com.example.Restaurante.repository;



import com.example.Restaurante.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoRepository extends JpaRepository<Plato, Long> {
}