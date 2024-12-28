package com.example.petrosidakatalog.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.petrosidakatalog.R;
import com.example.petrosidakatalog.sqlite.Produk;

import java.util.List;

/**
 * Created by Farhan Cavalera on 22-Jun-17.
 */

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder> {

    private List<Produk> produkList;
    private final Context mContext;

    public ProdukAdapter(List<Produk> produkList, Context mContext) {
        this.produkList = produkList;
        this.mContext = mContext;
    }

    @Override
    public ProdukViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.produk_card, parent, false);
        return new ProdukViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProdukViewHolder holder, int position) {
        Produk produk = produkList.get(position);
        holder.tvProdukNama.setText(produk.getProdukNama());

        Resources res = mContext.getResources();
        String mDrawableName = produk.getProdukGambar();
        int resId = res.getIdentifier(mDrawableName, "drawable", mContext.getPackageName());
        //holder.ivProdukCover.setImageResource(resId);
        Glide.with(mContext).load(resId).into(holder.ivProdukCover);

    }

    @Override
    public int getItemCount() {
        return produkList.size();
    }

    public void swap(List<Produk> produkList) {
        this.produkList.clear();
        this.produkList.addAll(produkList);
        notifyDataSetChanged();
    }



    public class ProdukViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivProdukCover;
        public TextView tvProdukNama;

        public ProdukViewHolder(View itemView) {
            super(itemView);
            ivProdukCover = (ImageView)itemView.findViewById(R.id.ivProdukCover);
            tvProdukNama = (TextView)itemView.findViewById(R.id.tvProdukNama);
        }
    }
}