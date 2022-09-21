package br.com.abctechservice.abctechserviceapi.controller;

import br.com.abctechservice.abctechserviceapi.application.AssistanceApplication;
import br.com.abctechservice.abctechserviceapi.model.Assistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/assistance")
public class AssistanceController {

    private AssistanceApplication assistanceApplication;

    public AssistanceController(@Autowired AssistanceApplication assistanceApplication) {
        this.assistanceApplication = assistanceApplication;
    }

    @GetMapping()
    public ResponseEntity<List<Assistance>> getLista() {
        return ResponseEntity.ok(assistanceApplication.getAssists());
    }
}