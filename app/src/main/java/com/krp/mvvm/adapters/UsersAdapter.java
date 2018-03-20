package com.krp.mvvm.adapters;

import com.krp.mvvm.viewModel.UserItemViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by rakeshpraneeth on 3/19/18.
 * Adapter used to show the Users list.
 * This class extends BindableAdapter class and override methods
 *
 */

public class UsersAdapter extends BindableAdapter {

    private List<UserItemViewModel> usersList;

    public UsersAdapter(){
        usersList = Collections.emptyList();
    }

    @Override
    protected Object getObjForPosition(int position) {
        return usersList.get(position);
    }

    // This method returns which layout is being used for the item.
    @Override
    protected int getLayoutIdForPosition(int position) {
        return usersList.get(position).getLayout();     // obtained from the UserItemViewModel class.
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public void setUsersList(List<UserItemViewModel> usersList){
        this.usersList = usersList;
        notifyDataSetChanged();
    }
}
