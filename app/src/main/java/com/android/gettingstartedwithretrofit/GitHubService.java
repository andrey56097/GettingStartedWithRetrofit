package com.android.gettingstartedwithretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by batsa on 06.03.2017.
 */

public interface GitHubService {


    @GET("repos/{owner}/{repo}")
    Call<Repos> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);


//    @GET("users/{owner}/repos")
//    Call<ReposList> reposOfUser(
//            @Path("owner") String owner);


    @GET("users/{user}/repos")
    Call<List<Repos>> listRepos(@Path("user") String user);

}
