package com.esprit.firstapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@Builder
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private int size;
	private String id_item;
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
	public Warehouse(Long id, String name, int size, String id_item) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.id_item = id_item;
	}
	public Warehouse() {
	}
	
	

}
