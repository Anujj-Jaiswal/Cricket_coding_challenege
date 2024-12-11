package com.backend.service.impl;

import com.backend.dto.PlayerDto;
import com.backend.entity.Player;
import com.backend.exception.ResourceNotFoundException;
import com.backend.repository.PlayerRepository;
import com.backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(int playerId) {
        return playerRepository.findById(playerId)
            .orElseThrow(() -> new ResourceNotFoundException("Player", "playerId", playerId));
    }


    @Override
    public Player addPlayer(PlayerDto playerDto) {
        Player player = new Player();
        player.setPlayerName(playerDto.getPlayerName());
        player.setJerseyNumber(playerDto.getJerseyNumber());
        player.setRole(playerDto.getRole());
        player.setTotalMatches(playerDto.getTotalMatches());
        player.setTeamName(playerDto.getTeamName());
        player.setCountryStateName(playerDto.getCountryStateName());
        player.setDescription(playerDto.getDescription());
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(int playerId, PlayerDto playerDto) {
        Player player = getPlayerById(playerId);
        player.setPlayerName(playerDto.getPlayerName());
        player.setJerseyNumber(playerDto.getJerseyNumber());
        player.setRole(playerDto.getRole());
        player.setTotalMatches(playerDto.getTotalMatches());
        player.setTeamName(playerDto.getTeamName());
        player.setCountryStateName(playerDto.getCountryStateName());
        player.setDescription(playerDto.getDescription());
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(int playerId) {
        Player player = getPlayerById(playerId);
        playerRepository.delete(player);
    }
}
