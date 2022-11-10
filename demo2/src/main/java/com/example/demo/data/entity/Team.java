package com.example.demo.data.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teamId;

    private String teamName;

    @OneToMany(mappedBy = "team", cascade= CascadeType.ALL,
            fetch=FetchType.EAGER)
    private List<Player> playerList;

    public Team(long teamId, String teamName) {
        this.teamId = teamId;
        this.playerList = playerList;
        this.teamName = teamName;
    }

    public Team() {

    }



    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
