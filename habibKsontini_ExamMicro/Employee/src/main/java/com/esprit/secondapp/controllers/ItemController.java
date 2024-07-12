package com.esprit.secondapp.controllers;

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
import com.esprit.secondapp.entities.Item;
import com.esprit.secondapp.services.IItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private IItemService iItemService;
	
	 @GetMapping("/items")
	  public List<Item> getAllTutorials() {
		 return iItemService.getAllItem();
	    
	  }
	 
	 
	 @PostMapping("/save")
	 public Item save(@RequestBody Item item) {
		 return iItemService.addItem(item);
		 
	    
	  }
	 @DeleteMapping("/delete/{id}")
     public void supprimer(@PathVariable("id") String id){
		 iItemService.deleteItemById(id);

     }
     @GetMapping("/getbyid/{id}")
    public Item GetById(@PathVariable("id") String id){
        return iItemService.getItemById(id);
     }
     
     
     @PatchMapping("/update/{id}")
     public Item patchUpdateItem(@PathVariable String id, @RequestBody Map<String, Object> updates) {
         return iItemService.updateItem(id,  updates);

     }

}
