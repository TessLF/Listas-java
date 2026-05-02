package com.viajafacil.viajador.controller;

import com.viajafacil.viajador.model.Lugar;
import com.viajafacil.viajador.service.ItinerarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/itinerario")
@CrossOrigin("*") // Para que el frontend pueda conectar
public class ItinerarioController {
    @Autowired
    private ItinerarioService service;

    @GetMapping
    public Map<String, List<Lugar>> obtenerItinerario(@RequestParam String ciudad, @RequestParam int dias) {
        return service.generarItinerario(ciudad, dias);
    }
}