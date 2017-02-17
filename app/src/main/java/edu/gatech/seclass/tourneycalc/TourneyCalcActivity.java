package edu.gatech.seclass.tourneycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TourneyCalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourney_calc);
    }

    public void generateCutAndPayouts(View v){

         /*
        * entranceFeeInput
        * */
        EditText entranceFeeInput = (EditText) findViewById(R.id.entranceFee);
        if(entranceFeeInput.getText().toString().isEmpty())
        {
            entranceFeeInput.setError("Invalid Fee");
            return;
        }

        int entranceFee = Integer.parseInt(entranceFeeInput.getText().toString());

        if(entranceFee <= 0){
            entranceFeeInput.setError("Invalid Fee");
            return;
        }


        /*
        * entrantsNumberInput
        * */
        EditText entrantsNumberInput = (EditText) findViewById(R.id.entrantsNumber);
        if(entrantsNumberInput.getText().toString().isEmpty())
        {
            entrantsNumberInput.setError("Invalid Number of Entrants");
            return;
        }

        int entrantsNumber = Integer.parseInt(entrantsNumberInput.getText().toString());

        if(entrantsNumber <= 0){
            entrantsNumberInput.setError("Invalid Number of Entrants");
            return;
        }

        /*
        * housePercentageInput
        * */
        EditText housePercentageInput = (EditText) findViewById(R.id.housePercentage);
        if(housePercentageInput.getText().toString().isEmpty())
        {
            housePercentageInput.setError("Invalid House Percentage");
            return;
        }

        int housePercentage = Integer.parseInt(housePercentageInput.getText().toString());

        if(housePercentage <= 0){
            housePercentageInput.setError("Invalid House Percentage");
            return;
        }



        int prizePool = entrantsNumber * entranceFee;
        int houseCut = (int)(prizePool*(housePercentage/100.0f));

        int playerEligiblePrizePool = prizePool - houseCut;
        int firstPlacePrize = playerEligiblePrizePool/2;
        int secondPlacePrize = playerEligiblePrizePool/3;
        int thirdPlacePrize = playerEligiblePrizePool/5;


        TextView houseCutValue = (TextView) findViewById(R.id.houseCutValue);
        houseCutValue.setText( String.valueOf(houseCut) );

        TextView firstPrizeValue = (TextView) findViewById(R.id.firstPrizeValue);
        firstPrizeValue.setText( String.valueOf(firstPlacePrize) );

        TextView secondPrizeValue = (TextView) findViewById(R.id.secondPrizeValue);
        secondPrizeValue.setText( String.valueOf(secondPlacePrize) );

        TextView thirdPrizeValue = (TextView) findViewById(R.id.thirdPrizeValue);
        thirdPrizeValue.setText( String.valueOf(thirdPlacePrize) );

    }
}
