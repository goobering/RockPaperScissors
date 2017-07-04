package example.codeclan.com.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    //private ScoreSheet scoreSheet;
    TextView txt_win_score, txt_draw_score, txt_lose_score;
    int wins, draws, losses;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_win_score = (TextView) findViewById(R.id.txt_win_score);
        txt_draw_score = (TextView) findViewById(R.id.txt_draw_score);
        txt_lose_score = (TextView) findViewById(R.id.txt_lose_score);

        //scoreSheet = ScoreSheet.all().get(0);

        wins = 0;
        draws = 0;
        losses = 0;

        txt_win_score.setText(Integer.toString(wins));
        txt_draw_score.setText(Integer.toString(draws));
        txt_lose_score.setText(Integer.toString(losses));
    }

    public void onRockButtonClicked(View button)
    {
        //Opens another Activity
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("userChoice", "Rock");
        //startActivity(intent);
        startActivityForResult(intent, 1);
    }

    public void onPaperButtonClicked(View button)
    {
        //Opens another Activity
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("userChoice", "Paper");
        //startActivity(intent);
        startActivityForResult(intent, 1);
    }

    public void onScissorsButtonClicked(View button)
    {
        //Opens another Activity
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("userChoice", "Scissors");
        //startActivity(intent);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                int gameResultValue = data.getIntExtra("gameResultValue", -999);

                if(gameResultValue == 0)
                {
                    draws++;
                    txt_draw_score.setText(Integer.toString(draws));
                }
                else if(gameResultValue == 1)
                {
                    wins++;
                    txt_win_score.setText(Integer.toString(wins));
                }
                else if(gameResultValue == -1)
                {
                    losses++;
                    txt_lose_score.setText(Integer.toString(losses));
                }
            }
        }
    }
}
