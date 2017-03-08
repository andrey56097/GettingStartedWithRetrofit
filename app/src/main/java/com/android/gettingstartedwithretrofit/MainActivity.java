package com.android.gettingstartedwithretrofit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private List<String> strings;
    private List<Repos> repos1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ListView lvMain = (ListView) findViewById(R.id.lvMain);

        //  находим список
//        final ListView lvMain = (ListView) findViewById(R.id.lvMain);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                strings = new ArrayList<>();
                repos1 = new ArrayList<>();
//                lvMain.setAdapter(null);


                final ProgressDialog dialog;
                dialog = new ProgressDialog(MainActivity.this);
                dialog.setTitle("Scanning");
                dialog.setMessage("get info from server");
                dialog.show();

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


                GitHubService api = RetroClient.getApiService();
                Call<List<Repos>> repos = api.listRepos("andrey56097");



                repos.enqueue(new Callback<List<Repos>>() {
                    @Override
                    public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {
                        dialog.dismiss();

                        if (response.isSuccessful()) {

                            repos1 = response.body();


                            for (int i = 0; i < 9;i++) {

                                strings.add(i, repos1.get(i).getFullName()+"");
                            }


                            // создаем адаптер
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                                    android.R.layout.simple_list_item_1, strings);

                            // присваиваем адаптер списку
                            lvMain.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Repos>> call, Throwable t) {

                    }
                });
//                // находим список
//                ListView lvMain = (ListView) findViewById(R.id.lvMain);
//
//                // создаем адаптер
//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
//                        android.R.layout.simple_list_item_1, names);
//
//                // присваиваем адаптер списку
//                lvMain.setAdapter(adapter);

            }
        });


//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(final View view) {
//
//                GitHubService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
//                Call<Repos> call = api.repoContributors("andrey56097", "Android-app-test-2");
//
//                call.enqueue(new Callback<Repos>() {
//                    @Override
//                    public void onResponse(Call<Repos> call, Response<Repos> response) {
//                        final TextView textView = (TextView) findViewById(R.id.textView);
//
//                        Snackbar.make(view, "Soo good", Snackbar.LENGTH_LONG)
//                                .setAction("Action", null).show();
//
//                        if (response.isSuccessful()) {
//                            textView.setText(response.body().getOwner().getLogin());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Repos> call, Throwable t) {
//                        final TextView textView = (TextView) findViewById(R.id.textView);
//
//
//                        textView.setText("Something went wrong: " + t.getMessage());
//                    }
//                });


//            }
//        });

//        getRepos();
    }

    public void getRepos(){

        View v = null;
        final ProgressDialog dialog;
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle("Scanning");
        dialog.setMessage("get info from server");
        dialog.show();

        Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();


        GitHubService api = RetroClient.getApiService();
        Call<List<Repos>> repos = api.listRepos("andrey56097");

        final ListView lvMain = (ListView) findViewById(R.id.lvMain);

        repos.enqueue(new Callback<List<Repos>>() {
            @Override
            public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {
                dialog.dismiss();

                if (response.isSuccessful()) {

                    repos1 = response.body();


                    for (int i = 0; i < 9;i++) {

                        strings.add(i, repos1.get(i).getFullName()+"");
                    }


                    // создаем адаптер
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                            android.R.layout.simple_list_item_1, strings);

                    // присваиваем адаптер списку
                    lvMain.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Repos>> call, Throwable t) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
