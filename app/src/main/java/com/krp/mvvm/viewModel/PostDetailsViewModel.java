package com.krp.mvvm.viewModel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.krp.mvvm.common.BaseUrl;
import com.krp.mvvm.interfaces.ApiService;
import com.krp.mvvm.model.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rakeshpraneeth on 3/19/18.
 */

public class PostDetailsViewModel {

    private ObservableField<Post> post;
    private ObservableInt failedMsgVisibility;
    private ObservableInt progressBarVisibility;

    private ApiService apiService;

    public PostDetailsViewModel(){
        post = new ObservableField();
        failedMsgVisibility = new ObservableInt(View.GONE);
        progressBarVisibility = new ObservableInt(View.VISIBLE);
    }

    public ObservableField<Post> getPost() {
        return post;
    }

    public ObservableInt getFailedMsgVisibility() {
        return failedMsgVisibility;
    }

    public ObservableInt getProgressBarVisibility() {
        return progressBarVisibility;
    }

    public void getPostDetails(int postId){

        if(apiService == null){
            apiService = BaseUrl.getApiService();
        }
        Call<Post> postCall = apiService.getPostDetails(postId);

        postCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    post.set(response.body());
                }
                progressBarVisibility.set(View.GONE);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                failedMsgVisibility.set(View.VISIBLE);
                progressBarVisibility.set(View.GONE);
            }
        });

    }
}
