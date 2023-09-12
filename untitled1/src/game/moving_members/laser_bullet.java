package game.moving_members;

import java.awt.*;

public class laser_bullet extends game_moving_members {
    public boolean stat=false;
    public laser_bullet(int x , int y , boolean stat)
    {
        super(x , y);
        this.stat=stat;
    }
    @Override
    public void draw( Graphics g  , int x , int y)
    {
        g.setColor(Color.RED);
        g.fillRect(x, y, 5, 30);

        g.setColor(Color.RED);
        g.fillRect(x+100, y, 5, 30);

    }
    @Override
    public void move(int speed)
    {
        if(y_position>2)
        {
            y_position-=speed;
        }
        else
        {
            stat=false;
        }

    }
}
