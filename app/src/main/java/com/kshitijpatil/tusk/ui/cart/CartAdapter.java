package com.kshitijpatil.tusk.ui.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.databinding.ItemCartListBinding;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartItemHolder> {
    private static final String TAG = "CartAdapter";
    private List<Product> cartList;
    private LayoutInflater inflater;
    private OnItemRemovedListener itemRemovedListener;
    private OnQuantityChangedListener quantityChangedListener;


    CartAdapter(List<Product> cartList) {
        this.cartList = cartList;
    }


    @NonNull
    @Override
    public CartItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null)
            inflater = LayoutInflater.from(parent.getContext());
        ItemCartListBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_cart_list, parent, false);


        // Emitting {@OnItemRemovedListener#onItemRemoved}
        binding.btnRemove.setOnClickListener(v -> {
            System.out.println(cartList.indexOf(binding.getProduct()));
            Product product = binding.getProduct();
            notifyItemRemoved(cartList.indexOf(product));
            cartList.remove(product);
            if (itemRemovedListener != null)
                itemRemovedListener.onItemRemoved(product);
        });

        // Emitting {@OnQuantityChangedListener#onQuantityChanged}
        binding.spinnerQty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (quantityChangedListener != null) {
                    quantityChangedListener.onQuantityChanged(cartList.get(cartList.indexOf(binding.getProduct())),
                            Integer.parseInt(binding.spinnerQty.getSelectedItem().toString()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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

    public void setCartList(List<Product> cartList) {
        this.cartList = cartList;
        cartList.forEach(product -> System.out.println(product.getQuantity()));
        notifyDataSetChanged();
    }

    class CartItemHolder extends RecyclerView.ViewHolder {
        ItemCartListBinding binding;

        public CartItemHolder(ItemCartListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setItemRemovedListener(OnItemRemovedListener itemRemovedListener) {
        this.itemRemovedListener = itemRemovedListener;
    }

    public void setQuantityChangedListener(OnQuantityChangedListener quantityChangedListener) {
        this.quantityChangedListener = quantityChangedListener;
    }

    @FunctionalInterface
    interface OnItemRemovedListener {
        void onItemRemoved(Product product);
    }

    @FunctionalInterface
    interface OnQuantityChangedListener {
        void onQuantityChanged(Product product, int quantity);
    }

}
