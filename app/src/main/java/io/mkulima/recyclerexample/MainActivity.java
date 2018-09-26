package io.mkulima.recyclerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    CustomAdapter mCustomAdapter;
    ArrayList<User> mUserArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=findViewById(R.id.myRecyclerView);
        mUserArrayList=new ArrayList<>();
        mUserArrayList.add(new User("John Mark","Medicine","Chiromo",true));
        mUserArrayList.add(new User("Mary Jane","Chemistry","Chiromo",true));
        mUserArrayList.add(new User("Thomas Muller","Software Engineering","Main Campus",true));
        mUserArrayList.add(new User("Allain Julie","Engineering","Chiromo",true));
        mUserArrayList.add(new User("Maurice Green","Theology","Kabete",true));
        mUserArrayList.add(new User("Hellen Mwangi","Medicine","Chiromo",true));
        mUserArrayList.add(new User("Chris Rock","Geology","Kenya Poly",true));
        mCustomAdapter=new CustomAdapter(this, mUserArrayList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        //For horizontal scrolling
        //LinearLayoutManager layoutManager  = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mCustomAdapter);

    }
}
