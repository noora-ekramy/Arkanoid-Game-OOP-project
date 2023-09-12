package game;

import java.awt.*;

public class laser {

    public boolean laser_mode;
    public int duration_;
    int x;


    public laser(int a , boolean b)
    {
        this.laser_mode=b;
        this.duration_=a;
    }

    public void draw(Graphics2D g , int x1 , int x2)
    {
        this.x=x1;
        g.setColor(Color.RED);
        g.fillRect(x1, 550, 10, 8);
        g.setColor(Color.RED);
        g.fillRect(x2, 550, 10, 8);

    }
}
