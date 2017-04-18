package com.mllwf.oval;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ML on 2017/4/18.
 */

public class ListItemActivty extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mList = new ArrayList<>();
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new MyAdapter(mList, this);
        mAdapter.setOnClickListener(new MyAdapter.onItemCLikListener() {
            @Override
            public void onTvClick(String view) {
                Toast.makeText(ListItemActivty.this, view, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCheckBoxClick(View view) {
                Toast.makeText(ListItemActivty.this, ((CheckBox) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        for (int i = 0; i < 250; i++) {
            mList.add("我是第" + i + "个Cell");
        }
    }
}
