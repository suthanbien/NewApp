package com.example.appbanquanao.Adapter;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Model.OrderModel;
import com.example.appbanquanao.R;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private  List<OrderModel> lstOrderModel;

    public OrderAdapter(List<OrderModel> lstOrderModel) {
        this.lstOrderModel = lstOrderModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order_item_layout, parent, false);


        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resource =lstOrderModel.get(position).getAnhSP();
        String tenSP=lstOrderModel.get(position).getTenSP();
        String tinhTrang=lstOrderModel.get(position).getTinhTrang();
        int checkTinhTrang=lstOrderModel.get(position).getTinhTrangAnh();
        int danhgia=lstOrderModel.get(position).getDanhGia();

        holder.SetData(resource,tenSP,tinhTrang,checkTinhTrang,danhgia);
    }

    @Override
    public int getItemCount() {
        return lstOrderModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewOrderTitle;
        private ImageView imageViewAnhSPOrther;
        private ImageView ortherTinhtrangImg;
        private TextView textViewOrderTinhTrang;
        private LinearLayout rateOrderContainer;
        private ImageButton imageButtonDanhGia1sOrder;
        private ImageButton imageButtonDanhGia2sOrder;
        private ImageButton imageButtonDanhGia3sOrder;
        private ImageButton imageButtonDanhGia4sOrder;
        private ImageButton imageButtonDanhGia5sOrder;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewOrderTitle = itemView.findViewById(R.id.textView_order_Title);
            imageViewAnhSPOrther = itemView.findViewById(R.id.imageView_AnhSP_orther);
            ortherTinhtrangImg = itemView.findViewById(R.id.orther_Tinhtrang_img);
            textViewOrderTinhTrang = itemView.findViewById(R.id.textView_order_tinhTrang);
            rateOrderContainer = itemView.findViewById(R.id.rate_order_container);
            imageButtonDanhGia1sOrder = itemView.findViewById(R.id.imageButton_danhGia1s_order);
            imageButtonDanhGia2sOrder = itemView.findViewById(R.id.imageButton_danhGia2s_order);
            imageButtonDanhGia3sOrder = itemView.findViewById(R.id.imageButton_danhGia3s_order);
            imageButtonDanhGia4sOrder = itemView.findViewById(R.id.imageButton_danhGia4s_order);
            imageButtonDanhGia5sOrder = itemView.findViewById(R.id.imageButton_danhGia5s_order);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        private void SetData(int resource, String tenSP, String tinhTrang, int checkTinhTrang,int danhgia){
            imageViewAnhSPOrther.setImageResource(resource);
            textViewOrderTitle.setText(tenSP);
            if(checkTinhTrang==0){
                ortherTinhtrangImg.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorXanhLa)));
            }else if(checkTinhTrang==1){
                ortherTinhtrangImg.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorVang)));
            }else if(checkTinhTrang==2){
                ortherTinhtrangImg.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.colorDo)));
            }
            textViewOrderTinhTrang.setText(tinhTrang);
            if(danhgia>0){
                SetRating(danhgia);

            }
            for(int i=0;i<rateOrderContainer.getChildCount();i++){
                final int starPosition=i;
                rateOrderContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SetRating(starPosition);
                    }
                });

            }

        }
        @SuppressLint("NewApi")
        private void SetRating(int starPosition) {
            for(int i=0;i<rateOrderContainer.getChildCount();i++){
                ImageView starBtn= (ImageView) rateOrderContainer.getChildAt(i);
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#D9D6DC")));
                if(i<=starPosition){
                    starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#6200EE")));
                }
            }
        }

    }
}
