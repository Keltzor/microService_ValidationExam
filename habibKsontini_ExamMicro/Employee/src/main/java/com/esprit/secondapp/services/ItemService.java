package com.esprit.secondapp.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.secondapp.entities.Item;
import com.esprit.secondapp.repository.ItemRepository;

@Service
public class ItemService implements IItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item addItem(Item item) {
		itemRepository.save(item);
		return item;
	}

	@Override
	public Item updateItem(String id, Map<String, Object> item) {
		Item existingItem = itemRepository.findById(id).get();

		if (existingItem == null) {

			return null;
		}

		for (Map.Entry<String, Object> entry : item.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			try {
				Field field = existingItem.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(existingItem, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return itemRepository.save(existingItem);
		 

	}

	@Override
	public List<Item> getAllItem() {
		return itemRepository.findAll();
	}

	@Override
	public Item getItemById(String id) {
		return itemRepository.findById(id).get();
	}

	@Override
	public void deleteItemById(String id) {
		itemRepository.deleteById(id);

	}

}
