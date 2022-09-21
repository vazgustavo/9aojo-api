package br.com.abctechservice.abctechserviceapi.application;

import br.com.abctechservice.abctechserviceapi.model.Assistance;
import java.util.List;

public interface AssistanceApplication {
    List<Assistance> getAssists();
}