package db;

import java.sql.Date;

public class PlayerAndGame {
    private int playerId;
    private int gameId;
    private Date playingDate;
    private int score;

    // Constructor
    public PlayerAndGame(int playerId, int gameId, Date playingDate, int score) {
        this.playerId = playerId;
        this.gameId = gameId;
        this.playingDate = playingDate;
        this.score = score;
    }

    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Date getPlayingDate() {
        return playingDate;
    }

    public void setPlayingDate(Date playingDate) {
        this.playingDate = playingDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
