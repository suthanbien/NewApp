package com.example.appbanquanao.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Activity.LoaiSanPhamActivity;
import com.example.appbanquanao.Model.LoaiSanPhamModel;
import com.example.appbanquanao.R;

import java.util.List;

public class LoaiSanPhamAdapter extends RecyclerView.Adapter<LoaiSanPhamAdapter.ViewHolder> {
    private List<LoaiSanPhamModel> lstLoaiSanPham;

    public LoaiSanPhamAdapter(List<LoaiSanPhamModel> lstLoaiSanPham) {
        this.lstLoaiSanPham = lstLoaiSanPham;
    }

    @NonNull
    @Override
    public LoaiSanPhamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.loaisp_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiSanPhamAdapter.ViewHolder holder, int position) {
        String tenLSP=lstLoaiSanPham.get(position).getTenLoaiSanPham();
        String linkIconLSP=lstLoaiSanPham.get(position).getIconLSPLink();

        holder.setLSP(tenLSP);

    }

    @Override
    public int getItemCount() {
        return lstLoaiSanPham.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iconLoaiSP;
        private TextView txt_TenLoaiSP;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconLoaiSP=itemView.findViewById(R.id.imageView_loaiSP);
            txt_TenLoaiSP=itemView.findViewById(R.id.textView_tenLoaiSP);
        }

        private void setIconLSP(){
            // todo set icon LSP

        }

        //t
        private void setLSP(final String ten){
            txt_TenLoaiSP.setText(ten);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent loaiSPIntent=new Intent(itemView.getContext(), LoaiSanPhamActivity.class);
                    loaiSPIntent.putExtra("TenLSP",ten);
                    itemView.getContext().startActivity(loaiSPIntent);
                }
            });
        }
    }
}
