package com.kshitijpatil.tusk.ui.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.databinding.ItemProductListBinding;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductHolder> {
    List<Product> products;
    private LayoutInflater inflater;
    private OnItemClickListener listener;

    public ProductsAdapter(List<Product> products, OnItemClickListener listener) {
        this.products = products;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null)
            inflater = LayoutInflater.from(parent.getContext());
        ItemProductListBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_product_list, parent, false);

        return new ProductHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        holder.binding.setProduct(products.get(position));
        holder.binding.getRoot().setOnClickListener((v) -> {
            if (listener != null)
                listener.onItemClicked(products.indexOf(holder.binding.getProduct()));
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder {
        ItemProductListBinding binding;

        ProductHolder(ItemProductListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(int position);
    }
}
