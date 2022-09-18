package br.com.abctechservice.abctechserviceapi.application.impl;

import br.com.abctechservice.abctechserviceapi.application.OrderApplication;
import br.com.abctechservice.abctechserviceapi.application.dto.OrderDTO;
import br.com.abctechservice.abctechserviceapi.application.dto.OrderLocationDTO;
import br.com.abctechservice.abctechserviceapi.model.Order;
import br.com.abctechservice.abctechserviceapi.model.OrderLocation;
import br.com.abctechservice.abctechserviceapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderApplicationImpl implements OrderApplication {

    private OrderService orderService;

    public OrderApplicationImpl(@Autowired OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void createOder(OrderDTO orderDTO) throws Exception {
        Order order = new Order();
        order.setOperatorId(orderDTO.getOperatorId());
        order.setStartOrderLocation(getOrderLocationFromOrderLocationDTO(orderDTO.getStart()));
        order.setEndOrderLocation(getOrderLocationFromOrderLocationDTO(orderDTO.getEnd()));

        this.orderService.saveOrder(order, orderDTO.getAssists());

    }

    private OrderLocation getOrderLocationFromOrderLocationDTO(OrderLocationDTO orderLocationDTO) {
        OrderLocation orderLocation = new OrderLocation();
        orderLocation.setLatitude(orderLocationDTO.getLatitude());
        orderLocation.setLongitude(orderLocationDTO.getLongitude());
        orderLocation.setDate(orderLocationDTO.getDateTime());
        return orderLocation;
    }
}