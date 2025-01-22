package org.example.order_crud.handler;

import org.example.order_crud.domain.entity.Order;
import org.example.order_crud.domain.enumeration.OrderStatus;
import org.example.order_crud.service.OrderService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.web.reactive.function.server.ServerResponse.*;


@Component
public class OrderHandler {

    private final OrderService orderService;

    public OrderHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    public Mono<ServerResponse> getAllOrders(ServerRequest serverRequest) {
        return ok().body(orderService.getAllOrders(), Order.class);
    }

    public Mono<ServerResponse> getOrderById(ServerRequest serverRequest) {
        long id = Long.parseLong(serverRequest.pathVariable("id"));

        return orderService.getOrderById(id)
                .flatMap(o -> ok().bodyValue(o))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> saveAOrder(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Order.class)
                .flatMap(orderService::saveAOrder)
                .flatMap(o -> ok().body(Mono.just(o),Order.class));
    }

    public Mono<ServerResponse> updateAnOrder(ServerRequest serverRequest){
        long id = Long.parseLong(serverRequest.pathVariable("id"));

        return serverRequest.bodyToMono(Order.class)
                .flatMap(order -> orderService.updateAOrder(id, order))
                .flatMap(order -> ok().bodyValue(order))
                .switchIfEmpty(notFound().build())
                .onErrorResume(e -> badRequest().bodyValue(e.getMessage()));
    }

    public Mono<ServerResponse> deleteAnOrder(ServerRequest serverRequest) {
        long id = Long.parseLong(serverRequest.pathVariable("id"));

        return orderService.deleteAOrder(id)
                .then(noContent().build())
                .onErrorResume(e -> badRequest().bodyValue(e.getMessage()));
    }

    public Mono<ServerResponse> getAllOrdersByStatus(ServerRequest serverRequest) {
        Optional<String> statusOpt =serverRequest.queryParam("status");
        String status = "";
        if (statusOpt.isPresent()){
            status = statusOpt.get();
        }
        System.out.println(status);
        return orderService.getAllOrderByStatus(OrderStatus.fromString(status))
                .collectList()
                .flatMap(orders -> ok().bodyValue(orders))
                .switchIfEmpty(notFound().build())
                .onErrorResume(e -> badRequest().bodyValue(e.getMessage()));
    }

    public Mono<ServerResponse> getPaginatedOrders(ServerRequest serverRequest) {
        Optional<String> pageOpt = serverRequest.queryParam("page");
        Optional<String> sizeOpt = serverRequest.queryParam("size");

        int page = 0;
        int size = 0;

        if (pageOpt.isPresent() && sizeOpt.isPresent()){

            page = Integer.parseInt(pageOpt.get());
            size = Integer.parseInt(sizeOpt.get());


        }

        return orderService.getPaginatedOrders(page,size)
                .collectList()
                .flatMap(orders -> ok().bodyValue(orders))
                .switchIfEmpty(notFound().build())
                .onErrorResume(e -> badRequest().bodyValue(e.getMessage()));
    }

}























