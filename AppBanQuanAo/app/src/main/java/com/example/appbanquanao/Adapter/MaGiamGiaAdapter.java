package com.example.appbanquanao.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Model.MaGiamGiaModel;
import com.example.appbanquanao.R;

import java.util.List;

public class MaGiamGiaAdapter extends RecyclerView.Adapter<MaGiamGiaAdapter.ViewHolder> {

    private List<MaGiamGiaModel> lstMaGiamGiaModel;

    public MaGiamGiaAdapter(List<MaGiamGiaModel> lstMaGiamGiaModel) {
        this.lstMaGiamGiaModel = lstMaGiamGiaModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ma_giam_gia_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String maGiamGia=lstMaGiamGiaModel.get(position).getMaGiamGia();
        String thoiGian=lstMaGiamGiaModel.get(position).getThoiGian();
        String noiDungMGG=lstMaGiamGiaModel.get(position).getNoiDung();
        holder.SetData( maGiamGia, thoiGian, noiDungMGG);
    }

    @Override
    public int getItemCount() {
        return lstMaGiamGiaModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewMGG;
        private TextView textViewMGG;
        private TextView textViewMGGThoiGian;
        private TextView textViewMGGNoiDung;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewMGG = itemView.findViewById(R.id.imageView_MGG);
            textViewMGG = itemView.findViewById(R.id.textView_MGG);
            textViewMGGThoiGian = itemView.findViewById(R.id.textView_MGG_ThoiGian);
            textViewMGGNoiDung = itemView.findViewById(R.id.textView_MGG_NoiDung);
        }
        private void SetData(String maGiamGia,String thoiGian,String noiDungMGG){
            textViewMGG.setText(maGiamGia);
            textViewMGGThoiGian.setText(thoiGian);
            textViewMGGNoiDung.setText(noiDungMGG);
        }
    }
}
