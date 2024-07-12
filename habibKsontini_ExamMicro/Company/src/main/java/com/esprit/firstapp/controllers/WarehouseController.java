package com.esprit.firstapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.firstapp.entities.Warehouse;
import com.esprit.firstapp.entities.WarehouseWithItemDTO;
import com.esprit.firstapp.services.IWarehouseService;

@RestController
@RequestMapping("/api/Warehouse")

public class WarehouseController {

	@Autowired
	private IWarehouseService warehouseService;

	@GetMapping("/warehouses")
	public List<WarehouseWithItemDTO> getAllTutorials() {
		return warehouseService.getAllWarehouse();

	}

	@PostMapping("/save")
	public WarehouseWithItemDTO save(@RequestBody WarehouseWithItemDTO warehouse) {
		return warehouseService.addWarehouse(warehouse);

	}

	@DeleteMapping("/delete/{id}")
	public void supprimer(@PathVariable("id") Long id) {
		warehouseService.deleteWarehouseById(id);

	}

	@GetMapping("/getbyid/{id}")
	public WarehouseWithItemDTO GetById(@PathVariable("id") Long id) {
		return warehouseService.getWarehouseById(id);
	}

	@PatchMapping("/update/{id}")
	public Warehouse patchUpdateItem(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		return warehouseService.updateWarehouse(id, updates);

	}

}
