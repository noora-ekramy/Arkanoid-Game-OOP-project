package game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.*;
import game.moving_members.*;
import static java.lang.Math.abs;
public class gameplay<i> extends JPanel implements KeyListener, ActionListener {
    public boolean play = false , win=false,name=false;
    public String playername=new String("");
    public HighscoreFile highscore=new HighscoreFile();
    public    int score =0;
    public int last_lvl_score=0;
    public Timer timer;
    public  int delay=8;
    public int playerx=310;
    public int bricktype=2;
    public  int ballposx=120;
    public  int ballposy=350;
    public  int ballxdir=-2;
    public  int ballydir=-3;
    public mapgenerator map;
    public int row=3,col=7;
    public int level=1;
    enemy en = new enemy();
    JFrame f;
    pause pause = new pause ();
    laser laser_ =new laser (0 , false);
    laser_bullet[] bullets= new laser_bullet[20];



    public gameplay()
    {
        for(int i = 0 ; i < 20; i++)
        {
            bullets[i]=new laser_bullet (1000 , 1000 , false);
            bullets[i].stat=false;
        }
        map =new mapgenerator(row, col,bricktype);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer= new Timer(delay,this);
        timer.start();

    }

    public gameplay(int level)
    {   for(int i = 0 ; i < 20; i++)
    {
        bullets[i]=new laser_bullet (1000 , 1000 , false);
        bullets[i].stat=false;
    }
        this.level=level;
        switch (this.level){

        case 2:
            bricktype=3;
            break;
        case 3:
            bricktype=4;
            break;
        default:
            break;
    }
        map =new mapgenerator(row, col,bricktype);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer= new Timer(delay,this);
        timer.start();


    }
    public void get_f (JFrame f)
    {
        this.f =f;
    }
    @Override
    public void paint(Graphics g)
    {
        //background
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 700, 600);
        g.setColor(Color.white);
        g.setFont(new Font("Haettenschweiler" , Font.BOLD , 20));
        g.drawString("press p to pause the game"  , 10 ,20);


        //laser
        if(laser_.laser_mode){
            laser_.draw ( (Graphics2D)g , playerx-10 , playerx+100 );
        }
        //map
        if(level %4!=0){
            map.draw((Graphics2D)g);
        }
        //enemy
        else{
            en.draw ((Graphics2D)g, 0 , 0);
        }
        //pause
        if(pause.stat) {
            pause.pause_menu (g);
        }
        //the bord
        g.setColor(Color.white);
        g.fillRect(playerx, 550, 100, 8);

        //the ball
        g.setColor(Color.white);
        g.fillOval(ballposx, ballposy, 20, 20);
        if (name==false){
            g.setFont(new Font("Haettenschweiler" , Font.BOLD , 30));
            g.drawString("please enter your name:"+playername  , 190 ,300);
        }

        if(map.totalbricks==0 || en.life==0)
        {
            play=false;
            ballxdir=0;
            ballydir=0;
            win=true;

            g.setColor(Color.white);
            g.setFont(new Font("Haettenschweiler" , Font.BOLD , 30));
            g.drawString("Level "+level +" complete your Score is :" + score , 190 ,300);


            g.setFont(new Font("Haettenschweiler" , Font.BOLD , 30));
            g.drawString("press Enter to proceed to next level"  , 190 ,350);
            g.setFont(new Font("Haettenschweiler" , Font.BOLD , 30));
            g.drawString("press escape to save highscore"  , 190 ,400);

        }




        if(ballposy>570)
        {
            play=false;
            ballxdir=0;
            ballydir=0;

            en.life=25;

            g.setColor(Color.white);
            g.setFont(new Font("Haettenschweiler", Font.BOLD , 30));
            g.drawString("Game Over , your Score :" +score , 190 ,300);


            g.setFont(new Font("Haettenschweiler" , Font.BOLD , 30));
            g.drawString("press Enter to replay"  , 190 ,350);






        }

        for(int i = 0 ; i< 20 ; i++)
        {
            if(bullets[i].stat)
            {
                bullets[i].draw ( g , bullets[i].x_position , bullets[i].y_position );
            }
        }

        //Score

        g.setColor(Color.WHITE);
        g.setFont(new Font("Haettenschweiler" , Font.BOLD , 20));
        g.drawString("Score : " + score , 570 ,20);

        // g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        timer.start();
        for(int i = 0 ; i< 20 ; i++)
        {

            if(bullets[i].stat)
            {
                bullets[i].move (2);
            }
        }
        if(laser_.duration_>0)
        {
            laser_.duration_--;
        }
        else
        {
            laser_.laser_mode=false;
        }
        if(play && ! pause.stat)
        {

            if(new Rectangle(ballposx,ballposy,20,20).intersects(new Rectangle(playerx,550,100,8)))
            {
                ballydir=-3;
            }

            if(level %4!= 0)
            {
                A : for (int i = 0; i < map.map.length; i++) {
                    for (int j = 0; j < map.map[0].length; j++) {
                        for(int k = 0 ; k < 20 ; k++){


                        int brickx=j*map.brickwidth+88;
                        int bricky=i*map.brickhigh+50;
                        int brickwidth=map.brickwidth;
                        int brickhigh=map.brickhigh;

                        Rectangle rect =new Rectangle(brickx , bricky , brickwidth , brickhigh);
                        Rectangle ballrect=new Rectangle(ballposx, ballposy, 20, 20);
                        Rectangle brickrect=rect;
                        if(map.map[i][j]==1)
                        {


                            if(ballrect.intersects(brickrect))
                            {
                                map.setBrickvalu(0, i, j);
                                map.totalbricks--;
                                score+=5;

                                if(ballposx + 19 <=brickrect.x || ballposx + 1 >=brickrect.x + brickrect.width)
                                {
                                    ballxdir = -ballxdir;
                                }
                                else
                                {
                                    ballydir = -ballydir;
                                }
                                break A;
                            }

                        }
                        if(map.map[i][j]==2)
                        {
                            if(ballrect.intersects(brickrect))
                            {
                                map.setBrickvalu(1, i, j);



                                if(ballposx + 19 <=brickrect.x || ballposx + 1 >=brickrect.x + brickrect.width)
                                {
                                    ballxdir = -ballxdir;
                                }
                                else
                                {
                                    ballydir = -ballydir;
                                }
                                break A;
                            }

                        }if(map.map[i][j]==3)
                        {
                            if(ballrect.intersects(brickrect))
                            {
                                laser_.laser_mode=true;
                                laser_.duration_=300;
                                map.setBrickvalu(2, i, j);
                                map.totalbricks--;
                                score+=5;

                                //gg.setColor(Color.green);
                                //gg.fillOval(brickx, bricky, 20, 20);


                                if(ballposx + 19 <=brickrect.x || ballposx + 1 >=brickrect.x + brickrect.width)
                                {
                                    ballxdir = -ballxdir;
                                }
                                else
                                {
                                    ballydir = -ballydir;
                                }
                                break A;
                            }

                        }


                    }}

                }
            }
            else
            {   en.move(1);
                Rectangle enemy_rect =new Rectangle( en.x_position , en.y_position , 200 , 200);
                Rectangle ballrect=new Rectangle(ballposx, ballposy, 20, 20);
                Rectangle brickrect=enemy_rect;

                if(ballrect.intersects(brickrect)) {
                    en.life--;
                    score += 5;
                    System.out.println(ballposx  +  "  lol  " + brickrect.x  +  ballxdir );
                    if (ballposx  <= brickrect.x ) {
                        ballxdir = -ballxdir;
                    }
                    else if(ballposx+3 >= brickrect.x + 200)
                    {
                        ballxdir=abs(ballxdir);
                    }
                    else {
                        ballydir = -ballydir;
                    }
                }
            }
            ballposx+=ballxdir;
            ballposy+=ballydir;
            if(ballposx<0)
            {ballxdir=-ballxdir;}
            if(ballposy<0)
            {ballydir=-ballydir;
            }
            if(ballposx>670)
            {ballxdir=-ballxdir;}
        }
        repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.



    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (name==false){
            if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
                StringBuffer s=new StringBuffer(playername);
                s.deleteCharAt(s.length()-1);
                playername=s.toString();
            }
             if (e.getKeyCode()==KeyEvent.VK_ENTER)
                name=true;
             else {

                 playername = playername + (String.valueOf(e.getKeyChar()));
             }
        }
        if(play && (e.getKeyChar () == 'p' || e.getKeyChar ()=='P' ) && !pause.stat )
        {
            pause.stat=true;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT && play )
        {
            if(playerx>=600)
            {
                playerx=600;
            }
            else
            {
                moveright();
            }
        }
        else if(pause.stat)
        {
            if(e.getKeyChar ()=='r' || e.getKeyChar () == 'R')
            {
                pause.stat=false;
            }
            else if(e.getKeyChar ()=='M' || e.getKeyChar () == 'm')
            {
                f.dispose ();
                new main_menu ();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT && play)
        {
            if(playerx<10)
            {
                playerx=10;
            }
            else
            {
                moveleft();

            }
        }
        if(e.getKeyCode()==KeyEvent.VK_ENTER)
        {
            if(!play)
            {
                play = true;
                playerx=310;
                ballposx=120;
                ballposy=350;
                ballxdir=-2;
                ballydir=-3;
                // score=last_lvl_score;
                if (win==true) {
                    level++;
                    last_lvl_score=score;
                    bricktype =level%4;


                    if ( (level-1) %4 ==0 )
                    {
                        win=false;
                        en=new enemy();
                        en.life=25*(level-1)/4;
                    }
                    else
                    {
                        map =new mapgenerator(row, col, bricktype);
                        win=false;
                    }


                }
                score=last_lvl_score;
                map.resstmap();
                repaint();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
        {

                highscore.saving_score(score,playername);
            System.out.println(highscore.read_score());

        }
        if(e.getKeyCode () == KeyEvent.VK_SPACE && laser_.laser_mode)
        {
            for(int i=0 ; i <20 ; i++)
            {
                if(!bullets[i].stat)
                {
                    bullets[i].stat=true;
                    bullets[i].x_position=laser_.x;
                    bullets[i].y_position=550;
                    break;
                }
            }
        }


    }

    public void moveright()
    {
        play =true;
        playerx+=20;
    }
    public void moveleft()
    {
        play =true;
        playerx-=20;
    }



}
