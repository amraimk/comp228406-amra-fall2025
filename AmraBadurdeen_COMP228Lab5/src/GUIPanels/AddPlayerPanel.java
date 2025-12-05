package GUIPanels;

import db.DBPlayerGame;
import db.Player;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;


public class AddPlayerPanel extends JPanel {
    private JTextField txtFirstName, txtLastName, txtAddress, txtPostal, txtProvince, txtPhone;
    private JButton btnAddPlayer;
    private DBPlayerGame dao;
    private RecordGamePlayPanel recordPanel;

    public AddPlayerPanel(DBPlayerGame dao, RecordGamePlayPanel recordPanel) {
        this.dao = dao;
        this.recordPanel = recordPanel;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtFirstName = new JTextField(15);
        txtLastName = new JTextField(15);
        txtAddress = new JTextField(20);
        txtPostal = new JTextField(10);
        txtProvince = new JTextField(10);
        txtPhone = new JTextField(12);
        btnAddPlayer = new JButton("Add Player");

        gbc.gridx=0; gbc.gridy=0; add(new JLabel("First Name:"), gbc);
        gbc.gridx=1; add(txtFirstName, gbc);
        gbc.gridx=0; gbc.gridy=1; add(new JLabel("Last Name:"), gbc);
        gbc.gridx=1; add(txtLastName, gbc);
        gbc.gridx=0; gbc.gridy=2; add(new JLabel("Address:"), gbc);
        gbc.gridx=1; add(txtAddress, gbc);
        gbc.gridx=0; gbc.gridy=3; add(new JLabel("Postal Code:"), gbc);
        gbc.gridx=1; add(txtPostal, gbc);
        gbc.gridx=0; gbc.gridy=4; add(new JLabel("Province:"), gbc);
        gbc.gridx=1; add(txtProvince, gbc);
        gbc.gridx=0; gbc.gridy=5; add(new JLabel("Phone:"), gbc);
        gbc.gridx=1; add(txtPhone, gbc);
        gbc.gridx=0; gbc.gridy=6; gbc.gridwidth=2; add(btnAddPlayer, gbc);

        btnAddPlayer.addActionListener(e -> {
            try {
                dao.addPlayer(new Player(0,
                        txtFirstName.getText(),
                        txtLastName.getText(),
                        txtAddress.getText(),
                        txtPostal.getText(),
                        txtProvince.getText(),
                        txtPhone.getText()));
                JOptionPane.showMessageDialog(this,"Player added!");

                txtFirstName.setText("");
                txtLastName.setText("");
                txtAddress.setText("");
                txtPostal.setText("");
                txtProvince.setText("");
                txtPhone.setText("");
            } catch (SQLException ex) { ex.printStackTrace(); }
        });
    }
}
