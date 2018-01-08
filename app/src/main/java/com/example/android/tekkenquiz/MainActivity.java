package com.example.android.tekkenquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Michael Parkin
 * Basic quiz app that decides which Tekken characters you are most like from 4 simple questions.
 */
public class MainActivity extends AppCompatActivity {
    //These ints track which character the user is most like. The greater the more alike.
    int kazuya = 0;
    int heihachi = 0;
    int king = 0;
    int paul = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method puts each RadioGroup found using their IDs into a variable then using them as the arguments for the radioRunThrough method.
     * After each RadioGroup is put through the radioRunThrough, we run the chooseYourCharacter method.
     * @param view Allows the submit button to initialize this method.
     */
    public void submitQuiz (View view) {
        RadioGroup daddy = (RadioGroup) findViewById(R.id.daddy); //Put RadioGroup into variable after finding it using ID.
        radioRunThrough(daddy); //Use RadioGroup variable as argument for radioRunThrough method.
        RadioGroup color = (RadioGroup) findViewById(R.id.color);
        radioRunThrough(color);
        RadioGroup moves = (RadioGroup) findViewById(R.id.moves);
        radioRunThrough(moves);
        RadioGroup country = (RadioGroup) findViewById(R.id.country);
        radioRunThrough(country);
        chooseYourCharacter(); //Run chooseYourCharacterMethod
    }

    /**
     * Used to scan through RadioGroups and find out which button is checked. Depending of which button is checked, we allot points to the character name variables(paul, kazuya...etc.)
     * @param currentGroup The RadioGroup that we are going to scan through to find out which RadioButton is checked.
     */
    public void radioRunThrough (RadioGroup currentGroup) {
        int count = currentGroup.getChildCount();   //Get the amount of children (RadioButtons) in the current RadioGroup
        ArrayList<RadioButton> listOfRadioButtons = new ArrayList<RadioButton>(); //Declare an ArrayList of RadioButtons
        for (int i=0;i<count;i++) { //Basic for loop to run through each RadioButton
            View o = currentGroup.getChildAt(i); //o is one of the children of the currentGroup
            if (o instanceof RadioButton) { //If o is a RadioButton then add it to the ArrayList of RadioButtons
                listOfRadioButtons.add((RadioButton)o);
            }
        }
        for (int i = 0; i<listOfRadioButtons.size(); i++) { //For loop to run through each RadioButton of the ArrayList
            if (listOfRadioButtons.get(i).isChecked() == true) { //If the RadioButton is pressed
                String idName = (getResources().getResourceEntryName(listOfRadioButtons.get(i).getId())); //Get the ID resource entry name in String form.
                Log.i("MyActivity",idName + "lol");
                if (idName.equals("family")) {  //If the ID resource entry String is the same as any of these then allot points to the corresponding character variable.
                    kazuya++;
                    heihachi++;
                }
                if (idName.equals("kazuya")) {
                    kazuya++;
                }
                if (idName.equals("heihachi")) {
                    heihachi++;
                }
                if (idName.equals("king")) {
                    king++;
                }
                if (idName.equals("paul")) {
                    paul++;
                }
            }
        }
    }

    /**
     * Finds out which character variable has the greatest value.
     * Prints out the most alike character or characters.
     * Resets all points to 0.
     */
    public void chooseYourCharacter () {
        int[] characters = {kazuya, heihachi, king, paul}; //Array of int character variables
        int greatest = 0;   //Starting off the greatest variable at 0
        for (int i = 0; i < characters.length - 1; i++ ) { //For loop to run through each character variable in the array
            if (characters[i] > greatest) { //If the current character value in the array is greater than the...
                                            // greatest variable then make the current character value the new value of greatest.
                greatest = characters[i];
            }
        }
        if (kazuya == greatest) {   //If the value of greatest is equal to the value of any of these character variables then print out the corresponding message.
            Toast.makeText(getApplicationContext(), "You are Kazuya",
                    Toast.LENGTH_LONG).show();
        }
        if (heihachi == greatest) {
            Toast.makeText(getApplicationContext(), "You are Heihachi",
                    Toast.LENGTH_LONG).show();
        }
        if (paul == greatest) {
            Toast.makeText(getApplicationContext(), "You are Paul",
                    Toast.LENGTH_LONG).show();
        }
        if (king == greatest) {
            Toast.makeText(getApplicationContext(), "You are King",
                    Toast.LENGTH_LONG).show();
        }
                    //Resets the character variables.
        kazuya = 0;
        king = 0;
        heihachi = 0;
        paul = 0;
    }

}

