package br.com.abctechservice.abctechserviceapi.application.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderDTO {
    private Long operatorId;
    private List<Long> assists;
    private OrderLocationDTO start;
    private OrderLocationDTO end;
}