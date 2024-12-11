package com.backend.service;

import com.backend.dto.PlayerDto;
import com.backend.entity.Player;

import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayers();
    Player getPlayerById(int playerId);
    Player addPlayer(PlayerDto playerDto);
    Player updatePlayer(int playerId, PlayerDto playerDto);
    void deletePlayer(int playerId);
}
