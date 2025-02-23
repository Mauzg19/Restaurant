package com.example.Restaurante.service;

import com.example.Restaurante.entity.DetallePedido;
import com.example.Restaurante.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedido> listarDetalles() {
        return detallePedidoRepository.findAll();
    }

    public DetallePedido guardarDetalle(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public DetallePedido obtenerDetallePorId(Long id) {
        return detallePedidoRepository.findById(id).orElse(null);
    }

    public void eliminarDetalle(Long id) {
        detallePedidoRepository.deleteById(id);
    }
}