package com.batiknesia.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.batiknesia.R;
import com.batiknesia.model.Batik;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.sql.Blob;
import java.util.ArrayList;

import butterknife.OnItemClick;

public class ListBatikAdapter  extends RecyclerView.Adapter<ListBatikAdapter.ListViewHolder> {
    //deklarasi
    private ArrayList<Batik> listBatik;
    private OnItemClickCallback onItemClickCallback ; //fungsi click ..1

    //fungsi click ..2
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    //Constructor adalah method khusus yang akan dieksekusi pada saat pembuatan objek (instance) Biasanya method ini digunakan untuk inisialisasi atau mempersiapkan data untuk objek.
    public ListBatikAdapter(ArrayList<Batik> list){
        this.listBatik = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //return null; ditambahkan yg dibwh
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row__batik, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final Batik batik = listBatik.get(position);

        Glide.with(holder.itemView.getContext())
                .load(batik.getFoto())
                .apply(new RequestOptions().override(100,100))
                .into(holder.imgPhoto);

        holder.tvName.setText(batik.getNama());
        holder.tvFrom.setText(batik.getCiri());
        //holder.tvDes.setText(batik.getDeskripsi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listTarian.get(holder.getAdapterPosition()).getName() +listTarian.get(position), Toast.LENGTH_SHORT).show();
                onItemClickCallback.onItemClicked(listBatik.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        //return 0; ingat ganti ini kalau tidak tdak muncul datanya
        return listBatik.size();
    }

    public ArrayList<Batik> getListTarian() {
        return listBatik;
    }

    public void setListBatik(ArrayList<Batik> listBatik) {
        this.listBatik = listBatik;
    }


    class ListViewHolder extends RecyclerView.ViewHolder {
        //ditambahkan
        ImageView imgPhoto;
        TextView tvName, tvFrom, tvDes;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_batik_name);
            tvFrom = itemView.findViewById(R.id.tv_ciri);
            //tvDes = itemView.findViewById(R.id.tv_deskripsi);
        }
    }

    //fungsi click ..4  interface untuk variabel onitemclickcallback
    public interface OnItemClickCallback {
        void onItemClicked(Object data);
    }

}
