package com.kuch.ulanie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText workoutNameEdt;
    private Button addWorkoutBtn;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workoutNameEdt=findViewById(R.id.idEdtWorkoutName);
        addWorkoutBtn=findViewById(R.id.idBtnAddWorkout);

        dbHandler=new DBHandler(MainActivity.this);

        addWorkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String workoutName=workoutNameEdt.getText().toString();
                if(workoutName.isEmpty()){
                    Toast.makeText(MainActivity.this, "Uzupełnij", Toast.LENGTH_SHORT).show();
                }

                dbHandler.newWorkout(workoutName);
                Toast.makeText(MainActivity.this, "Trening dodany",Toast.LENGTH_SHORT).show();
                workoutNameEdt.setText("");
            }


        });
    }
}