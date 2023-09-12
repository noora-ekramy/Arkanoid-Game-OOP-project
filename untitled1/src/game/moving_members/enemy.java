package game.moving_members;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Nora Ekramy
 */
public class enemy extends game_moving_members {

    public BufferedImage im;
    public int life=25;
    boolean diriction= true;
    public enemy() {

        super(20 , 0);
        try {
            im = ImageIO.read(getClass().getResourceAsStream("/Space-Invaders.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void draw (Graphics g , int x , int y)
    {
        this.x_position+=x;

        g.drawImage(im ,  x_position , y_position  , 200 , 200, null);
    }
    @Override
    public void move(int speed_prameter)
    {
        if(diriction) {
            x_position += speed_prameter;
        }
        else if(!diriction) {
            x_position -= speed_prameter;
        }
        if(x_position +100  > 600)
        {
            diriction=false;
        }
        else if(x_position <= 10)
        {
            diriction=true;
        }
    }
}