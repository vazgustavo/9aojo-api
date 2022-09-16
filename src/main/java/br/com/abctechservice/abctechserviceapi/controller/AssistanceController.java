package br.com.abctechservice.abctechserviceapi.controller;

import br.com.abctechservice.abctechserviceapi.model.Assistance;
import br.com.abctechservice.abctechserviceapi.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/assistance")
public class AssistanceController {

    private AssistanceService assistanceService;

    @Autowired
    public AssistanceController(AssistanceService assistanceService) {
        this.assistanceService = assistanceService;
    }

    @GetMapping()
    public ResponseEntity<List<Assistance>> getLista() {
        List<Assistance> assistances = assistanceService.getAssitanceList();
        return ResponseEntity.ok(assistances);
    }
}