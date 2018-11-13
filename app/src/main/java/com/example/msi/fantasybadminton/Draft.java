package com.example.msi.fantasybadminton;

import java.util.List;

public class Draft {
    private List<Player> players;
    private int leftPlayer;
    private int rightPlayer;
    private int middlePlayer;

    public Draft(List<Player> players, int leftPlayer, int rightPlayer, int middlePlayer) {
        this.players = players;
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
        this.middlePlayer = middlePlayer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getLeftPlayer() {
        return leftPlayer;
    }

    public void setLeftPlayer(int leftPlayer) {
        this.leftPlayer = leftPlayer;
    }

    public int getRightPlayer() {
        return rightPlayer;
    }

    public void setRightPlayer(int rightPlayer) {
        this.rightPlayer = rightPlayer;
    }

    public int getMiddlePlayer() {
        return middlePlayer;
    }

    public void setMiddlePlayer(int middlePlayer) {
        this.middlePlayer = middlePlayer;
    }

    public void nextRound(){
        leftPlayer+=3;
        middlePlayer+=3;
        rightPlayer+=3;
    }
}
