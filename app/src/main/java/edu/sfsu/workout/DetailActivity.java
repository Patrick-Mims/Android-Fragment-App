package edu.sfsu.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /*
        * To get a reference to the fragment,
        * we need to add the following code.
        * */
        WorkOutDetailFragment frag = (WorkOutDetailFragment)getSupportFragmentManager().findFragmentById(R.id.detail_frag);

        // frag.setWorkoutId(2);
        /*
        * getIntent() - Return the intent that started this activity
        * */
        int workoutId = (int)getIntent().getExtras().get(EXTRA_WORKOUT_ID);

        frag.setWorkoutId(workoutId);
    }

    /*
    public void showMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
     */
}