package edu.sfsu.workout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.sfsu.classes.models.Coordinates;
import edu.sfsu.classes.models.DataModel;
import edu.sfsu.classes.models.Dob;
import edu.sfsu.classes.models.Id;
import edu.sfsu.classes.models.Location;
import edu.sfsu.classes.models.Login;
import edu.sfsu.classes.models.Name;
import edu.sfsu.classes.models.Pic;
import edu.sfsu.classes.models.Registered;
import edu.sfsu.classes.models.Street;
import edu.sfsu.classes.models.Timezone;

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
            List<DataModel> dataModel = new ArrayList<>();

            dataModel.add(
                    new DataModel(
                            new Name("Michael", "Jones", "Mr"),
                            new Location("Richmond", "USA", 94606, "CA",
                                    new Coordinates("-6.0109", "-118.4862"),
                                    new Street(633, "Cleveland"),
                                    new Timezone("+1.00", "Pacific")),
                            new Login("234", "patrick", "233", "e3w34", "4e", "ne", "3245"),
                            new Dob("033434", 34),
                            new Registered("32434", 34),
                            new Id("NSS", "23 40"),
                            new Pic("http://", "http://www", "http://www"),
                            "Male",
                            "binary_thinker@yahoo.com",
                            "415-334-1904",
                            "415-724-1924",
                            "wvb")
            );

            dataModel.add(
                    new DataModel(
                            new Name("Patrick", "Mims", "Mr"),
                            new Location("Oakland", "USA", 94606, "CA",
                                    new Coordinates("-6.0109", "-118.4862"),
                                    new Street(633, "Cleveland"),
                                    new Timezone("+1.00", "Pacific")),
                            new Login("234", "patrick", "233", "e3w34", "4e", "ne", "3245"),
                            new Dob("033434", 34),
                            new Registered("32434", 34),
                            new Id("NSS", "23 40"),
                            new Pic("http://", "http://www", "http://www"),
                            "Male",
                            "patrickkevinmims@gmail.com",
                            "415-777-9311",
                            "415-724-1924",
                            "wvb")
            );

            title.setText(dataModel.get((int) workoutId).getEmail());

            /*
            title.setText(mod.get(0).getCell());
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.text_description);
            description.setText(workout.getDescription());
            */
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