package com.viajafacil.viajador.repository;

import com.viajafacil.viajador.model.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LugarRepository extends JpaRepository<Lugar, Long> {
    List<Lugar> findByCiudad(String ciudad);
}