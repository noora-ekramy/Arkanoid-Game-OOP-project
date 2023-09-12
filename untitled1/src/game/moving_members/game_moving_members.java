package game.moving_members;

import java.awt.*;

public abstract class game_moving_members {
    public int x_position;
    public int y_position;
    public game_moving_members(int x_position , int y_position)
    {
        this.x_position=x_position;
        this.y_position=y_position;
    }
    public abstract void move(int speed);
    public abstract void draw(Graphics g , int x , int y);
}
