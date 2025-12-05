package GUIPanels;

import db.DBPlayerGame;
import db.Player;
import db.Game;
import db.PlayerAndGame;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class RecordGamePlayPanel extends JPanel {
    private JComboBox<Player> comboPlayer;
    private JComboBox<Game> comboGame;
    private JTextField txtScore, txtDate;
    private JButton btnRecord;
    private DBPlayerGame dao;
    private RecordGamePlayPanel recordPanel;

    public void refreshGames() {
        try {
            comboGame.removeAllItems();
            List<Game> games = dao.getAllGames();
            for (Game g : games) comboGame.addItem(g);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void refreshPlayers() {
        try {
            comboPlayer.removeAllItems();
            List<Player> players = dao.getAllPlayers();
            for (Player p : players) comboPlayer.addItem(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RecordGamePlayPanel(DBPlayerGame dao) {
        this.dao = dao;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        comboPlayer = new JComboBox<>();
        comboGame = new JComboBox<>();
        txtScore = new JTextField(5);
        txtDate = new JTextField(10);
        btnRecord = new JButton("Record Game Play");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Player:"), gbc);
        gbc.gridx = 1;
        add(comboPlayer, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Game:"), gbc);
        gbc.gridx = 1;
        add(comboGame, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Score:"), gbc);
        gbc.gridx = 1;
        add(txtScore, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Date YYYY-MM-DD:"), gbc);
        gbc.gridx = 1;
        add(txtDate, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(btnRecord, gbc);

        // Populate ComboBoxes
        try {
            List<Player> players = dao.getAllPlayers();
            for (Player p : players) {
                comboPlayer.addItem(p);
            }

            List<Game> games = dao.getAllGames();
            for (Game g : games) {
                comboGame.addItem(g);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        btnRecord.addActionListener(e -> {
            Player p = (Player) comboPlayer.getSelectedItem();
            Game g = (Game) comboGame.getSelectedItem();
            if (p == null || g == null || txtScore.getText().isEmpty() || txtDate.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill all fields!");
                return;
            }
            try {
                int score = Integer.parseInt(txtScore.getText());
                Date date = Date.valueOf(txtDate.getText());
                dao.recordGamePlay(new PlayerAndGame(p.getId(), g.getId(), date, score));
                JOptionPane.showMessageDialog(this, "Game Recorded!");

                txtScore.setText("");
                txtDate.setText("");

                if (recordPanel != null) {
                    recordPanel.refreshPlayers(); // call a method to reload player list
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });
    }
}
