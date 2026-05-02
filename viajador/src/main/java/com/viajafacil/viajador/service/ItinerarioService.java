package com.viajafacil.viajador.service;

import com.viajafacil.viajador.model.Lugar;
import com.viajafacil.viajador.repository.LugarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItinerarioService {

    @Autowired
    private LugarRepository lugarRepository;

    public Map<String, List<Lugar>> generarItinerario(String ciudad, int numDias) {
        List<Lugar> todosLosLugares = lugarRepository.findByCiudad(ciudad);
        Map<String, List<Lugar>> itinerarioFinal = new LinkedHashMap<>();

        if (todosLosLugares.isEmpty()) return itinerarioFinal;

        // Mezclamos para que cada consulta sea una experiencia fresca
        Collections.shuffle(todosLosLugares);
        int totalLugares = todosLosLugares.size();
        
        for (int i = 0; i < numDias; i++) {
            List<Lugar> lugaresDelDia = new ArrayList<>();
            
            // Uso de módulo (%) para asegurar que nunca falten datos en los 7 días
            int indicePrincipal = i % totalLugares;
            lugaresDelDia.add(todosLosLugares.get(indicePrincipal));

           
            if (totalLugares > 1) {
                int indiceSecundario = (i + numDias) % totalLugares;
                if (indiceSecundario != indicePrincipal) {
                    lugaresDelDia.add(todosLosLugares.get(indiceSecundario));
                }
            }

            itinerarioFinal.put("Día " + (i + 1), lugaresDelDia);
        }
        return itinerarioFinal;
    }
}