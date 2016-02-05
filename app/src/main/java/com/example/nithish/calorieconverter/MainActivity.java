package com.example.nithish.calorieconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText amount_text_view;

    private TextView calories_text;
    private TextView push_up_reps;
    private TextView sit_up_reps;
    private TextView jump_jack_time;
    private TextView jog_time;
    private Spinner activity_type_spinner;
    private ArrayAdapter<CharSequence> adapter;
    private Button convert_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount_text_view = (EditText) findViewById(R.id.amount_text_view);
        calories_text = (TextView) findViewById(R.id.calories_text);
        push_up_reps = (TextView) findViewById(R.id.push_up_reps);
        sit_up_reps = (TextView) findViewById(R.id.sit_up_reps);
        jump_jack_time = (TextView) findViewById(R.id.jump_jack_time);
        jog_time = (TextView) findViewById(R.id.jog_time);
        activity_type_spinner = (Spinner) findViewById(R.id.activity_type_spinner);
        convert_button = (Button) findViewById(R.id.convert_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activities_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activity_type_spinner.setAdapter(adapter);

        convert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(amount_text_view.getText().toString().length() < 1) {
                    Toast.makeText(MainActivity.this, "Please input a value", Toast.LENGTH_LONG).show();

                }else{

                    Double amount_input = Double.valueOf(amount_text_view.getText().toString());

                    String activity_input = String.valueOf(activity_type_spinner.getSelectedItem());

                    if(activity_input.equals("Push-ups (reps)")){

                        calories_text.setText(String.valueOf(Math.round(amount_input*2/7)) + " calories burnt!");
                        push_up_reps.setText(String.valueOf(amount_input) + " reps");
                        sit_up_reps.setText(String.valueOf(Math.round(amount_input*2/7)*2) + " reps");
                        jump_jack_time.setText(String.valueOf(Math.round(amount_input*2/7)/10) + " min");
                        jog_time.setText(String.valueOf(Math.round(amount_input*2/7)*3/25) + " min");

                    }

                    if(activity_input.equals("Sit-ups (reps)")){

                        calories_text.setText(String.valueOf(amount_input * 1/2) + " calories burnt!");
                        push_up_reps.setText(String.valueOf(amount_input * 1/2 * 7/2) + " reps");
                        sit_up_reps.setText(String.valueOf(amount_input) + " reps");
                        jump_jack_time.setText(String.valueOf(Math.round(amount_input*1/2)/10) + " min");
                        jog_time.setText(String.valueOf(Math.round(amount_input*1/2)*3/25) + " min");

                    }

                    if(activity_input.equals("Jumping Jacks (min)")){

                        calories_text.setText(String.valueOf(amount_input*10) + " calories burnt!");
                        push_up_reps.setText(String.valueOf(amount_input * 10 * 7/2) + " reps");
                        sit_up_reps.setText(String.valueOf(Math.round(amount_input*10)*2) + " reps");
                        jump_jack_time.setText(String.valueOf(amount_input) + " min");
                        jog_time.setText(String.valueOf(Math.round(amount_input*10)*3/25) + " min");

                    }

                    if(activity_input.equals("Jogging (min)")){

                        calories_text.setText(String.valueOf(Math.round(amount_input*25/3))+ " calories burnt!");
                        push_up_reps.setText(String.valueOf(amount_input * 25/3 * 7/2) + " reps");
                        sit_up_reps.setText(String.valueOf(Math.round(amount_input*25/3)*2) + " reps");
                        jump_jack_time.setText(String.valueOf(Math.round(amount_input*25/3)/10) + " min");
                        jog_time.setText(String.valueOf(amount_input) + " min");

                    }

                    if(activity_input.equals("Calories")){

                        calories_text.setText(String.valueOf(amount_input)+ " calories burnt!");
                        push_up_reps.setText(String.valueOf(amount_input * 3.5) + " reps");
                        sit_up_reps.setText(String.valueOf(amount_input*2) + " reps");
                        jump_jack_time.setText(String.valueOf(amount_input/10) + " min");
                        jog_time.setText(String.valueOf(amount_input*12/100) + " min");

                    }


                }
            }
        });
    }
}
