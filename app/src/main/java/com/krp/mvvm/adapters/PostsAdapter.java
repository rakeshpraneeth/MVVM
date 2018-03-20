package com.krp.mvvm.adapters;

import com.krp.mvvm.viewModel.PostItemViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by rakeshpraneeth on 3/19/18.
 * This class extends BindableAdapter class and override methods
 */

public class PostsAdapter extends BindableAdapter{

    List<PostItemViewModel> postsList;

    public PostsAdapter(){
        postsList = Collections.emptyList();
    }
    @Override
    protected Object getObjForPosition(int position) {
        return postsList.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return postsList.get(position).getLayout();
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
