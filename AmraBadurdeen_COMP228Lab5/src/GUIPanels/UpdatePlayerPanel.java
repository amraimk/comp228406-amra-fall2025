package GUIPanels;

import db.DBPlayerGame;
import db.Player;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class UpdatePlayerPanel extends JPanel {
    private JTextField txtId, txtFirst, txtLast, txtPhone, txtPostal, txtProvince;
    private JButton btnSearch, btnUpdate;
    private DBPlayerGame dao;

    public UpdatePlayerPanel(DBPlayerGame dao) {
        this.dao = dao;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtId = new JTextField(5);
        txtFirst = new JTextField(15);
        txtLast = new JTextField(15);
        txtPhone = new JTextField(12);
        txtPostal = new JTextField(10);
        txtProvince = new JTextField(10);
        btnSearch = new JButton("Search");
        btnUpdate = new JButton("Update");

        gbc.gridx=0; gbc.gridy=0; add(new JLabel("Player ID:"), gbc);
        gbc.gridx=1; add(txtId, gbc);
        gbc.gridx=2; add(btnSearch, gbc);
        gbc.gridx=0; gbc.gridy=1; add(new JLabel("First Name:"), gbc);
        gbc.gridx=1; gbc.gridwidth=2; add(txtFirst, gbc);
        gbc.gridwidth=1; gbc.gridx=0; gbc.gridy=2; add(new JLabel("Last Name:"), gbc);
        gbc.gridx=1; gbc.gridwidth=2; add(txtLast, gbc);
        gbc.gridwidth=1; gbc.gridx=0; gbc.gridy=3; add(new JLabel("Phone:"), gbc);
        gbc.gridx=1; gbc.gridwidth=2; add(txtPhone, gbc);
        gbc.gridwidth=1; gbc.gridx=0; gbc.gridy=4; add(new JLabel("Postal:"), gbc);
        gbc.gridx=1; gbc.gridwidth=2; add(txtPostal, gbc);
        gbc.gridwidth=1; gbc.gridx=0; gbc.gridy=5; add(new JLabel("Province:"), gbc);
        gbc.gridx=1; gbc.gridwidth=2; add(txtProvince, gbc);
        gbc.gridwidth=3; gbc.gridx=0; gbc.gridy=6; add(btnUpdate, gbc);

        btnSearch.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                Player p = dao.getPlayerById(id);
                if(p != null){
                    txtFirst.setText(p.getFirstName());
                    txtLast.setText(p.getLastName());
                    txtPhone.setText(p.getPhoneNumber());
                    txtPostal.setText(p.getPostalCode());
                    txtProvince.setText(p.getProvince());
                } else JOptionPane.showMessageDialog(this,"Player not found!");
            } catch (SQLException ex) { ex.printStackTrace(); }
        });

        btnUpdate.addActionListener(e -> {
            try {
                Player p = new Player(Integer.parseInt(txtId.getText()), txtFirst.getText(), txtLast.getText(),
                        "", txtPostal.getText(), txtProvince.getText(), txtPhone.getText());
                dao.updatePlayer(p);
                JOptionPane.showMessageDialog(this,"Player updated!");
            } catch (SQLException ex) { ex.printStackTrace(); }
        });
    }
}
