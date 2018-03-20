package com.krp.mvvm.viewModel;

import android.content.Intent;
import android.os.Parcel;
import android.view.View;

import com.krp.mvvm.R;
import com.krp.mvvm.model.User;
import com.krp.mvvm.views.activities.PostsActivity;

/**
 * Created by rakeshpraneeth on 3/19/18.
 * This class should extend RowViewModel class.
 * Implement parcelable since RowViewModel implements Parcelable
 */

public class UserItemViewModel extends RowViewModel{

    private User user;

    public UserItemViewModel(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    // Define the Layou you want to use for this item.
    // We will use this method in the custom adapter to bind layout to adapter.
    @Override
    public int getLayout() {
        return R.layout.custom_user_item;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    protected UserItemViewModel(Parcel in) {
    }

    public static final Creator<UserItemViewModel> CREATOR = new Creator<UserItemViewModel>() {
        @Override
        public UserItemViewModel createFromParcel(Parcel source) {
            return new UserItemViewModel(source);
        }

        @Override
        public UserItemViewModel[] newArray(int size) {
            return new UserItemViewModel[size];
        }
    };

    // This method will be triggered when user click on the custom_user_item.xml layout
    public void navigateToUserPosts(View view, User user){

        Intent intent = new Intent(view.getContext(), PostsActivity.class);
        intent.putExtra(PostsActivity.USER_ID,user.getId());
        view.getContext().startActivity(intent);
    }
}
