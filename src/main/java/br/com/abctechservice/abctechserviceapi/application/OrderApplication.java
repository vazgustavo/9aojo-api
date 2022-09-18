package br.com.abctechservice.abctechserviceapi.application;

import br.com.abctechservice.abctechserviceapi.application.dto.OrderDTO;

public interface OrderApplication {

    void createOder(OrderDTO orderDTO) throws Exception;
}