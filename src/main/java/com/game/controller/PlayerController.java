package com.game.controller;

import com.game.entity.Player;
import com.game.exception.NotFoundException;
import com.game.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> showAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/count")
    public Long showPlayerCount() {
        return 10L;
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return checkPlayer(id);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return player;
    }

    @PutMapping("/players")
    public Player updatePlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return player;
    }

    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable Long id) {
        checkPlayer(id);
        playerService.deletePlayer(id);
        return "Player with ID " + id + " was deleted";
    }

    private Player checkPlayer(Long id) {
        Player player = playerService.getPlayer(id);
        if (player == null) {
            throw new NotFoundException(
                    "There is no player with ID = " +
                            id + " in Database");
        }
        return player;
    }
}

