package br.com.abctechservice.abctechserviceapi.service;

import br.com.abctechservice.abctechserviceapi.model.Assistance;
import br.com.abctechservice.abctechserviceapi.repository.AssistanceRepository;
import br.com.abctechservice.abctechserviceapi.service.impl.AssistanceServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.mockito.Mockito.*;

public class AssistanceServiceTest {

    @Mock
    private AssistanceRepository assistanceRepository;
    private AssistanceService assistanceService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImpl(assistanceRepository);

    }

    @DisplayName("Listando Assistencias disponiveis: sucesso")
    @Test
    public void list_sucess() {
        Assistance assistance1 = new Assistance(1L, "Mock Assistance 1", "Description 1");
        Assistance assistance2 = new Assistance(2L, "Mock Assistance 2", "Description 2");

        when(assistanceRepository.findAll()).thenReturn(List.of(assistance1, assistance2));

        List<Assistance> values = assistanceService.getAssitanceList();

        Assertions.assertEquals(2, values.size());
        Assertions.assertSame(values.get(0), assistance1);
        Assertions.assertSame(values.get(1), assistance2);
    }

    @DisplayName("Listando assistencias indisponiveis :: Erro")
    @Test
    public void list_error() {
        when(assistanceRepository.findAll()).thenReturn(List.of());

        List<Assistance> values = assistanceService.getAssitanceList();
        Assertions.assertEquals(0, values.size());

    }
}
