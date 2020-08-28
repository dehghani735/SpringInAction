package com.mdt.tacobar.data;

import com.mdt.tacobar.Order;
import com.mdt.tacobar.User;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

//    Order save(Order order);

    //customizing JPA repositories; it will select from Order because we introduce it in CrudRepository
//    List<Order> findByDeliveryZip(String deliveryZip);

    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}