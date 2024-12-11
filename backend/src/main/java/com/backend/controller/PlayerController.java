package com.backend.controller;

import com.backend.dto.PlayerDto;
import com.backend.entity.Player;
import com.backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable int playerId) {
        return playerService.getPlayerById(playerId);
    }

    @PostMapping
    public Player addPlayer(@RequestBody PlayerDto playerDto) {
        return playerService.addPlayer(playerDto);
    }

    @PutMapping("/{playerId}")
    public Player updatePlayer(@PathVariable int playerId, @RequestBody PlayerDto playerDto) {
        return playerService.updatePlayer(playerId, playerDto);
    }

    @DeleteMapping("/{playerId}")
    public void deletePlayer(@PathVariable int playerId) {
        playerService.deletePlayer(playerId);
    }
}
