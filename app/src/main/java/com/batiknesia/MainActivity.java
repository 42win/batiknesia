package com.batiknesia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.batiknesia.adapter.ListBatikAdapter;
import com.batiknesia.model.Batik;
import com.batiknesia.model.BatikData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBatik;
    private ArrayList<Batik> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisiasi recyler view pd main activity
        rvBatik = findViewById(R.id.rv_batik);
        rvBatik.setHasFixedSize(true);

        //panggil data di kelas data
        list.addAll(BatikData.getListData());

        //menampilkan data dengan method
        showRecylerList();

    }

    //setelah inisiasi kita akan panggil data yg sudah kita buat di class TarianData
    private void showRecylerList() {
        rvBatik.setLayoutManager(new LinearLayoutManager(this));
        ListBatikAdapter listBatikAdapter = new ListBatikAdapter(list);
        rvBatik.setAdapter(listBatikAdapter);

        //tambahan untuk parsing data ke activity lain dengan keypair kunci
        listBatikAdapter.setOnItemClickCallback(new ListBatikAdapter.OnItemClickCallback(){
            @Override
            public void onItemClicked(Object data){
                Batik batik = (Batik) data;
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("kunci", batik);
                startActivity(intent);
            }
        });
        listBatikAdapter.setListBatik(list);
        rvBatik.setAdapter(listBatikAdapter);

    }

    //menu about
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.about){
            Intent intent = new Intent(MainActivity.this,AboutActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}
