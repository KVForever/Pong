import java.awt.*;

public class Player {
    //Game
    Pong game;

    //Current position
    public final int x;
    public int y;

    //Change in position
    private int yChange = 0;

    //Size
    final int w = 10;
    final int h = 55;

    // Court Boundaries
    double gameWidth;
    double gameHeight;

    //Player Boundaries


    public Player(Pong game, int x, int y, int gameWidth, int gameHeight) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
    }

    public void update(Player player) {
        if (player.y > 0 && player.y < gameHeight - 90)
            player.y += yChange;
        else if (player.y <= 0)
            player.y++;
        else if (player.y >= gameHeight - 90)
            player.y--;
    }

    public void pressed(int keyCode) {
        if (keyCode == 73) {
            yChange = -5;
            //update(game.getPanel().getPlayer(1));
        }
        else if (keyCode == 75) {
            yChange = 5;
            //update(game.getPanel().getPlayer(1));
        }
        else if (keyCode == 87){
            yChange = -5;
            //update(game.getPanel().getPlayer(2));
        }else if(keyCode == 83){
            yChange = 5;
            //update(game.getPanel().getPlayer(2));
        }
    }

    public void released(int keyCode) {
        if (keyCode == 73 || keyCode == 75)
            yChange = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x, y, w, h);

    }

}
