package br.com.abctechservice.abctechserviceapi.controller;

import br.com.abctechservice.abctechserviceapi.application.OrderApplication;
import br.com.abctechservice.abctechserviceapi.application.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity createOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        orderApplication.createOder(orderDTO);
        return ResponseEntity.ok().build();
    }

}