package com.krp.mvvm.viewModel;

import android.os.Parcelable;

/**
 * Created by rakeshpraneeth on 3/19/18.
 * It is used to help Bindable adapter to show the data in recyclerView.
 * In order to create a row in the recycler view item, particular Item ViewModel class should extend RowViewModel class
 * The sub class has to override the getLayout() method and should define the layout they want to display for that item.
 */

public abstract class RowViewModel implements Parcelable{

    public abstract int getLayout();
}
