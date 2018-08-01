package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    Button btnDemo2;
    Button btnDemo3;
    Button btnExercise3;
    Button btnDemo4;
    Button btnDemo5;

    TextView tvDemo2;
    TextView tvDemo3;
    TextView tvExercise3;
    TextView tvDemo4;
    TextView tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnExercise3 = findViewById(R.id.buttonExercise3);
        btnDemo4 = findViewById(R.id.buttonDemo4);

        tvDemo2 = findViewById(R.id.textViewDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        tvExercise3 = findViewById(R.id.textViewExercise3);
        tvDemo4 = findViewById(R.id.textViewDemo4);

        //GET CURRENT DATE AND TIME
        Calendar now = Calendar.getInstance();
        theYear = now.get(Calendar.YEAR);
        theMonth = now.get(Calendar.MONTH);
        theDay = now.get(Calendar.DAY_OF_MONTH);

        btnDemo1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 1 - Simple Dialog");
                myBuilder.setMessage("I can develop Android App");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);

                //ACTUAL DIALOG CREATED FOR BUILDER
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 - Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below");
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected YES/POSITIVE");
                    }
                });

                //ACTUAL DIALOG CREATED FOR BUILDER
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        //Configure the 'negative' button
        myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvDemo2.setText("You have selected NO/NEGATIVE");
            }
        });
        myBuilder.setNeutralButton("Cancel", null);

        //ACTUAL DIALOG CREATED FOR BUILDER
        AlertDialog myDialog = myBuilder.create();
        myDialog.show();

        btnDemo3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                LayoutInflater inflater = (LayoutInflater) getBaseContext().(Context.LAYOUT_INFLATER_SERVICE);

                View viewDialog = inflater.inflate(R.layout.input, null);

                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);
                String message = etInput.getText().toString();

                //BUILDER
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 3 - Text Input Dialog");
                myBuilder.setView(viewDialog);
                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = etInput.getText().toString();
                        tvDemo3.setText(message);

                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);

                //ACTUAL DIALOG CREATED FOR BUILDER
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                LayoutInflater inflater = (LayoutInflater) getBaseContext().
                (Context.LAYOUT_INFLATER_SERVICE);

                View viewDialog = inflater.inflate(R.layout.input, null);

                final EditText etInput1 = viewDialog.findViewById(R.id.editTextInput1);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextInput2);

                //BUILDER
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //show title
                myBuilder.setTitle("Demo 3 - Text Input Dialog");
                //show the custom XML Layout
                myBuilder.setView(viewDialog);

                myBuilder.setCancelable(false);

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String num1 = etInput1.getText().toString();
                        String num2 = etInput2.getText().toString();
                        int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
                        tvExercise3.setText("The sum is: " + sum);

                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);

                //ACTUAL DIALOG CREATED FOR BUILDER
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                DatePickerDialog.onDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                };

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, theYear, theMonth, theDay);

                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                TimePickerDialog.onTimeClickListener myTimeListener = new TimePickerDialog.onTimeSetListener() {
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + "/" + minute);
                        int theHour = hourOfDay;
                        int theMin = minute;
                    }
                };

                TimePickerDialog myTimeDialog = new DatePickerDialog(MainActivity.this, myTimeListener, theHour, theMin, true);

                myTimeDialog.show();

            }
        });
    }
}