package com.krp.mvvm.viewModel;

import android.databinding.ObservableInt;
import android.view.View;

import com.krp.mvvm.adapters.PostsAdapter;
import com.krp.mvvm.common.BaseUrl;
import com.krp.mvvm.interfaces.ApiService;
import com.krp.mvvm.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rakeshpraneeth on 3/19/18.
 *
 * This class is tied with Posts Activity and it's layout.
 * We make network calls and set the responses to the variables defined.
 * Since we use Observables, when we set a particular value to any variable, then the view implementing it will get notified.
 */

public class PostsViewModel {

    // We use Observables to notify to Views in layout when a particular value is changes.
    // If a particular variable value is changed only the view which implements that variable will get notified. Not all the views.
    private ObservableInt postsRvVisibility;
    private ObservableInt progressBarVisibility;
    private ObservableInt noPostsMessageVisibility;
    private ObservableInt failedMessageVisibility;

    private ApiService apiService;

    private PostsAdapter adapter;

    public PostsViewModel(){

        postsRvVisibility = new ObservableInt(View.GONE);
        progressBarVisibility = new ObservableInt(View.VISIBLE);
        noPostsMessageVisibility = new ObservableInt(View.GONE);
        failedMessageVisibility = new ObservableInt(View.GONE);
    }

    // Create Getter methods to get the value in the layout.

    public ObservableInt getPostsRvVisibility() {
        return postsRvVisibility;
    }

    public ObservableInt getProgressBarVisibility() {
        return progressBarVisibility;
    }

    public ObservableInt getNoPostsMessageVisibility() {
        return noPostsMessageVisibility;
    }

    public ObservableInt getFailedMessageVisibility() {
        return failedMessageVisibility;
    }

    public void setAdapter(PostsAdapter adapter) {
        this.adapter = adapter;
    }

    public void makeCallToGetPosts(int userId){

        if(apiService == null){
            // If the api service is not created at all, the create it.
            apiService = BaseUrl.getApiService();
        }

        Call<List<Post>> postsCall = apiService.getUserPosts(userId);
        postsCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(response.isSuccessful()){
                    // If response is successful
                    if(response.body().size()>0){
                        // If more than one post
                        showPosts(response.body());
                    }else{
                        // If no posts.
                        noPostsMessageVisibility.set(View.VISIBLE);
                    }
                }
                progressBarVisibility.set(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                // If the network call fails.
                failedMessageVisibility.set(View.VISIBLE);
                progressBarVisibility.set(View.GONE);
            }
        });
    }

    // It is used to update the recyclerview with new Data.
    private void showPosts(List<Post> postsList){
        List<PostItemViewModel> posts = new ArrayList();
        for(Post post : postsList){
            posts.add(new PostItemViewModel(post));
        }
        adapter.setPostsList(posts); // Updates the recyclerview items. We already binded the recyclerview to adapter in activity.
        postsRvVisibility.set(View.VISIBLE);
    }

}
