package com.example.appbanquanao.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Activity.SanPhamActivity;
import com.example.appbanquanao.Model.YeuThichModel;
import com.example.appbanquanao.R;

import java.util.List;

public class YeuThichAdapter extends RecyclerView.Adapter<YeuThichAdapter.ViewHolder> {
    private List<YeuThichModel> lstYeuThichModels;
    private Boolean yeuThich;

    public YeuThichAdapter(List<YeuThichModel> lstYeuThichModels, Boolean yeuThich) {
        this.lstYeuThichModels = lstYeuThichModels;
        this.yeuThich = yeuThich;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.yeu_thich_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resource=lstYeuThichModels.get(position).getProductImage();
        String title=lstYeuThichModels.get(position).getProductTitle();
        int freeCouponNo=lstYeuThichModels.get(position).getFreeCopens();
        String diemDanhGia=lstYeuThichModels.get(position).getRating();
        int soLuongDanhGia=lstYeuThichModels.get(position).getTotalRating();
        String giaSP=lstYeuThichModels.get(position).getProductPrice();
        String giaSPCu=lstYeuThichModels.get(position).getCuttedPrice();

        holder.SetData( resource,  title,  freeCouponNo,  diemDanhGia,  soLuongDanhGia,  giaSP,  giaSPCu);
    }

    @Override
    public int getItemCount() {
        return lstYeuThichModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewLoveGiaSPCu;
        private TextView textViewLoveGiaSP;
        private TextView textViewSoLuongDanhGiaLove;
        private TextView textViewDiemDanhGiaLove;
        private ImageView imageViewDIemDanhGiaLove;
        private ImageView imageViewLoveAnhSp;
        private TextView textViewLoveTenSP;
        private ImageView freeCouponIconLove;
        private TextView txtFreeCoupenLove;
        private ImageView imageViewDeleteLove;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            textViewLoveGiaSPCu = itemView.findViewById(R.id.textView_Love_GiaSPCu);
            textViewLoveGiaSP = itemView.findViewById(R.id.textView_Love_GiaSP);
            textViewSoLuongDanhGiaLove = itemView.findViewById(R.id.textView_SoLuongDanhGia_Love);
            textViewDiemDanhGiaLove = itemView.findViewById(R.id.textView_DiemDanhGia_Love);
            imageViewDIemDanhGiaLove = itemView.findViewById(R.id.imageView_DIemDanhGia_Love);
            imageViewLoveAnhSp = itemView.findViewById(R.id.imageView_Love_anhSp);
            textViewLoveTenSP = itemView.findViewById(R.id.textView_Love_TenSP);
            freeCouponIconLove = itemView.findViewById(R.id.freeCouponIcon_love);
            txtFreeCoupenLove = itemView.findViewById(R.id.txt_free_coupen_Love);
            imageViewDeleteLove = itemView.findViewById(R.id.imageView_Delete_Love);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent thongTinSPIntent = new Intent(itemView.getContext(), SanPhamActivity.class);
                    itemView.getContext().startActivity(thongTinSPIntent);
                }
            });

        }
        private void SetData(int resource, String title, int freeCouponNo, String diemDanhGia, int soLuongDanhGia, String giaSP, String giaSPCu){
            imageViewLoveAnhSp.setImageResource(resource);
            textViewLoveTenSP.setText(title);
            if(freeCouponNo!=0){
                freeCouponIconLove.setVisibility(View.VISIBLE);
                if(freeCouponNo==1){
                    txtFreeCoupenLove.setText("free "+freeCouponNo+" copen");
                }else{
                    txtFreeCoupenLove.setText("free "+freeCouponNo+" copens");
                }
            }else{
                freeCouponIconLove.setVisibility(View.INVISIBLE);
                txtFreeCoupenLove.setVisibility(View.INVISIBLE);
            }

            textViewDiemDanhGiaLove.setText(diemDanhGia);
            textViewSoLuongDanhGiaLove.setText(soLuongDanhGia+" Ratings");
            textViewLoveGiaSP.setText(giaSP);
            textViewLoveGiaSPCu.setText(giaSPCu);
            if(yeuThich){
                imageViewDeleteLove.setVisibility(View.VISIBLE);
            }else{
                imageViewDeleteLove.setVisibility(View.GONE);
            }

            imageViewDeleteLove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"Delete",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
