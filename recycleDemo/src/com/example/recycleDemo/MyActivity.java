package com.example.recycleDemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private RecyclerView mRecyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      mRecyclerView = (RecyclerView) findViewById(R.id.recyleView);
    ListAdapterHolder mAdapter = new ListAdapterHolder();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mAdapter.setmItemClickListener(new ListAdapterHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }
}
