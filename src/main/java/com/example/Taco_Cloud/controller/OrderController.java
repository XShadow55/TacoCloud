package com.example.Taco_Cloud.controller;

import com.example.Taco_Cloud.model.TacoOrder;
import com.example.Taco_Cloud.model.User;
import com.example.Taco_Cloud.repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    private OrderRepository orderRepository;
    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }
    @PostMapping("/current")
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus status, @AuthenticationPrincipal User user){
        if(errors.hasErrors()){
            return "orderForm";
        }
        tacoOrder.setUser(user);
        orderRepository.save(tacoOrder);
        status.setComplete();
        return "redirect:/";
    }
}
