package br.com.abctechservice.abctechserviceapi.repository;

import br.com.abctechservice.abctechserviceapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}