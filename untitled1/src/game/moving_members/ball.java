package game.moving_members;

import java.awt.*;

public class ball extends  game_moving_members{
    public  int x_diriction_movement=-2;
    public  int ball_y_diriction=-3;
    public ball() {
        super ( 120, 350 );

    }

    @Override
    public void move(int speed) {
        x_position+=x_diriction_movement;
        y_position+=ball_y_diriction;
        if(x_position<0)
        {
            x_diriction_movement=-x_diriction_movement;
        }
        if(y_position<0)
        {
            ball_y_diriction=-ball_y_diriction;
        }
        if(x_position>670)
        {
            x_diriction_movement=-x_diriction_movement;
        }

    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.white);
        g.fillOval(x, y, 20, 20);
        }

    }

