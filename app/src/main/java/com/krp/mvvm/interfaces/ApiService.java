package com.krp.mvvm.interfaces;

import com.krp.mvvm.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rakeshpraneeth on 3/19/18.
 * This interface is used to handle all the API calls using Retrofit.
 * It contains methods such as GET,POST,...
 * Each operation will have a method and some parameters depending on the type of operation we perform.
 */

public interface ApiService {

    @GET("/users")
    Call<List<User>> getAllUsers();
}
