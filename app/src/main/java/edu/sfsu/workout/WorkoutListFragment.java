package edu.sfsu.workout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.sfsu.classes.Workout;

/* This fragment needs to extend ListFragment - (since it's a ListFragment, not a Fragment!)
 * If data needs to be displayed in a List View that comes from a source other than string.xml,
 * you need to use an ADAPTER.
 *
 * An Array Adapter is a type of adapter that's used to bind arrays to views.
 * */
public class WorkoutListFragment extends ListFragment {
    ArrayAdapter<String> adapter;

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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, generateList());

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
    * This means we can use the metopid to pass the listener the id of the workout the user clicked on:
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