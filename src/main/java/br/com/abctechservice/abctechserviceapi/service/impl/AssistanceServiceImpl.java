package br.com.abctechservice.abctechserviceapi.service.impl;

import br.com.abctechservice.abctechserviceapi.model.Assistance;
import br.com.abctechservice.abctechserviceapi.repository.AssistanceRepository;
import br.com.abctechservice.abctechserviceapi.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssistanceServiceImpl implements AssistanceService {

    private final AssistanceRepository assistanceRepository;

    @Autowired
    public AssistanceServiceImpl(AssistanceRepository assistanceRepository) {
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public List<Assistance> getAssitanceList() {
        return assistanceRepository.findAll();
    }
}