package com.esprit.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.firstapp.entities.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
