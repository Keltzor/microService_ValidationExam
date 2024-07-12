package com.esprit.firstapp.mappers;

import com.esprit.firstapp.entities.Warehouse;
import com.esprit.firstapp.entities.WarehouseWithItemDTO;
import com.esprit.firstapp.entities.ItemDTO;

public class WarehouseMappers {

	public static WarehouseWithItemDTO mapToDto(Warehouse warehouse) {

		WarehouseWithItemDTO warehouseDTO = WarehouseWithItemDTO.builder().id(warehouse.getId()).name(warehouse.getName())
				.size(warehouse.getSize()).id_item(warehouse.getId_item()).build();
		return warehouseDTO;
	}

	public static WarehouseWithItemDTO mapToDto(Warehouse warehouse, ItemDTO itemDTO) {

		WarehouseWithItemDTO warehouseDTO = WarehouseWithItemDTO.builder().id(warehouse.getId()).name(warehouse.getName())
				.size(warehouse.getSize()).id_item(warehouse.getId_item()).itemdto(itemDTO).build();

		return warehouseDTO;
	}

	public static Warehouse mapToEntity(WarehouseWithItemDTO warehouseDTO) {
		Warehouse warehouse = Warehouse.builder().id(warehouseDTO.getId()).name(warehouseDTO.getName()).size(warehouseDTO.getSize())
				.id_item(warehouseDTO.getItemdto().getId()).build();
		return warehouse;

	}

}
