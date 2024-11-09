package com.example.Taco_Cloud;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }
    @PostMapping("/current")
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus status){
        if(errors.hasErrors()){
            return "orderForm";
        }
        log.info("Order submitted: {}", tacoOrder);
        status.setComplete();
        return "redirect:/";
    }
}