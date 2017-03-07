# GettingStartedWithRetrofit

This is a code example how to use Retrofit and connect to git api.


Was done the interface:

    @GET("repos/{owner}/{repo}")
    Call<Contributor> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

Retro client:

    private static Retrofit getRetrofitInstance() {

        HttpLoggingInterceptor log = new HttpLoggingInterceptor();
        log.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(log);

        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public static GitHubService getApiService() {
        return getRetrofitInstance().create(GitHubService.class);
    }
