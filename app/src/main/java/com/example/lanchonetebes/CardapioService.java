package com.example.lanchonetebes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CardapioService {

    // https://api.github.com/users/mariojp/repos
//    @GET("users/{user}/repos")
//    Call<List<User>> listRepos(@Path("user") String user);

    //https://raw.githubusercontent.com/mariojp/evento/main/mock.json
    @GET("mariojp/evento/main/mock.json")
    Call<List<Produto>> produtos();
}
