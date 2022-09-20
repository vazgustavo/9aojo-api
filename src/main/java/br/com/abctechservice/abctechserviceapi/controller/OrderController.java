package br.com.abctechservice.abctechserviceapi.controller;

import br.com.abctechservice.abctechserviceapi.application.OrderApplication;
import br.com.abctechservice.abctechserviceapi.application.dto.OrderDTO;
import br.com.abctechservice.abctechserviceapi.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderApplication orderApplication;

    public OrderController(
            @Autowired OrderApplication orderApplication
    ) {
        this.orderApplication = orderApplication;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        orderApplication.createOder(orderDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/operator/{operatorId}")
    public ResponseEntity<List<Order>> listOrderByOperator(@PathVariable("operatorId") Long operatorId) {
        return ResponseEntity.ok(orderApplication.listOrderByOperatorId(operatorId));
    }
}