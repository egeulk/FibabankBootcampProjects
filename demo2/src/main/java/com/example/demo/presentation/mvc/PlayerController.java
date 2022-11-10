package com.example.demo.presentation.mvc;

import com.example.demo.configuration.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.data.entity.Player;
import com.example.demo.data.repository.PlayerRepository;

import java.util.List;

@Controller
@RequestMapping("/sports")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private MyBean myBean;

    @GetMapping("/players/byteam")
    @ResponseBody
    public String getPlayersByTeam(){
        long teamId = 2;
        List<Player> players = playerRepository.findAllByTeamId(teamId);
        double totalScore=0;
        for(Player player : players){
            totalScore += player.getAverageScore();

            System.out.println(player.getPlayerId() + " "
            + player.getPlayerName()
            + player.getAverageScore());
        }
        double averageScore=0;
        if (players.size() > 0){
            averageScore = totalScore/players.size();
        }
        return "Ortalama skor: "+ averageScore;
    }
}
