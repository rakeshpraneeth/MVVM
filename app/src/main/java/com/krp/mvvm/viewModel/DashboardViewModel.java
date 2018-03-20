package com.krp.mvvm.viewModel;

import android.databinding.ObservableInt;
import android.view.View;

import com.krp.mvvm.adapters.UsersAdapter;
import com.krp.mvvm.common.BaseUrl;
import com.krp.mvvm.interfaces.ApiService;
import com.krp.mvvm.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rakeshpraneeth on 3/19/18.
 * This class is tied with Dashboard Activity and it's layout.
 * We make network calls and set the responses to the variables defined.
 * Since we use Observables, when we set a particular value to any variable, then the view implementing it will get notified.
 *
 */

public class DashboardViewModel {

    // We use Observables to notify to Views in layout when a particular value is changes.
    // If a particular variable value is changed only the view which implements that variable will get notified. Not all the views.
    private ObservableInt usersRvVisibility;
    private ObservableInt progressbarVisibility;
    private ObservableInt noUsersMsgVisibility;
    private ObservableInt messageFailedVisibility;

    // Used for Retrofit calls.
    private ApiService apiService;

    private UsersAdapter adapter;

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

    public void setAdapter(UsersAdapter adapter) {
        this.adapter = adapter;
    }

    public void makeCallToGetUsers(){

        if(apiService == null){
            // If the api service is not created at all, the create it.
            apiService = BaseUrl.getApiService();
        }

        Call<List<User>> usersCall = apiService.getAllUsers();

        usersCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (response.isSuccessful()) {
                    // If response is successful

                    if (response.body().size() > 0) {
                        // If more than one user is obtained.

                        showUsersInList(response.body());
                    }else{
                        // If No users are obtained.

                        noUsersMsgVisibility.set(View.VISIBLE);  // It will notify No users TextView to show
                    }
                }

                progressbarVisibility.set(View.GONE); // It will notify progress bar to hide
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                // If the network call failed.

                messageFailedVisibility.set(View.VISIBLE); // It will notify message failed TextView to show
                progressbarVisibility.set(View.GONE);
            }
        });

    }

    // It is used to update the recyclerview with new Data.
    private void showUsersInList(List<User> users){
        List<UserItemViewModel> list = new ArrayList();

        for(User user:users){
            list.add(new UserItemViewModel(user));
        }
        adapter.setUsersList(list); // Updates the recyclerview items. We already binded the recyclerview to adapter in activity.
        usersRvVisibility.set(View.VISIBLE);   // It will notify recycler view to show
    }
}
