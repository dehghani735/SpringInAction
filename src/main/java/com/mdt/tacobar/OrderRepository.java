package com.mdt.tacobar;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

//    Order save(Order order);

    //customizing JPA repositories; it will select from Order because we introduce it in CrudRepository
    List<Order> findByDeliveryZip(String deliveryZip);
}