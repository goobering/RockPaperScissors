package example.codeclan.com.rockpaperscissors;

import java.util.Random;

/**
 * Created by user on 04/07/2017.
 */

public class Game
{
    public static String getComputerMove()
    {
        String[] moves = new String[]{"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];
    }

    public static int compareMoves(String playerMove, String computerMove)
    {
        if(playerMove.equals(computerMove))
        {
            return 0;
        }

        switch(playerMove)
        {
            case "Rock":
                return(computerMove.equals("Scissors") ? 1 : -1);
            case "Paper":
                return(computerMove.equals("Rock") ? 1 : -1);
            case "Scissors":
                return(computerMove.equals("Paper") ? 1 : -1);
            default:
                return 0;
        }
    }

    public static String getWinner(int result)
    {
        switch(result)
        {
            case 0:
                return "It's a draw";
            case 1:
                return "Player wins";
            case -1:
                return "Computer wins";
            default:
                return "Something has gone horribly, horribly wrong.";
        }
    }
}
