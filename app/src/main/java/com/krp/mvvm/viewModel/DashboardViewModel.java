package com.krp.mvvm.viewModel;

import android.databinding.ObservableInt;
import android.view.View;

/**
 * Created by rakeshpraneeth on 3/19/18.
 */

public class DashboardViewModel {

    // We use Observables to notify to Views in layout when a particular value is changes.
    private ObservableInt usersRvVisibility;
    private ObservableInt progressbarVisibility;
    private ObservableInt noUsersMsgVisibility;
    private ObservableInt messageFailedVisibility;

    public DashboardViewModel(){
        // Here we initialize the variables with state how they want to be shown when user comes to this screen.
        usersRvVisibility = new ObservableInt(View.GONE);
        progressbarVisibility = new ObservableInt(View.VISIBLE);
        noUsersMsgVisibility = new ObservableInt(View.GONE);
        messageFailedVisibility = new ObservableInt(View.GONE);
    }

    // Create Getter methods to get the value in the layout.
    public ObservableInt getUsersRvVisibility() {
        return usersRvVisibility;
    }

    public ObservableInt getProgressbarVisibility() {
        return progressbarVisibility;
    }

    public ObservableInt getNoUsersMsgVisibility() {
        return noUsersMsgVisibility;
    }

    public ObservableInt getMessageFailedVisibility() {
        return messageFailedVisibility;
    }
}
