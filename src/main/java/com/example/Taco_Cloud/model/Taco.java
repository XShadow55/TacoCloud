package com.example.Taco_Cloud.model;

//import jakarta.persistence.*;
import com.example.Taco_Cloud.model.Ingredient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
//@Entity
public class Taco {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 5,message = "Name must be at least 5 characters long")
    private String name;
    private Date createAt = new Date();
    @Size(min = 1,message = "You must choose at least 1 ingredient")
//    @ManyToMany
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
