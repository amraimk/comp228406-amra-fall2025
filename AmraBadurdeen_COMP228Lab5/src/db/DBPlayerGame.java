package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBPlayerGame {

    // ----- Player -----
    public void addPlayer(Player player) throws SQLException {
        String sql = "INSERT INTO Player(first_name,last_name,address,postal_code,province,phone_number) VALUES(?,?,?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, player.getFirstName());
            pst.setString(2, player.getLastName());
            pst.setString(3, player.getAddress());
            pst.setString(4, player.getPostalCode());
            pst.setString(5, player.getProvince());
            pst.setString(6, player.getPhoneNumber());
            pst.executeUpdate();
        }

    }

    public Player getPlayerById(int id) throws SQLException {
        String sql = "SELECT * FROM Player WHERE player_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                return new Player(
                        rs.getInt("player_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("postal_code"),
                        rs.getString("province"),
                        rs.getString("phone_number")
                );
            }
        }
        return null;
    }

    public void updatePlayer(Player player) throws SQLException {
        String sql = "UPDATE Player SET first_name=?, last_name=?, phone_number=?, postal_code=?, province=? WHERE player_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, player.getFirstName());
            pst.setString(2, player.getLastName());
            pst.setString(3, player.getPhoneNumber());
            pst.setString(4, player.getPostalCode());
            pst.setString(5, player.getProvince());
            pst.setInt(6, player.getId());
            pst.executeUpdate();
        }
    }

//    public List<Player> getAllPlayers() throws SQLException {
//        List<Player> players = new ArrayList<>();
//        String sql = "SELECT * FROM Player";
//        try(Connection conn = DBConnection.getConnection();
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql)) {
//            while(rs.next()) {
//                players.add(new Player(
//                        rs.getInt("player_id"),
//                        rs.getString("first_name"),
//                        rs.getString("last_name"),
//                        rs.getString("address"),
//                        rs.getString("postal_code"),
//                        rs.getString("province"),
//                        rs.getString("phone_number")
//                ));
//            }
//        }
//        return players;
//    }


    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM Player";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                players.add(new Player(
                        rs.getInt("player_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("postal_code"),
                        rs.getString("province"),
                        rs.getString("phone_number")
                ));
            }
        }
        return players;
    }

    // ----- db.Game -----
    public void addGame(Game game) throws SQLException {
        String sql = "INSERT INTO Game(game_title) VALUES(?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, game.getTitle());
            pst.executeUpdate();
        }
    }

    public List<Game> getAllGames() throws SQLException {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT * FROM Game";
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                games.add(new Game(rs.getInt("game_id"), rs.getString("game_title")));
            }
        }
        return games;
    }

    // ----- db.Player and db.Game -----
    public void recordGamePlay(PlayerAndGame pg) throws SQLException {
        String sql = "INSERT INTO PlayerAndGame(player_id, game_id, playing_date, score) VALUES(?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, pg.getPlayerId());
            pst.setInt(2, pg.getGameId());
            pst.setDate(3, pg.getPlayingDate());
            pst.setInt(4, pg.getScore());
            pst.executeUpdate();
        }
    }

    public List<String[]> getPlayerGames(int playerId) throws SQLException {
        List<String[]> results = new ArrayList<>();
        String sql = "SELECT p.first_name, p.last_name, g.game_title, pg.playing_date, pg.score " +
                "FROM PlayerAndGame pg " +
                "JOIN Player p ON pg.player_id = p.player_id " +
                "JOIN Game g ON pg.game_id = g.game_id " +
                "WHERE p.player_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, playerId);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                results.add(new String[]{
                        rs.getString("first_name")+" "+rs.getString("last_name"),
                        rs.getString("game_title"),
                        rs.getDate("playing_date").toString(),
                        String.valueOf(rs.getInt("score"))
                });
            }
        }
        return results;
    }
}
