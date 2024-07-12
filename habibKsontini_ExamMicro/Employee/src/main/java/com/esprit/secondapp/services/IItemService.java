package com.esprit.secondapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.secondapp.entities.Item;


public interface IItemService {

	Item addItem(Item item);

	Item updateItem(String id, Map<String, Object> stock);

	List<Item> getAllItem();

	Item getItemById(String id);

	void deleteItemById(String id);

}
