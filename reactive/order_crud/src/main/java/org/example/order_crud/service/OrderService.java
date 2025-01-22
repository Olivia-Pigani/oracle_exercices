package org.example.order_crud.service;

import org.example.order_crud.domain.entity.Order;
import org.example.order_crud.domain.enumeration.OrderStatus;
import org.example.order_crud.repository.OrderRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Order> getOrderById(long id) {
        return orderRepository.findById(id);
    }

    public Mono<Order> saveAOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }

    public Mono<Order> updateAOrder(long id, Order orderNewData) {
        return orderRepository.findById(id)
                .flatMap(o -> {
                    o.setName(orderNewData.getName());
                    o.setTotalAmount(orderNewData.getTotalAmount());
                    o.setStatus(OrderStatus.fromString(orderNewData.getStatus()));
                    return orderRepository.save(o);
                });
    }

    public Mono<Void> deleteAOrder(long id) {
        return orderRepository.deleteById(id);
    }

    ///api/order/search?status=SHIPPED
    public Flux<Order> getAllOrderByStatus(OrderStatus status) {
        return orderRepository.getOrderByStatus(OrderStatus.fromEnum(status));
    }

    ///api/order/paged?page=0&size=5
    public Flux<Order> getPaginatedOrders(int page, int size) {
        Pageable paging = PageRequest.of(page, size);

        return orderRepository.findAllBy(paging);
    }


}
