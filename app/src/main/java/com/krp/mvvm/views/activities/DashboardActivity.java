package com.krp.mvvm.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.krp.mvvm.R;
import com.krp.mvvm.adapters.UsersAdapter;
import com.krp.mvvm.databinding.ActivityDashboardBinding;
import com.krp.mvvm.viewModel.DashboardViewModel;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;
    DashboardViewModel dashboardViewModel;
    UsersAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard);

        adapter = new UsersAdapter();
        dashboardViewModel = new DashboardViewModel();
        dashboardViewModel.setAdapter(adapter);     // We will use this adapter in ViewModel and we set the values.
        dashboardViewModel.makeCallToGetUsers();      // To make service call and get the data.
        binding.setViewModel(dashboardViewModel);
        loadUsers();
    }

    // used to map the Adapter to RecyclerView.
    private void loadUsers(){
        binding.listOfUsersRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.listOfUsersRV.setHasFixedSize(true);
        binding.listOfUsersRV.setAdapter(adapter);
    }
}
