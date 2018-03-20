package com.krp.mvvm.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.krp.mvvm.R;
import com.krp.mvvm.databinding.ActivityPostsDetailsBinding;
import com.krp.mvvm.viewModel.PostDetailsViewModel;

public class PostsDetailsActivity extends AppCompatActivity {

    public static final String POST_DETAILS_OBJ = "postDetailsObj";
    public static final String POST_ID = "postId";

    ActivityPostsDetailsBinding binding;

    PostDetailsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_posts_details);

        int postId = getIntent().getIntExtra(POST_ID,-1);

        viewModel = new PostDetailsViewModel();     // creating the instance of ViewModel
        viewModel.getPostDetails(postId);           // call method to make network call.

        binding.setViewModel(viewModel);    // binding the ViewModel to the layout/view.
    }
}
