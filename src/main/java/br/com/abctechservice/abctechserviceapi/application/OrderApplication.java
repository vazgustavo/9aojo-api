package br.com.abctechservice.abctechserviceapi.application;

import br.com.abctechservice.abctechserviceapi.application.dto.OrderDTO;
import br.com.abctechservice.abctechserviceapi.model.Order;
import java.util.List;

public interface OrderApplication {

    void createOder(OrderDTO orderDTO) throws Exception;

    List<Order> listOrderByOperatorId(Long operatorId);
}