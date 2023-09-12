package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class pause {
    public boolean stat= false;
    public pause()
    {

    }
    public void pause_menu(Graphics g)
    {
        g.setColor( Color.white);
        g.setFont(new Font("Haettenschweiler" , Font.BOLD , 25));
        g.drawString("press R to resume "  , 250 ,300);

        g.setFont(new Font("Haettenschweiler" , Font.BOLD , 25));
        g.drawString("press M to go to the main menu "  , 190 ,350);
    }



}
