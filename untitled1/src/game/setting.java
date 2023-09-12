package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class setting {
    JFrame f;
    int level=1;
    Color  back_ground_color=  new Color(13, 13, 13, 255);
    button_design back_button = new button_design ();
    public setting(JFrame f)
    {
        this.f=f;
        select_level();
    }


    public void select_level()
    {
        back_button.back_butt ( f );
        JTextField k = new JTextField();
        k.setBounds(200, 250, 200, 50);
        k.setForeground(Color.white);
        k.setFont(new Font("Algerian", Font.PLAIN, 40));
        k.setBackground(back_ground_color);
        f.add(k);
        f.getContentPane().setBackground(back_ground_color);

        k.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {


            }

            @Override
            public void keyPressed(KeyEvent e) {
                try {


                level= Integer.parseInt(String.valueOf(e.getKeyChar()));}
                catch (Exception ignored) {
                }
                finally {


                if(e.getKeyCode()==KeyEvent.VK_ENTER)

                {
                gameplay p=new gameplay(level);
                f.dispose();
                f=new JFrame("Arcanoid");
                f.setSize(700,600);
                f.setResizable(true);
                f.setVisible(true);
                f.add(p);}}
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
}
