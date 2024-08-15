import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PongCourt extends JPanel implements KeyListener, ActionListener {
    Player player1;
    Player player2;
    Ball ball;
    int score1;
    int score2;
    Pong game;
    int moving;

    public PongCourt(Pong game) {
        this.game = game;
        int height = game.getHeight();
        int width = game.getWidth();
        this.player1 = new Player(game, 0, height/2, width, height);
        this.player2 = new Player(game, width - 25, height/2, width, height);
        this.ball = new Ball(game, height/2, width/2);
        Timer timer = new Timer(5, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public Player getPlayer(int playerNo) {
        if (playerNo == 1)
            return player1;
        else
            return player2;
    }

    public void increaseScore(int playerNo) {
        if (playerNo == 1)
            score1++;
        else
            score2++;
    }

    public int getScore(int playerNo) {
        if (playerNo == 1)
            return score1;
        else
            return score2;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player1.pressed(e.getKeyCode());
        player2.pressed(e.getKeyCode());
        if(e.getKeyCode() == 73 || e.getKeyCode() == 75){
            moving = 1;
        }
        if(e.getKeyCode() == 87 || e.getKeyCode() == 83){
            moving = 2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player1.released(e.getKeyCode());
        player2.released(e.getKeyCode());
        moving = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typed events here

    }

    private void update() {
        ball.update();
        if(moving == 1){
            player1.update(player1);
        }
        if(moving == 2){
            player2.update(player2);
        }


    }

    // Implementing the ActionListener method
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle action events here
        // Example: update game state
        update();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.black);

        // Drawing code goes here
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(game.getPanel().getScore(1) + " : " + game.getPanel().getScore(2), game.getWidth() / 2, 30);
        ball.paint(g);
        player1.paint(g);
        player2.paint(g);

    }
}
