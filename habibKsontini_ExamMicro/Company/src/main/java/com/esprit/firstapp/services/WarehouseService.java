package com.esprit.firstapp.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.esprit.firstapp.entities.Warehouse;
import com.esprit.firstapp.entities.WarehouseWithItemDTO;
import com.esprit.firstapp.entities.ItemDTO;
import com.esprit.firstapp.mappers.WarehouseMappers;
import com.esprit.firstapp.repository.WarehouseRepository;

@Service
public class WarehouseService implements IWarehouseService {
	@Autowired
	private ItemClient itemClient;

	@Autowired
	private WarehouseRepository warehouseRepository;

	@Override
	public WarehouseWithItemDTO addWarehouse(WarehouseWithItemDTO warehouseDto) {
		 warehouseRepository.save(WarehouseMappers.mapToEntity(warehouseDto));
		return warehouseDto;
		
	}

	@Override
	public List<WarehouseWithItemDTO> getAllWarehouse() {

		return warehouseRepository.findAll().stream().map(warehouse -> WarehouseMappers.mapToDto(warehouse))
				.collect(Collectors.toList());
	}

	@Override
	public WarehouseWithItemDTO getWarehouseById(Long id) {
		Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found for id: " + id));
		
		//OpenFeign
		ItemDTO itemDTO = itemClient.getById(warehouse.getId_item());
		
		//RestTemplate
		//ItemDTO itemDTO =getById(warehouse.getId_item());
		return WarehouseMappers.mapToDto(warehouse, itemDTO);
	}


	@Override
	public Warehouse updateWarehouse(Long id, Map<String, Object> article) {
		Warehouse existingWarehouse = warehouseRepository.findById(id).get();

		if (existingWarehouse == null) {

			return null;
		}

		for (Map.Entry<String, Object> entry : article.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			try {
				Field field = existingWarehouse.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(existingWarehouse, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return warehouseRepository.save(existingWarehouse);
	}

	@Override
	public void deleteWarehouseById(Long id) {
		warehouseRepository.deleteById(id);

	}

	public ItemDTO getById(String id) {
		String url = "http://localhost:8090/api/getbyid/" + id;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, ItemDTO.class);
	}

}
