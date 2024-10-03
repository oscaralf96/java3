package com.example.game_service_api.controller.impl;

import com.example.game_service_api.commons.entities.Game;
import com.example.game_service_api.controller.GameApi;
import com.example.game_service_api.services.GameService;
import com.example.game_service_api.services.Impl.GameServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController implements GameApi {

    private final GameServiceImpl gameService;

    public GameController(GameServiceImpl gameService) {
        this.gameService = gameService;
    }


    @Override
    public ResponseEntity<Game> saveGame(@RequestHeader("userIdRequest") String userId, @RequestBody Game game) {
        System.out.println(userId);

        return ResponseEntity.ok(this.gameService.saveGame(game));
    }

    @Override
    public ResponseEntity<Game> getGameById(String id) {
        return ResponseEntity.ok(this.gameService.getGameById(id));
    }

    @Override
    public ResponseEntity<Game> deleteGameById(String id) {
        return ResponseEntity.ok(this.gameService.deleteGameById(id));
    }

    @Override
    public ResponseEntity<Game> updateGameById(String id, @RequestBody Game updateRequest) {
        return ResponseEntity.ok(this.gameService.updateGameById(id, updateRequest));
    }
}
