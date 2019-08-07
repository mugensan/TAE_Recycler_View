package com.example.tae_recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.OnPersonClickedListener {

    private RecyclerView rv_list;
    private ArrayList<Person>personList;
//    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateData();

        rv_list = findViewById(R.id.rv_list);

        personAdapter = new PersonAdapter(personList,this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv_list.setLayoutManager(layoutManager);

        //same as 2 last lines
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //now connecting the adapter to personAdapter
        rv_list.setAdapter(personAdapter);



    }

    public ArrayList<Person> generateData(){

        personList = new ArrayList<>();

        for(int i = 0; i <=30; i++){
            Person person = new Person("Kevin" + i,"Roditi" + i,i);
            personList.add(person);

        }
        Log.i(TAG, "firstName: " + personList.get(3).getFirstName());
        return personList;

    }

    @Override
    public void onItemClick(Person person) {
        Toast.makeText(this,"Person name is: " + person.getFirstName(),Toast.LENGTH_SHORT).show();

    }
}
