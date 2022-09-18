package br.com.abctechservice.abctechserviceapi.application;

import br.com.abctechservice.abctechserviceapi.application.dto.AssistDTO;
import java.util.List;

public interface AssistanceApplication {

    List<AssistDTO> getAssists();
}