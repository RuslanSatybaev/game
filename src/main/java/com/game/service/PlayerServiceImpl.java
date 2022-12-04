package com.game.service;

import com.game.entity.Player;
import com.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PlayerServiceImpl.class);
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    @Transactional
    public List<Player> getAllPlayers() {
        Iterable<Player> all = null;

        try {
            all = playerRepository.findAll();
        } catch (Exception ex) {
            /* below works in conjunction with concrete logging framework */
            logger.error(ex.getMessage(), ex);
            throw ex;
        }

        List<Player> target = new ArrayList<>();
        all.forEach(target::add);
        return target;
    }

    @Override
    @Transactional
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    @Transactional
    public Player getPlayer(Long id) {
        return playerRepository.findPlayerById(id);
    }

    @Override
    @Transactional
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}

