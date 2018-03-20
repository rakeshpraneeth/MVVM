package com.krp.mvvm.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.krp.mvvm.R;
import com.krp.mvvm.adapters.PostsAdapter;
import com.krp.mvvm.databinding.ActivityPostsBinding;
import com.krp.mvvm.viewModel.PostsViewModel;

public class PostsActivity extends AppCompatActivity {

    public static final String USER_ID = "UserId";
    ActivityPostsBinding binding;
    PostsViewModel viewModel;
    PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_posts);

        int userId = getIntent().getIntExtra(USER_ID,-1);

        viewModel = new PostsViewModel();

        adapter = new PostsAdapter();
        viewModel.setAdapter(adapter);  // Pass adapter to viewModel to set data to adapter when obtained

        viewModel.makeCallToGetPosts(userId);   // To make network call to get data.
        binding.setViewModel(viewModel);

        loadPosts();
    }

    private void loadPosts(){

        binding.listOfPostsRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.listOfPostsRV.setHasFixedSize(true);
        binding.listOfPostsRV.setAdapter(adapter);
    }
}
