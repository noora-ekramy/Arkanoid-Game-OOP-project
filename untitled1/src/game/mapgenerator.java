package game;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class mapgenerator {
    public int[][] map;
    private final int[][] restmap;
    public int brickwidth;
    public int brickhigh;
    public int totalbricks=0;
    Color []cols;

    public mapgenerator(int row, int col, int bricktype)
    {

        Color[] cols = new Color[7];



        map =new int[row][col];
        restmap= new int [row][col];
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++)
            {

                map[i][j]= (int) (Math.random()*(bricktype));
                restmap[i][j]=map[i][j];
                if (map[i][j]>0)
                    totalbricks++;

            }

        }
        brickwidth=540/col;
        brickhigh=150/row;
    }

    public void draw(Graphics2D g)
    {
        cols = new Color[7];
        cols[0]= new Color ( 226, 17, 17, 255 ) ;
        cols[1]= new Color ( 152, 15, 226, 255 ) ;
        cols[2]= new Color ( 91, 234, 15, 255 ) ;
        cols[3]= new Color ( 14, 88, 236, 255 ) ;
        cols[4]= new Color ( 243, 165, 8, 255 ) ;
        cols[5]= new Color ( 255, 255, 0, 255 ) ;
        cols[6]= new Color ( 7, 238, 203, 255 ) ;

        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++)
            {

                if(map[i][j]==1 ||map[i][j]==2 || map[i][j]==3)
                {

                    g.setColor(cols[(i+j+map[i][j])%7]);
                    g.fillRect(j*brickwidth+88, i*brickhigh+50, brickwidth, brickhigh);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j*brickwidth+88, i*brickhigh+50, brickwidth, brickhigh);

                }


            }

        }
    }

    public void setBrickvalu(int valu,int row,int col)
    {
        map[row][col]=valu;
    }
    public void resstmap(){
        totalbricks=0;
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++)
            { map[i][j]=restmap[i][j];
                if (map[i][j]>0)
                    totalbricks++;
            }
        }
    }
}
