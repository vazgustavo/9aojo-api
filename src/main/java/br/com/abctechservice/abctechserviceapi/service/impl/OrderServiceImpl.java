package br.com.abctechservice.abctechserviceapi.service.impl;

import br.com.abctechservice.abctechserviceapi.handler.exception.MaxAssistsException;
import br.com.abctechservice.abctechserviceapi.handler.exception.MinimumAssistRequiredException;
import br.com.abctechservice.abctechserviceapi.handler.exception.OperatorNotFoundException;
import br.com.abctechservice.abctechserviceapi.model.Assistance;
import br.com.abctechservice.abctechserviceapi.model.Order;
import br.com.abctechservice.abctechserviceapi.repository.AssistanceRepository;
import br.com.abctechservice.abctechserviceapi.repository.OrderRepository;
import br.com.abctechservice.abctechserviceapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private AssistanceRepository assistanceRepository;

    public OrderServiceImpl(@Autowired OrderRepository odeOrderRepository,
                            @Autowired AssistanceRepository assistanceRepository) {
        this.orderRepository = odeOrderRepository;
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> arrayAssists) throws Exception {
        ArrayList<Assistance> assistances = new ArrayList<>();
        arrayAssists.forEach(i -> {
            Assistance assistance = assistanceRepository.findById(i).orElseThrow(() ->
                    new OperatorNotFoundException("Operator Not Found", "nao foi possivel buscar o operador"));
            assistances.add(assistance);
        });

        order.setAssists(assistances);

        if(!order.hasMinAssists()) {
            throw new MinimumAssistRequiredException("Invalid Assists", "Necessario no minimo uma assistencia");
        } else if (order.exceedsMaxAssists()) {
            throw new MaxAssistsException("Invalid Assists", "numero maximo de assistencias e 15");
        }

        orderRepository.save(order);
    }

    @Override
    public List<Order> listOrderByOperator(Long operatorId) {
        List<Order> lista = orderRepository.findOperatorById(operatorId);
        if(!lista.isEmpty()) {
            return lista;
        } else {
            throw new OperatorNotFoundException("Operator Not Found", "nao foi possivel buscar o operador");
        }
    }
}
