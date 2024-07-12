package com.esprit.firstapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class WarehouseWithItemDTO {
	private Long id;
	private String name;
	private int size;
	private String id_item;
	private ItemDTO itemdto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getId_item() {
		return id_item;
	}
	public void setId_item(String id_item) {
		this.id_item = id_item;
	}
	public ItemDTO getItemdto() {
		return itemdto;
	}
	public void setItemdto(ItemDTO itemdto) {
		this.itemdto = itemdto;
	}
	public WarehouseWithItemDTO() {
		super();
	}

	
	

}
