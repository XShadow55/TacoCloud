package com.example.Taco_Cloud.model;

//import jakarta.persistence.*;
import com.example.Taco_Cloud.model.Taco;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class TacoOrder {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String  id;
    @NotBlank(message="Name is required")
    private String deliveryName;
    @NotBlank(message="Street is required")
    private String deliveryStreet;
    @NotBlank(message="City is required")
    private String deliveryCity;
    @NotBlank(message="State is required")
    private String deliveryState;
    @NotBlank(message="Zip code is required")
    private String deliveryZip;
    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3,fraction = 0,message = "Invalid CVV")
    private String ccCVV;

    private Date createAt = new Date();
    @ManyToOne
    private User user;

//    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();
    public void addTaco(Taco taco){
        tacos.add(taco);
    }
}
