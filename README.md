# GettingStartedWithRetrofit

This is a code example how to use Retrofit and connect to git api.


Was done the interface:

 @GET("repos/{owner}/{repo}")
    Call<Contributor> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);
