package com.example.game_service_api.services;

import com.example.game_service_api.commons.entities.Game;

public interface GameService {
    Game saveGame(Game gameRequest);

    Game getGameById(String id);

    Game deleteGameById(String id);

    Game updateGameById(String id, Game updateRequest);

}
