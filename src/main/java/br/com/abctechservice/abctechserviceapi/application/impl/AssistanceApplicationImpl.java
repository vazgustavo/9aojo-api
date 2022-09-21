package br.com.abctechservice.abctechserviceapi.application.impl;

import br.com.abctechservice.abctechserviceapi.application.AssistanceApplication;
import br.com.abctechservice.abctechserviceapi.model.Assistance;
import br.com.abctechservice.abctechserviceapi.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AssistanceApplicationImpl implements AssistanceApplication {

    private AssistanceService assistanceService;

    public AssistanceApplicationImpl(@Autowired AssistanceService assistanceService) {
        this.assistanceService = assistanceService;
    }
    @Override
    public List<Assistance> getAssists() {
        return assistanceService.getAssitanceList();
    }
}