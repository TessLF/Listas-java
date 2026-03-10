package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String home(Model model) {
        // Enviamos un dato al HTML usando la interfaz Model
        model.addAttribute("mensaje", "Esta página fue servida por un controlador de Java.");

        // Retorna el nombre del archivo HTML (sin el .html)
        return "index";
    }

}
