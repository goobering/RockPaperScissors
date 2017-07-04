package example.codeclan.com.rockpaperscissors;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import example.codeclan.com.rockpaperscissors.databases.SqlRunner;

/**
 * Created by user on 04/07/2017.
 */

public class ScoreSheet
{
    private int id, wins, draws, losses;

    public ScoreSheet(int wins, int draws, int losses)
    {
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public ScoreSheet(int id, int wins, int draws, int losses)
    {
        this.id = id;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public int getId()
    {
        return id;
    }

    public int getWins()
    {
        return wins;
    }

    public void setWins(int wins)
    {
        this.wins = wins;
    }

    public int getDraws()
    {
        return draws;
    }

    public void setDraws(int draws)
    {
        this.draws = draws;
    }

    public int getLosses()
    {
        return losses;
    }

    public void setLosses(int losses)
    {
        this.losses = losses;
    }

    public static ArrayList<ScoreSheet> all()
    {
        String sql = "SELECT * FROM scores;";
        SqlRunner.executeQuery(sql);
        ResultSet rs = SqlRunner.executeQuery(sql);

        ArrayList<ScoreSheet> scoreSheets = new ArrayList<ScoreSheet>();
        try
        {
            while(rs.next())
            {
                int wins = rs.getInt("wins");
                int draws = rs.getInt("draws");
                int losses = rs.getInt("losses");
                scoreSheets.add(new ScoreSheet(wins, draws, losses));
            }
        }
        catch(SQLException ex)
        {
            System.exit(0);
        }
        finally
        {
            SqlRunner.closeConnection();
        }

        return scoreSheets;
    }

    public void save() {
        String sql = String.format("INSERT INTO scores (wins, draws, losses) VALUES ('%d', '%d', '%d');", this.wins, this.draws, this.losses);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void deleteAll()
    {
        String sql = "DELETE FROM scores;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void delete()
    {
        String sql = String.format("DELETE FROM scores WHERE id = '%d';", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update()
    {
        String sql = String.format("UPDATE scores SET (wins, draws, losses) = ('%d', '%d', '%d') WHERE id = '%d';", this.wins, this.draws, this.losses, this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }
}
