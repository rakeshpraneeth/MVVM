package com.krp.mvvm.adapters;

import com.krp.mvvm.viewModel.PostItemViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by rakeshpraneeth on 3/19/18.
 * Adapter used to show list of posts.
 * This class extends BindableAdapter class and override methods
 */

public class PostsAdapter extends BindableAdapter{

    List<PostItemViewModel> postsList;

    public PostsAdapter(){
        // Initially making the list as empty.
        postsList = Collections.emptyList();
    }

    @Override
    protected Object getObjForPosition(int position) {
        return postsList.get(position);
    }


    @Override
    protected int getLayoutIdForPosition(int position) {
        return postsList.get(position).getLayout(); // Obtain layout from PostItemViewModel class
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public void setPostsList(List<PostItemViewModel> postsList){
        this.postsList = postsList;
        notifyDataSetChanged();
    }
}
