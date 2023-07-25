package org.example.service.mapper;

import org.example.dto.response.ShoppingCartResponseDto;
import org.example.model.ShoppingCart;
import org.example.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper implements
        ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .toList());
        return responseDto;
    }
}
