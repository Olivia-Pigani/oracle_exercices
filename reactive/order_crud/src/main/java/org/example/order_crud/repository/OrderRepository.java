package org.example.order_crud.repository;

import org.example.order_crud.domain.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {

    Flux<Order> getOrderByStatus(String status);

    Flux<Order> findAllBy(Pageable pageable);

}
