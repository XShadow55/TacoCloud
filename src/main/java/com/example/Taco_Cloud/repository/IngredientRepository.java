package com.example.Taco_Cloud.repository;

import com.example.Taco_Cloud.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,String > {
}
