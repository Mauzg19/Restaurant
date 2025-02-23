package com.example.Restaurante.service;

import com.example.Restaurante.entity.Pedido;
import com.example.Restaurante.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}