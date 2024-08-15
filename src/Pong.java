import javax.swing.JFrame;
import java.awt.*;

public class Pong extends JFrame {
    JFrame frame;
    PongCourt court;

    public Pong() {
        this.frame = new JFrame("Java 2D Graphics Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        court = new PongCourt(this);
        court.setOpaque(true);
        court.setBackground(Color.BLACK);
        frame.add(court);
        frame.setVisible(true);
    }

    public void startGame() {



    }

    public int getHeight() {
        return frame.getHeight();
    }

    public int getWidth() {
        return frame.getWidth();
    }

    public PongCourt getPanel() {
        return court;
    }

}
