package game;

import javax.swing.*;
import java.awt.*;

public class about  {


    button_design back_button = new button_design ();


    public about(JFrame f)
    {

        write(f);
    }


    public void write(JFrame f) {
        back_button.back_butt ( f );
        String[] about_game = new String[]{"                                         How to Play Arkanoid",
                "          Arkanoid is a classic arcade game from the 80s by Taito.Its like bat and ball (pong) only ",
                "              its a one player game and you have to hit the bricks to make them disappear.",
                "        Once all the bricks are gone you have completed the level,and you move on to the next.",
                "     There are various 'power ups', you can collect on the way, from an enlarged bat to lasers to extra lives",
                "                                            Game Controls",
                "                                   LEFT and RIGHT arrow keys to MOVE. SPACE BAR to FIRE.",
                 "                                                 Developers" ,
                "                                                                          Nora Ekramy Ali",
                "                                                                Mohammed Ashraf Mohammed",
                "                                                                Mohammed Mahmoud Ibrahem",
                "                                                                 Bassem Hashem Mohammed",
                "                                                                    Ahmed Hossam Mohammed",
                "                                                                         Mohammed singy"

        };
        for(int i =0 ; i <= about_game.length;i++)
        {
            int hd=0;
            if(i==0 || i==5 || i==7)
            {
                hd=5;
            }

            JLabel jButton;
            jButton = new JLabel(about_game[i]);
            jButton.setBounds(0, 80+30*i, 700, 30);
            jButton.setForeground(Color.white);
            jButton.setFont(new Font("Times New Roman (Headings CS)", Font.PLAIN, 15+hd));
            Color  back_ground_color=  new Color(13, 13, 13, 255);
            jButton.setBackground(back_ground_color);
            //jButton.bo;
            f.add(jButton);
            f.setLayout(null);
            f.setVisible(true);
            f.getContentPane().setBackground(back_ground_color);


        }
    }

}
