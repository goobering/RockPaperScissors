package example.codeclan.com.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity
{
    TextView txt_player_choice, txt_computer_choice, txt_outcome;
    int gameResultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txt_player_choice = (TextView) findViewById(R.id.txt_player_choice);
        txt_computer_choice = (TextView) findViewById(R.id.txt_computer_choice);
        txt_outcome = (TextView) findViewById(R.id.txt_outcome);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String userChoice = extras.getString("userChoice");

        String computerChoice = Game.getComputerMove();
        gameResultValue = Game.compareMoves(userChoice, computerChoice);
        String gameResult = Game.getWinner(gameResultValue);

        txt_player_choice.setText(userChoice);
        txt_computer_choice.setText(computerChoice);
        txt_outcome.setText(gameResult);
    }

    public void onDoneButtonClicked(View button)
    {
        Intent returnIntent = new Intent();

        returnIntent.putExtra("gameResultValue", gameResultValue);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
