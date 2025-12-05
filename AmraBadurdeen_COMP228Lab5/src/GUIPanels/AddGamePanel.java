package GUIPanels;

import db.DBPlayerGame;
import db.Game;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class AddGamePanel extends JPanel {
    private JTextField txtTitle;
    private JButton btnAddGame;
    private DBPlayerGame dao;
    private RecordGamePlayPanel recordPanel;

    public AddGamePanel(DBPlayerGame dao, RecordGamePlayPanel recordPanel) {
        this.dao = dao;
        this.recordPanel = recordPanel;
        setLayout(new FlowLayout());
        txtTitle = new JTextField(20);
        btnAddGame = new JButton("Add Game");
        add(new JLabel("Game Title:"));
        add(txtTitle);
        add(btnAddGame);

        btnAddGame.addActionListener(e -> {
            try {
                dao.addGame(new Game(0, txtTitle.getText()));
                JOptionPane.showMessageDialog(this,"Game added!");
                txtTitle.setText("");

                if (recordPanel != null) {
                    recordPanel.refreshGames(); // call a method to reload the game list
                }

            } catch (SQLException ex) { ex.printStackTrace(); }
        });
    }
}
