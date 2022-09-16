package br.com.abctechservice.abctechserviceapi.service;

import br.com.abctechservice.abctechserviceapi.model.Assistance;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AssistanceService {

    List<Assistance> getAssitanceList();
}