package org.example.service.mapper;

import org.example.dto.response.OrderResponseDto;
import org.example.model.Order;
import org.example.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setUserId(order.getUser().getId());
        responseDto.setOrderTime(order.getOrderTime());
        responseDto.setTicketIds(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .toList());
        return responseDto;
    }
}
