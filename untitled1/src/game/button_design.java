package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;


public class button_design {
    //declaring the jButton variable
    public JButton jButton;

    //default constructor is not necessary so we mad a void function to add properties
    public void butt_design (JFrame f , String butt_text , int x_position , int y_position )
    {


        jButton = new JButton(butt_text);
        jButton.setBounds(x_position, y_position, 300, 50);
        jButton.setForeground(Color.white);
        jButton.setFont(new Font("Algerian", Font.PLAIN, 40));
        Color  back_ground_color=  new Color(13, 13, 13, 255);
        jButton.setBackground(back_ground_color);
        jButton.setBorderPainted(false);
        f.add(jButton);
        f.setSize(700,600);
        f.setLayout(null);
        f.setVisible(true);
        f.getContentPane().setBackground(back_ground_color);

        //changing the background when the mouse enter
        jButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton.setBackground(Color.GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton.setBackground(back_ground_color);
            }

    }
    );
}
public void back_butt(JFrame f)
{
    jButton = new JButton("back");
    jButton.setBounds(1, 1, 160, 40);
    jButton.setForeground(Color.white);
    jButton.setFont(new Font("Algerian", Font.PLAIN, 20));
    Color  back_ground_color=  new Color(13, 13, 13, 255);
    jButton.setBackground(back_ground_color);
    jButton.setBorderPainted(false);
    f.add(jButton);
    f.setSize(700,600);
    f.setLayout(null);
    f.setVisible(true);
    f.getContentPane().setBackground(back_ground_color);

    //changing the background when the mouse enter
    jButton.addMouseListener(new java.awt.event.MouseAdapter() {
                                 @Override
                                 public void mouseClicked(MouseEvent e) {
                                     super.mouseClicked ( e );
                                     f.dispose ();
                                     new main_menu ();
                                 }
                             }
    );


}

}
