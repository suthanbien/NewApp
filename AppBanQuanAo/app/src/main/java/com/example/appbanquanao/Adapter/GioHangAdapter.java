package com.example.appbanquanao.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanquanao.Model.GioHangItemModel;
import com.example.appbanquanao.R;

import java.util.List;

public class GioHangAdapter extends RecyclerView.Adapter {

    private List<GioHangItemModel> lstGioHangItemModel;

    public GioHangAdapter(List<GioHangItemModel> lstGioHangItemModel) {
        this.lstGioHangItemModel = lstGioHangItemModel;
    }

    @Override
    public int getItemViewType(int position) {
        switch(lstGioHangItemModel.get(position).getType()){
            case 0:
                return GioHangItemModel.CART_ITEM;
            case 1:
                return GioHangItemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch(viewType) {
            case GioHangItemModel.CART_ITEM:
                View cartItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
                return new CartItemViewHolder(cartItemView);

            case GioHangItemModel.TOTAL_AMOUNT:
                View cartTotalView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_total_amount_layout, parent, false);
                return new CartTotalAmountViewHolder(cartTotalView);

            default :
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch(lstGioHangItemModel.get(position).getType()) {
            case GioHangItemModel.CART_ITEM:
                int resource=lstGioHangItemModel.get(position).getProductImage();
                String title=lstGioHangItemModel.get(position).getProductTile();
                int freeCoupensNo=lstGioHangItemModel.get(position).getFreeCoupont();
                String giaSP=lstGioHangItemModel.get(position).getProductPrice();
                String giaSPCu=lstGioHangItemModel.get(position).getCotedPrice();
                int offerAppliedNo=lstGioHangItemModel.get(position).getOfferApplied();

                ((CartItemViewHolder)holder).setItemDetails(resource,title,freeCoupensNo,giaSP,giaSPCu,offerAppliedNo);

                break;
            case GioHangItemModel.TOTAL_AMOUNT:
                String totalItem=lstGioHangItemModel.get(position).getTotalItem();
                String totalItemPrice=lstGioHangItemModel.get(position).getTotalItemPrice();
                String deliveryPrice=lstGioHangItemModel.get(position).getDelivertyPrice();
                String totalAmount=lstGioHangItemModel.get(position).getTotalAmount();
                String saveAmount=lstGioHangItemModel.get(position).getSaveAmount();
                ((CartTotalAmountViewHolder)holder).SetToTalAmount(totalItem,totalItemPrice,deliveryPrice,totalAmount,saveAmount);
                break;
            default :
                return;
        }
    }

    @Override
    public int getItemCount() {
        return lstGioHangItemModel.size();
    }

    class CartItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewCartAnhSp;
        private TextView textViewCartTenSP;
        private TextView txtFreeCoupen;
        private TextView textViewCartGiaSP;
        private TextView textViewCartGiaSPCu;
        private TextView textViewCartOfferApplied;
        private TextView textViewCartCouponsApplied;
        private TextView textViewCartSoLuongSP;
        private LinearLayout kiemTraMaGGLayout;
        private Button buttonReDem;
        private LinearLayout cartRemoveItemBtn;
        private ImageView freeCouponIcon;





        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewCartAnhSp = itemView.findViewById(R.id.imageView_cart_anhSp);
            textViewCartTenSP = itemView.findViewById(R.id.textView_Cart_TenSP);
            txtFreeCoupen = itemView.findViewById(R.id.txt_free_coupen);
            textViewCartGiaSP = itemView.findViewById(R.id.textView_Cart_GiaSP);
            textViewCartGiaSPCu = itemView.findViewById(R.id.textView_Cart_GiaSPCu);
            textViewCartOfferApplied = itemView.findViewById(R.id.textView_cart_offer_applied);
            textViewCartCouponsApplied = itemView.findViewById(R.id.textView_cart_coupons_applied);
            textViewCartSoLuongSP = itemView.findViewById(R.id.textView_cart_SoLuongSP);
            kiemTraMaGGLayout = itemView.findViewById(R.id.kiemTra_MaGG_Layout);
            buttonReDem = itemView.findViewById(R.id.buttonReDem);
            cartRemoveItemBtn = itemView.findViewById(R.id.cart_remove_item_btn);
            freeCouponIcon =itemView.findViewById(R.id.freeCouponIcon);


        }
        private void setItemDetails(int resource,String title,int FreeCoupensNo,String giaSP,String giaSPCu,int offerAppliedNo){
            imageViewCartAnhSp.setImageResource(resource);
            textViewCartTenSP.setText(title);
            if(FreeCoupensNo>0){
                freeCouponIcon.setVisibility(View.VISIBLE);
                txtFreeCoupen.setVisibility(View.VISIBLE);
                if(FreeCoupensNo==1){
                    txtFreeCoupen.setText("free "+FreeCoupensNo+" coupons");
                }else{
                    txtFreeCoupen.setText("free "+FreeCoupensNo+" coupons");
                }
            }else{
                freeCouponIcon.setVisibility(View.INVISIBLE);
                txtFreeCoupen.setVisibility(View.INVISIBLE);
            }

            textViewCartGiaSP.setText(giaSP);
            textViewCartGiaSPCu.setText(giaSPCu);

            if(offerAppliedNo>0){
                textViewCartOfferApplied.setVisibility(View.VISIBLE);
                textViewCartOfferApplied.setText(offerAppliedNo+" offers applied");
            }else{
                textViewCartOfferApplied.setVisibility(View.INVISIBLE);
            }

        }
    }

    class CartTotalAmountViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewTotalItem;
        private TextView textViewTotalItemPrice;
        private TextView textViewDeliveryPrice;
        private TextView textViewTotalPrice;
        private TextView textViewSaveAmount;


        public CartTotalAmountViewHolder(@NonNull View itemView) {
            super(itemView);


            textViewTotalItem = itemView.findViewById(R.id.textView_total_item);
            textViewTotalItemPrice = itemView.findViewById(R.id.textView_total_item_price);
            textViewDeliveryPrice = itemView.findViewById(R.id.textView_delivery_price);
            textViewTotalPrice = itemView.findViewById(R.id.textView_total_price);
            textViewSaveAmount = itemView.findViewById(R.id.textView_save_amount);

        }
        private void SetToTalAmount(String totalItem, String totalItemPrice, String deliveryPrice,String totalPrice,String saveAmount){
            textViewTotalItem.setText(totalItem);
            textViewTotalItemPrice.setText(totalItemPrice);
            textViewDeliveryPrice.setText(deliveryPrice);
            textViewTotalPrice.setText(totalPrice);
            textViewSaveAmount.setText(saveAmount);
        }
    }


}
