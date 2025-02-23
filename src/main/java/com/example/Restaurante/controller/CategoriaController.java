package com.example.Restaurante.controller;

import com.example.Restaurante.entity.Categoria;
import com.example.Restaurante.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        return "categorias/lista"; // Nombre de la vista Thymeleaf
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/nuevo"; // Nombre de la vista Thymeleaf para crear una nueva categoría
    }

    @PostMapping
    public String agregarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
        model.addAttribute("categoria", categoria);
        return "categorias/editar"; // Nombre de la vista Thymeleaf para editar una categoría
    }

    @PostMapping("/editar/{id}")
    public String actualizarCategoria(@PathVariable Long id, @ModelAttribute Categoria categoria) {
        categoria.setId(id);
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categorias";
    }
}