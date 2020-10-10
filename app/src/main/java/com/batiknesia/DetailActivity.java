package com.batiknesia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.batiknesia.model.Batik;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    ImageView fotoku;
    TextView nama, detail,des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ButterKnife.bind(this);

        Batik tvDataReceived = getIntent().getParcelableExtra("kunci");

        fotoku = findViewById(R.id.img_view);
        nama = findViewById(R.id.txt_nama);
        detail = findViewById(R.id.txt_detail);
        des = findViewById(R.id.txt_ciri);


        Glide.with(this)
                .load(tvDataReceived.getFoto())
                .apply(new RequestOptions().override(100, 100))
                .into(fotoku);

        nama.setText(tvDataReceived.getNama());
        detail.setText(tvDataReceived.getCiri());
        des.setText(tvDataReceived.getDeskripsi());
    }
}
