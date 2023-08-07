package edu.sfsu.workout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.sfsu.classes.Workout;
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

/* This fragment needs to extend ListFragment - (since it's a ListFragment, not a Fragment!)
 * If data needs to be displayed in a List View that comes from a source other than string.xml,
 * you need to use an ADAPTER.
 *
 * An Array Adapter is a type of adapter that's used to bind arrays to views.
 * always create private variables and public methods, this is so outside classes cannot modify them accidentally */
public class WorkoutListFragment extends ListFragment {
    public ArrayAdapter<String> adapter;
    public List<DataModel> model;
   // public List <DataModel> model;
    // ArrayAdapter<DataModel> adapter;
    // Define the interface here, as its purpose is to allows this fragment to communicate with any activity.
    static interface Listener {
        void itemClicked(long id);
    };

    /*
        We need to have a reference to the activity WorkOutListFragment gets attached to.
        This activity will implement the Listener interface, so we'll add the following
        private variable to WorkoutListFragment.
    */
    private Listener listener;

    public String[] generateList() {
        int len = Workout.workouts.length;

        String[] names = new String[len];

        for(int i = 0; i < names.length; i++) {
            names[i]  = Workout.workouts[i].getName();
        }

        return names;
    }

    // public ArrayList<DataModel> dataList() {
    public List<DataModel> dataList() {
        model = new ArrayList<>();
        model.add(
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

        model.add(
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

        model.add(
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
                        "pmims1@mail.sfsu.edu",
                        "415-509-6599",
                        "415-724-1924",
                        "wvb")
        );

        return model;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        model = new ArrayList<>();
        model = dataList();
        // List <DataModel> model = dataList();

        Log.i("*****DATALIST*****", model.get(0).getEmail());
        // adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, Collections.singletonList(dataList().get(0).getEmail()));
        int MODEL_SIZE = model.size();

        String[] itemsArray = new String[3];

        for(int i = 0; i < itemsArray.length; i++) {
            itemsArray[i] = model.get(i).getEmail();
        }

        adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, itemsArray);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    /*
     * The onListItemClick() method has four parameters:
     * 1. The list view
     * 2. the item in the list that was clicked
     * 3. The position
     * 4. The row ID of the underlying data.
     *
     * This means we can use the method to pass the listener the id of the workout the user clicked on:
     * */
    @Override
    public void onListItemClick(@NonNull ListView View, @NonNull View itemView, int position, long id) {
        if(listener != null) {
            listener.itemClicked(id);
        }
    }
}

/*
 * We do not want to write code in this file to talk directly to mainActivity.java
 *
 * Code Reuse: We want out fragments to know as little as possible about the environment
 * that contains them so that we can reuse them elsewhere.
 *
 * The more a fragment knows about our activity using it, the less reusable it is.
 *
 * *
 * We need to use an interface to decouple the fragment from the activity
 * */