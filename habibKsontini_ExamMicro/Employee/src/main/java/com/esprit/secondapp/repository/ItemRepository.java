package com.esprit.secondapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.esprit.secondapp.entities.Item;
public interface ItemRepository extends MongoRepository<Item, String>{

}
