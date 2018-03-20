package com.krp.mvvm.viewModel;

import android.content.Intent;
import android.os.Parcel;
import android.view.View;

import com.krp.mvvm.R;
import com.krp.mvvm.model.Post;
import com.krp.mvvm.views.activities.PostsDetailsActivity;

/**
 * Created by rakeshpraneeth on 3/19/18.
 * This class should extend RowViewModel class.
 * Implement parcelable since RowViewModel implements Parcelable
 */

public class PostItemViewModel extends RowViewModel{

    private Post post;

    public PostItemViewModel(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public int getLayout() {
        return R.layout.custom_post_item;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.post, flags);
    }

    protected PostItemViewModel(Parcel in) {
        this.post = in.readParcelable(Post.class.getClassLoader());
    }

    public static final Creator<PostItemViewModel> CREATOR = new Creator<PostItemViewModel>() {
        @Override
        public PostItemViewModel createFromParcel(Parcel source) {
            return new PostItemViewModel(source);
        }

        @Override
        public PostItemViewModel[] newArray(int size) {
            return new PostItemViewModel[size];
        }
    };

    public void onPostItemClicked(View view, Post post){
        Intent intent = new Intent(view.getContext(), PostsDetailsActivity.class);
        intent.putExtra(PostsDetailsActivity.POST_ID,post.getId());
        intent.putExtra(PostsDetailsActivity.POST_DETAILS_OBJ,post);
        view.getContext().startActivity(intent);
    }
}
