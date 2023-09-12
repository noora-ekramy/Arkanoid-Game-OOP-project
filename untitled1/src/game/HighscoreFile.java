package game;
import java.io.*;
import java.util.Scanner;
public class HighscoreFile extends Highscore{
    private final File f=new File("Highscore.txt");
    private  String scores= "";
    public HighscoreFile(){

    }
    public void saving_score(int score, String name) {
        try {
            FileWriter fileWriter = new FileWriter ( "Highscore.txt", true );
            fileWriter.write(name+":"+score+"\n");
            fileWriter.close();}
        catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }



    @Override
    public String read_score() {
        try {
            FileReader fileReader = new FileReader ( "Highscore.txt" );
            if (fileReader.read()!=-1){

                Scanner scanner=new Scanner(f);
                while (scanner.hasNextLine()){
                    scores += "\n" + scanner.nextLine ();}
                return scores;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

