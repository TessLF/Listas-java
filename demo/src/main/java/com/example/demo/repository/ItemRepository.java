package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Item;
// esta interfaz es un componente de acceso a datos.
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {}