package com.mdt.tacobar;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

//    Order save(Order order);
}
