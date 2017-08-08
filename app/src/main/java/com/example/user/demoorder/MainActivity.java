package com.example.user.demoorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecycleViewAdapter(getDataset());
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        ((MyRecycleViewAdapter) adapter).setOnItemClickListener(new MyRecycleViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                System.out.println("position click " + position);
            }
        });
    }

    private ArrayList<TitleModel> getDataset(){
        ArrayList<TitleModel> results = new ArrayList();
        for (int index = 0; index < 20; index++){
            TitleModel model = new TitleModel("title №" + index, "description №" + index);
            results.add(index, model);
        }
        return results;
    }
}
