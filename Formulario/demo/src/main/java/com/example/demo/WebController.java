package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class WebController {

    // Muestra el formulario
    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("calculo", new Calculo());
        return "formulario";
    }

    // Procesa los datos del formulario
    @PostMapping("/calcular")
    public String calcular(@ModelAttribute Calculo calculo, Model model) {
        double ahorro = calculo.getPrecio() * (calculo.getDescuento() / 100);
        calculo.setResultado(calculo.getPrecio() - ahorro);

        model.addAttribute("resultado", calculo.getResultado());
        return "resultado";
    }
}
