package com.example.Restaurante.controller;

import com.example.Restaurante.entity.Cliente;
import com.example.Restaurante.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        return "clientes/lista"; // Asegúrate de tener la plantilla en templates/clientes/lista.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/formulario"; // Asegúrate de tener la plantilla en templates/clientes/formulario.html
    }

    @PostMapping
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes"; // Redirige a la lista después de guardar
    }
}
