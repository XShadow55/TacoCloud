package com.example.Taco_Cloud.repository;

import com.example.Taco_Cloud.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<TacoOrder,String > {
}
