package com.game.repository;

import com.game.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from Player p where p.id = :id")
    Player findPlayerById(long id);

    @Query("select p from Player p")
    List<Player> findAllPlayer();
}
