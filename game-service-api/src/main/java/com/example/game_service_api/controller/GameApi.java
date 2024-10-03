package com.example.game_service_api.controller;

import com.example.game_service_api.commons.constants.ApiPathVariables;
import com.example.game_service_api.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public interface GameApi {
    @PostMapping
    ResponseEntity<Game> saveGame(@RequestHeader String userId, @RequestBody Game game);
    @GetMapping("/{id}")
    ResponseEntity<Game> getGameById(@PathVariable String id);
    @DeleteMapping("/{id}")
    ResponseEntity<Game> deleteGameById(@PathVariable String id);
    @PatchMapping("/{id}")
    ResponseEntity<Game> updateGameById(@PathVariable String id, @RequestBody Game updateGame);
}
