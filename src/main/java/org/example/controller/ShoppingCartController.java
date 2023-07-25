package org.example.controller;

import org.example.dto.response.ShoppingCartResponseDto;
import org.example.model.MovieSession;
import org.example.model.ShoppingCart;
import org.example.model.User;
import org.example.service.MovieSessionService;
import org.example.service.ShoppingCartService;
import org.example.service.UserService;
import org.example.service.mapper.ResponseDtoMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart>
            shoppingCartResponseDtoMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService,
            ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart>
                                      shoppingCartResponseDtoMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartResponseDtoMapper = shoppingCartResponseDtoMapper;
    }

    @PutMapping("/movie-sessions")
    public void addToCart(Authentication auth, @RequestParam Long movieSessionId) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        String email = details.getUsername();
        User user = userService.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found"));
        return shoppingCartResponseDtoMapper.mapToDto(shoppingCartService.getByUser(user));
    }
}
