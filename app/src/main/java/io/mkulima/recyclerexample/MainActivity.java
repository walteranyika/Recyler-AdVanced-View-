package io.mkulima.recyclerexample;

import android.app.SearchManager;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    CustomAdapter mCustomAdapter;
    ArrayList<User> mUserArrayList;
    SearchView mSearchView;
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

        whiteNotificationBar(mRecyclerView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        //For horizontal scrolling
        //LinearLayoutManager layoutManager  = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mCustomAdapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        //Searching Bit
        SearchManager searchManager= (SearchManager) getSystemService(SEARCH_SERVICE);
        mSearchView= (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        mSearchView.setMaxWidth(Integer.MAX_VALUE);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mCustomAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mCustomAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.app_bar_search){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }
}
