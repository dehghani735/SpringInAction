package com.mdt.tacobar.web.api;

import com.mdt.tacobar.Order;
import com.mdt.tacobar.data.OrderRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/orders",
    produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderApiController {

    private OrderRepository repo;

    public OrderApiController(OrderRepository repo) {
        this.repo = repo;
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public Order putOrder(@RequestBody Order order) {
        return repo.save(order);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public Order patchOrder(@PathVariable("orderId") Long orderId,
                            @RequestBody Order patch) {
        Order order = repo.findById(orderId).get();
        if (patch.getName() != null)
            order.setName(patch.getName());
        if (patch.getState() != null)
            order.setState(patch.getState());
        if (patch.getStreet() != null)
            order.setStreet(patch.getStreet());
        if (patch.getCity() != null)
            order.setCity(patch.getCity());
        if (patch.getZip() != null)
            order.setZip(patch.getZip());
        if (patch.getCcNumber() != null)
            order.setCcNumber(patch.getCcNumber());
        if (patch.getCcExpiration() != null)
            order.setCcExpiration(patch.getCcExpiration());
        if (patch.getCcCVV() != null)
            order.setCcCVV(patch.getCcCVV());

        return repo.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            repo.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
