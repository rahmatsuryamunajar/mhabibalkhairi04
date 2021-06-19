package JTable;
import javax.swing.*;

public class Runpengurutan {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                UnsupportedLookAndFeelException ignored) {
        }

        JFrame jFrame = new JFrame("form sorting");
        jFrame.setContentPane(new Pengurutan().getrootPanel1());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 250);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}

