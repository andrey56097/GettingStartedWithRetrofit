package com.android.gettingstartedwithretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by batsa on 06.03.2017.
 */

public interface GitHubService {


    @GET("repos/{owner}/{repo}")
    Call<Contributor> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

}
