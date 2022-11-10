package com.example.demo.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.data.entity.Player;
import com.example.demo.data.entity.Team;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {


    List<Player> findAllByTeamId(long teamId);
}
