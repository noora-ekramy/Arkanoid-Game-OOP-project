package game;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

public class HighscoreWindow extends JPanel {

    private final HighscoreFile highscoreFile = new HighscoreFile();
    private final String scores = highscoreFile.read_score ();
    public button_design back_button = new button_design ();
    Color  back_ground_color=  new Color(13, 13, 13, 255);
    Color  te_col=new Color ( 8, 32, 106, 255 );
    JFrame f;



    public  HighscoreWindow(JFrame f )
    {
        this.f=f;

        paint();

    }
    public void paint( ) {
        f.getContentPane().setBackground(back_ground_color);
        String[] scorearr = scores.split ( "\n" );


        back_button.back_butt ( f );
        draw_text ( "Arcanoid" , 170 , 100 , 60  , te_col);
        draw_text ( "Rank" , 50 , 200 , 30 , te_col);
        draw_text ( "name" , 150 , 200 , 30 , te_col);
        draw_text ( "scour" , 500 , 200 , 30  ,  te_col);

        for(int i = 1 ; i <= 5 ; i ++)
        {
            if(i< scorearr.length ) {
                String[] s1;
                s1 = scorearr[i].split ( ":" );
                draw_text ( String.valueOf ( i ), 50, 200 + i * 50, 30, Color.white );
                draw_text ( s1[0], 150, 200 + i * 50, 30, Color.white );
                draw_text ( s1[1], 500, 200 + i * 50, 30, Color.white );

            }
            else
            {
                draw_text ( String.valueOf ( i ), 50, 200 + i * 50, 30, Color.white );
                draw_text ( ".....", 150, 200 + i * 50, 30, Color.white );
                draw_text ( ".....", 500, 200 + i * 50, 30, Color.white );
            }


        }





    }
    public void draw_text(String text , int x , int y , int size , Color col )
    {
        JLabel jButton;
        jButton = new JLabel(text);
        jButton.setBounds(x, y, 700, 50);
        jButton.setForeground(col);
        jButton.setFont(new Font("Snap ITC", Font.PLAIN, size));
        Color  back_ground_color=  new Color(13, 13, 13, 255);
        jButton.setBackground(back_ground_color);
        //jButton.bo;
        f.add(jButton);
        f.setLayout(null);
        f.setVisible(true);
        f.getContentPane().setBackground(back_ground_color);
    }
}
