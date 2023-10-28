package com.ahmadabuhasan.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jancukers
 */

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCoin;
    private ArrayList<CoinActivity> list = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rvCoin = findViewById(R.id.rv_coin);
        rvCoin.setHasFixedSize(true);

        list.addAll(CoinData.getListData());
        showRecyclerList();
    }

    private void showSelectedCoin(CoinActivity coin) {
        Toast.makeText(this, "You choose " + coin.getName(), Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerList() {
        rvCoin.setLayoutManager(new LinearLayoutManager(this));
        final ListCoinAdapter listCoinAdapter = new ListCoinAdapter(list);
        rvCoin.setAdapter(listCoinAdapter);

        listCoinAdapter.setOnItemClickCallback(new ListCoinAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(CoinActivity data) {
                showSelectedCoin(data);
            }
        });

        ItemClick.addTo(rvCoin).setOnItemClickListener(new ItemClick.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent detail = new Intent(MainActivity.this, DetailActivity.class);
                detail.putExtra("Send", list.get(position));
                startActivity(detail);
                Toast.makeText(MainActivity.this, "Eid Al-Fitr 1441 H.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showRecyclerGrid() {
        rvCoin.setLayoutManager(new GridLayoutManager(this, 2));
        GridCoinAdapter gridCoinAdapter = new GridCoinAdapter(list);
        rvCoin.setAdapter(gridCoinAdapter);

        gridCoinAdapter.setOnItemClickCallback(new GridCoinAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(CoinActivity data) {
                showSelectedCoin(data);
            }
        });
    }

    private void showRecyclerCardView() {
        rvCoin.setLayoutManager(new LinearLayoutManager(this));
        CardViewCoinAdapter cardViewCoinAdapter = new CardViewCoinAdapter(list);
        rvCoin.setAdapter(cardViewCoinAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        setActionBarTitle(title);
    }
}