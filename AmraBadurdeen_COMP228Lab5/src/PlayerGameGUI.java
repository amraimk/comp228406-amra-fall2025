import javax.swing.*;
import GUIPanels.AddPlayerPanel;
import GUIPanels.AddGamePanel;
import GUIPanels.PlayerReportPanel;
import GUIPanels.UpdatePlayerPanel;
import GUIPanels.RecordGamePlayPanel;
import db.DBPlayerGame;


public class PlayerGameGUI extends JFrame {

    public PlayerGameGUI() {
        setTitle("Player Game App");
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DBPlayerGame dao = new DBPlayerGame();
        JTabbedPane tabbedPane = new JTabbedPane();
        RecordGamePlayPanel recordPanel = new RecordGamePlayPanel(dao);

        tabbedPane.add("Add Player", new AddPlayerPanel(dao, recordPanel));
        tabbedPane.add("Add Game", new AddGamePanel(dao, recordPanel));
        tabbedPane.add("Update Player", new UpdatePlayerPanel(dao));
        tabbedPane.add("Record Game Play", recordPanel);
        tabbedPane.add("Player Games", new PlayerReportPanel(dao));

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlayerGameGUI().setVisible(true));
    }
}
