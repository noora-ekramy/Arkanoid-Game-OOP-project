package game;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
public class main_menu extends javax.swing.JFrame  implements KeyListener, ActionListener {

    //f is th game frame
    JFrame f = new JFrame("Arcanoid");


    //back_g is used to carry the background image
    public BufferedImage back_g ;


    //default constructor
    public main_menu()  {


        //loading background image
        try {
            back_g = ImageIO.read(new FileInputStream("res/m_bac.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //back_g.set

        //adding the background image to the frame
       f.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(back_g, 150, 10,400 , 200, null);
            }
        });
        pack();





        //making objects from the button_design class for every main_menu in the menu
        //play
        button_design play_butt=new button_design();
        play_butt.butt_design(f , "PLAY" , 200 ,250 );

        //settings
        button_design Settings_butt=new button_design();
        Settings_butt.butt_design(f , "Settings" , 200 ,300 );

        //high score
        button_design High_Score_butt=new button_design();
        High_Score_butt.butt_design(f , "High Score" , 200 ,350 );

        //exit
        button_design exit_butt=new button_design();
        exit_butt.butt_design(f , "EXit" , 200 ,450 );

        button_design about_us_butt=new button_design();
        about_us_butt.butt_design(f , "About" , 200 ,400 );






        play_butt.jButton.addActionListener ( e -> {

            gameplay p=new gameplay();

            f.dispose();
            f=new JFrame("Arcanoid");
            f.setSize(700,600);
            f.setResizable(true);
            f.setVisible(true);
            p.get_f ( f );
            f.add(p);
        } );

        High_Score_butt.jButton.addActionListener(e -> {

            f.dispose();
            f=new JFrame("Arcanoid");
            f.setSize(700,600);
            f.setVisible(true);
            new HighscoreWindow(f);
        });

        about_us_butt.jButton.addActionListener(e -> {

            f.dispose();
            f=new JFrame("Arcanoid");
            f.setSize(700,600);

            f.setVisible(true);
            new about(f);

        });

        Settings_butt.jButton.addActionListener(e -> {


            f.dispose();
            f=new JFrame("Arcanoid");
            f.setSize(700,600);
            f.setVisible(true);
            new setting(f);

        });
        exit_butt.jButton.addActionListener(e -> f.dispose())
        ;

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}