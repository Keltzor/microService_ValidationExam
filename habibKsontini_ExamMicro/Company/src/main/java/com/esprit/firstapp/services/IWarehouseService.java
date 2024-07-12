package com.esprit.firstapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.firstapp.entities.Warehouse;
import com.esprit.firstapp.entities.WarehouseWithItemDTO;

public interface IWarehouseService {
	
	WarehouseWithItemDTO addWarehouse(WarehouseWithItemDTO article);

	Warehouse updateWarehouse(Long id, Map<String, Object> article);

	List<WarehouseWithItemDTO> getAllWarehouse();

	WarehouseWithItemDTO getWarehouseById(Long id);

	void deleteWarehouseById(Long id);

}
