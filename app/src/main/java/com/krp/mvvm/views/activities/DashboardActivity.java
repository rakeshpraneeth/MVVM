package com.krp.mvvm.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.krp.mvvm.R;
import com.krp.mvvm.databinding.ActivityDashboardBinding;
import com.krp.mvvm.viewModel.DashboardViewModel;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;
    DashboardViewModel dashboardViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard);

        dashboardViewModel = new DashboardViewModel();
        dashboardViewModel.makeCallToGetUsers();
        binding.setViewModel(dashboardViewModel);
    }
}
