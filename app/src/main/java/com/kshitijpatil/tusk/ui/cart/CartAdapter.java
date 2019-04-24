package com.kshitijpatil.tusk.ui.cart;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.databinding.ItemCartListBinding;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartItemHolder> {
    List<Product> cartList;
    private LayoutInflater inflater;


    CartAdapter(List<Product> cartList) {
        this.cartList = cartList;
    }


    @NonNull
    @Override
    public CartItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null)
            inflater = LayoutInflater.from(parent.getContext());
        ItemCartListBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_cart_list, parent, false);

        return new CartItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemHolder holder, int position) {
        holder.binding.setProduct(cartList.get(position));
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    class CartItemHolder extends RecyclerView.ViewHolder {
        ItemCartListBinding binding;

        public CartItemHolder(ItemCartListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
