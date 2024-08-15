import java.awt.*;

public class Ball {
    private final Pong game;

    //Position
    private int x;
    private int y;

    //Ball Diameter
    private final int d = 10;

    //Court border
    private final int gameWidth;
    private final int gameHeight;

    //Ball Speed
    private int xa = 1;
    private int ya = -1;
    private int xs = 5;
    private int ys = 2;

    public Ball(Pong game, int x, int y) {
        this.x = x;
        this.y = y;
        this.game = game;
        this.gameWidth = game.getWidth();
        this.gameHeight = game.getHeight();
    }

    public void update() {
        if(y <= 0 || y >= gameHeight - 50){
            ya = (ya * -1);
        }

        if(x > gameWidth || x < 0){
            if(x > gameWidth){
                game.getPanel().increaseScore(1);
                x = gameWidth/2;
                y = game.getPanel().getPlayer(1).y + 25;
                ys = 0;
                xa = -1;
            }else {
                game.getPanel().increaseScore(2);
                x = gameWidth/2;
                y = game.getPanel().getPlayer(2).y + 25;
                ys = 0;
                xa = 1;
            }
            xs = 5;

            if(game.getPanel().getScore(1) == 0 && game.getPanel().getScore(2) == 0) {
                int rand_int1 = (int) (Math.random() * 2);
                if (rand_int1 == 0) {
                    if (xa == -1) {
                        xa = 1;
                    }
                } else {
                    xa = -1;
                }
            }
        }

        if(xa > 0 ){
            x += xs;
        }else {
            x -= xs;
        }

        if(ya > 0){
            y += ys;
        }else {
            y -= ys;
        }

        checkCollision();
    }

     public void checkCollision() {
        if (game.getPanel().getPlayer(1).getBounds().intersects(getBounds()) || game.getPanel().getPlayer(2).getBounds().intersects(getBounds())) {
            xa = (xa * -1);
            xs = 10;
            ys = 2;
        }
    }

    private Rectangle getBounds() {
        return new Rectangle(x, y, d, d);
    }

    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x, y, d, d);

    }

}