package br.com.abctechservice.abctechserviceapi.repository;

import br.com.abctechservice.abctechserviceapi.model.Assistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistanceRepository extends JpaRepository<Assistance,Long> {

}