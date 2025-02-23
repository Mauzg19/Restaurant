package com.example.Restaurante.controller;


import com.example.Restaurante.entity.Plato;
import com.example.Restaurante.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/platos")
public class PlatoController {
    @Autowired
    private PlatoService platoService;

    @GetMapping
    public String listarPlatos(Model model) {
        List<Plato> platos = platoService.listarPlatos();
        model.addAttribute("platos", platos);
        return "platos/lista"; // Nombre de la vista Thymeleaf
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoPlato(Model model) {
        model.addAttribute("plato", new Plato());
        return "platos/nuevo"; // Nombre de la vista Thymeleaf para crear un nuevo plato
    }

    @PostMapping
    public String agregarPlato(@ModelAttribute Plato plato) {
        platoService.guardarPlato(plato);
        return "redirect:/platos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPlato(@PathVariable Long id, Model model) {
        Plato plato = platoService.obtenerPlatoPorId(id);
        model.addAttribute("plato", plato);
        return "platos/editar"; // Nombre de la vista Thymeleaf para editar un plato
    }

    @PostMapping("/editar/{id}")
    public String actualizarPlato(@PathVariable Long id, @ModelAttribute Plato plato) {
        plato.setId(id);
        platoService.guardarPlato(plato);
        return "redirect:/platos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPlato(@PathVariable Long id) {
        platoService.eliminarPlato(id);
        return "redirect:/platos";
    }
}