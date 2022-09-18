package br.com.abctechservice.abctechserviceapi.controller;

import java.io.InputStream;
import java.util.Properties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    @GetMapping("/version")
    public ResponseEntity<String> status() throws Exception {
    	Properties properties = new Properties();
    	InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.yml");
    	properties.load(inputStream);
        return ResponseEntity.ok(properties.getProperty("build.name") + " - " + properties.getProperty("build.version"));
    }
}