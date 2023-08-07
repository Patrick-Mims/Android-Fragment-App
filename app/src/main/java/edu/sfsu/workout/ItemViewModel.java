package edu.sfsu.workout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import edu.sfsu.classes.models.DataModel;

public class ItemViewModel extends ViewModel {
    private final MutableLiveData<DataModel> selectedItem = new MutableLiveData<>();

    public void selectItem(DataModel model) {

    }

    public LiveData<DataModel> getSelectedItem() {
        return selectedItem;
    }
}


/*
* To keep fragments self contained, don't have fragments communicate directly with other fragments or with their host activity.
* */