package br.com.abctechservice.abctechserviceapi.service;

import br.com.abctechservice.abctechserviceapi.handler.exception.MaxAssistsException;
import br.com.abctechservice.abctechserviceapi.handler.exception.MinimumAssistRequiredException;
import br.com.abctechservice.abctechserviceapi.model.Assistance;
import br.com.abctechservice.abctechserviceapi.model.Order;
import br.com.abctechservice.abctechserviceapi.repository.AssistanceRepository;
import br.com.abctechservice.abctechserviceapi.repository.OrderRepository;
import br.com.abctechservice.abctechserviceapi.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private AssistanceRepository assistanceRepository;

    private OrderService orderService;

    @BeforeEach
    public void init() {
        orderService = new OrderServiceImpl(orderRepository, assistanceRepository);
        when(assistanceRepository.findById(any())).
                thenReturn(
                        Optional.of(new Assistance(1L, "teste", "teste descrition")));
    }

    @Test
    public void order_service_not_null() {
        Assertions.assertNotNull(orderService);
    }

    @Test
    public void create_order_error_minimum() {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);

        Assertions.assertThrows(MinimumAssistRequiredException.class, () -> orderService.saveOrder(newOrder, List.of()));
        verify(orderRepository, times(0)).save(newOrder);
    }

    @Test
    public void create_order_error_maxium() {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);

        Assertions.assertThrows(MaxAssistsException.class, () -> orderService.saveOrder(newOrder, generate_mock_ids(20)));
        verify(orderRepository, times(0)).save(newOrder);
    }

    @Test
    public void create_order_sucess() throws Exception {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);

        orderService.saveOrder(newOrder, generate_mock_ids(7));
        verify(orderRepository, times(1)).save(newOrder);
    }

    private List<Long> generate_mock_ids(int number) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int x = 0; x < number; x++) {
            arrayList.add(Integer.toUnsignedLong(x));
        }
        return arrayList;
    }
}