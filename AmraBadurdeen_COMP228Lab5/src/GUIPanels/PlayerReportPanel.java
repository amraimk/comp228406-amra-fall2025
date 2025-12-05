package GUIPanels;

import db.DBPlayerGame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class PlayerReportPanel extends JPanel {
    private JTextField txtPlayerId;
    private JButton btnShow;
    private JTable table;
    private DefaultTableModel model;
    private DBPlayerGame dao;

    public PlayerReportPanel(DBPlayerGame dao) {
        this.dao = dao;
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        txtPlayerId = new JTextField(5);
        btnShow = new JButton("Show Games");
        top.add(new JLabel("Player ID:"));
        top.add(txtPlayerId);
        top.add(btnShow);

        model = new DefaultTableModel(new String[]{"Player","Game","Date","Score"},0);
        table = new JTable(model);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnShow.addActionListener(e -> {
            model.setRowCount(0);
            try {
                int playerId = Integer.parseInt(txtPlayerId.getText());
                List<String[]> data = dao.getPlayerGames(playerId);
                for(String[] row: data) model.addRow(row);
            } catch(SQLException ex){ ex.printStackTrace(); }
        });
    }
}
