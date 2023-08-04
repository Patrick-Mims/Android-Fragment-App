package edu.sfsu.workout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.sfsu.classes.Workout;

public class WorkOutDetailFragment extends Fragment {
    // Pass the workout ID to the fragment
    private long workoutId;
    // Inflating the layout converts the XML Views into Java Objects
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        /*
        * The getView() method gets the fragment's root View.
        * Use this to get references to the Workout title and description text views.
        * *
        * Fragment's are distinct from activities, and therefore don't have all the methods that an activity does.
        * Fragment's don't include a findViewById() method, for instance.
        * To get a reference to a fragment's view, we first have to get a reference to the fragments root view using the getView() method.
        *
        * example: View view = getView(); // get the root view of the fragment
        * */
        View view = getView();

        if(view != null) {
            TextView title = (TextView) view.findViewById(R.id.text_title);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.text_description);
            description.setText(workout.getDescription());
        }
    }

    /* We need WorkOutDetailFragment to display details of a particular workout.
     * To do this, we'll add simple setter method to the fragment that sets the value of the workoutID.
     * The activity will then be able to use this method to set the workout ID.
     * */
    public void setWorkoutId(long id) {
        this.workoutId = id;
    }
}