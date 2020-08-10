package com.example.appbanquanao.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Model.ChiTietSanPhamModel;
import com.example.appbanquanao.R;

import java.util.List;

public class ChiTietSPAdapter extends RecyclerView.Adapter<ChiTietSPAdapter.ViewHolder> {
    List<ChiTietSanPhamModel> lstChoTietSanPhamModels ;

    public ChiTietSPAdapter(List<ChiTietSanPhamModel> lstChoTietSanPhamModels) {
        this.lstChoTietSanPhamModels = lstChoTietSanPhamModels;
    }

    @Override
    public int getItemViewType(int position) {
        switch(lstChoTietSanPhamModels.get(position).getType()){
            case 0:
                return ChiTietSanPhamModel.CHITIET_TITLE;
            case 1:
                return ChiTietSanPhamModel.CHITIET_BODY;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public ChiTietSPAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch(viewType) {
            case ChiTietSanPhamModel.CHITIET_TITLE:
                TextView txtTitle=new TextView(parent.getContext());
                txtTitle.setTypeface(null, Typeface.BOLD);
                txtTitle.setTextColor(Color.BLACK);
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(setDp(16,parent.getContext())
                        ,setDp(16,parent.getContext())
                        ,setDp(16,parent.getContext())
                        ,setDp(8,parent.getContext()));
                txtTitle.setLayoutParams(layoutParams);
                return new ViewHolder(txtTitle);

            case ChiTietSanPhamModel.CHITIET_BODY:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chi_tiet_sp_item_layout, parent, false);
                return new ViewHolder(view);
            default :
                return null;
        }




    }

    @Override
    public void onBindViewHolder(@NonNull ChiTietSPAdapter.ViewHolder holder, int position) {
        switch(lstChoTietSanPhamModels.get(position).getType()) {
            case ChiTietSanPhamModel.CHITIET_TITLE:
               holder.setTitle(lstChoTietSanPhamModels.get(position).getTitle());
               // Log.e("ERROR123","lỗi thực thi câu lệnh SELECT: "+lstChoTietSanPhamModels.get(position).getTitle() );
               break;
            case ChiTietSanPhamModel.CHITIET_BODY:
                String tieuDe=lstChoTietSanPhamModels.get(position).getTieuDe();
                String noiDung=lstChoTietSanPhamModels.get(position).getNoiDung();
               // Log.e("ERROR123","lỗi thực thi câu lệnh 2 : "+lstChoTietSanPhamModels.get(position).getTieuDe());
                holder.setThongTin(tieuDe,noiDung);
                break;
            default :
                return;
        }

    }

    @Override
    public int getItemCount() {
        return lstChoTietSanPhamModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewChiTietSPTieuDe;
        private TextView textViewChiTietSPNoiDung;
        private TextView title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
        private void setTitle(String titleText){
            title= (TextView) itemView;
            title.setText(titleText);
        }
        public void setThongTin(String tieuDe, String noiDung){
            textViewChiTietSPTieuDe = itemView.findViewById(R.id.textView_ChiTiet_SP_TieuDe);
            textViewChiTietSPNoiDung = itemView.findViewById(R.id.textView_ChiTietSP_NoiDung);

            textViewChiTietSPTieuDe.setText(tieuDe);
            textViewChiTietSPNoiDung.setText(noiDung);
        }
    }

    private int setDp(int dp, Context context){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }
}
