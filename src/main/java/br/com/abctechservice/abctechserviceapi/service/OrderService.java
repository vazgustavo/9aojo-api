package br.com.abctechservice.abctechserviceapi.service;

import br.com.abctechservice.abctechserviceapi.model.Order;
import java.util.List;

public interface OrderService {

    void saveOrder(Order order, List<Long> arrayAssist) throws Exception;
    List<Order> listOrderByOperator(Long operatorId);
}