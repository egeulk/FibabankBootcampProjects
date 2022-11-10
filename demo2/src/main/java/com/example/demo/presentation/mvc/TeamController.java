package com.example.demo.presentation.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.data.entity.Player;
import com.example.demo.data.entity.Team;
import com.example.demo.data.repository.TeamRepository;

import java.util.ArrayList;

@Controller
@RequestMapping("/sports")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/team/insert")
    @ResponseBody
    public String insertTeam(){
        Team teamA = new Team(0, "A Spor");
        teamA.setPlayerList(new ArrayList<Player>());

        Player player1 = new Player(0, "Cem Karaca", 54.21);
        player1.setTeam(teamA);
        teamA.getPlayerList().add(player1);

        Player player2 = new Player(0, "Baris Manco", 76.12);
        player2.setTeam(teamA);
        teamA.getPlayerList().add(player2);

        Player player3 = new Player(0, "Fikret Kizilok", 34.55);
        player3.setTeam(teamA);
        teamA.getPlayerList().add(player3);

        teamRepository.save(teamA);
        return "sokuldu";
        //Player player1 = new Player(0, "")
    }


}
