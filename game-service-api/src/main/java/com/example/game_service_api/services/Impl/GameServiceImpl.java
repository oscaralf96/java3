package com.example.game_service_api.services.Impl;

import com.example.game_service_api.commons.entities.Game;
import com.example.game_service_api.commons.exceptions.GameException;
import com.example.game_service_api.repositories.GameRepository;
import com.example.game_service_api.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game gameRequest) {
        return this.gameRepository.save(gameRequest);
    }

    @Override
    public Game getGameById(String id) {
        return this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Error finding game"));
    }

    @Override
    public Game deleteGameById(String id) {
        Game game = this.getGameById(id);
        this.gameRepository.deleteById(game.getId());
        return game;
    }

    @Override
    public Game updateGameById(String id, Game updateRequest) {
        return  this.gameRepository.findById(Long.valueOf(id)).map(game -> {
            game.setName(updateRequest.getName());
            return gameRepository.save(game);
        }) .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Error finding game"));
    }
}
