package com.kshitijpatil.tusk.ui.products;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.data.model.Product;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductHolder> {
    List<Product> products;

    public ProductsAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products_row, parent, false);

        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public interface OnItemClickListener {
        void onItemClicked(int position);
    }

    class ProductHolder extends RecyclerView.ViewHolder {
        ImageView imgPreview;
        TextView txtName, txtRating, txtPrice;
        View contentView;

        ProductHolder(View view) {
            super(view);
            contentView = view;
            imgPreview = view.findViewById(R.id.img_preview);
            txtName = view.findViewById(R.id.txt_name);
            txtRating = view.findViewById(R.id.txt_rating);
            txtPrice = view.findViewById(R.id.txt_price);
        }

        void bind(Product product) {
            imgPreview.setImageDrawable(contentView.getContext().getDrawable(product.getPreview()));
            txtName.setText(product.getName());
            txtPrice.setText(String.format(contentView.getContext().getString(R.string.rs_string), product.getPrice()));
            txtRating.setText(String.valueOf(product.getRating()));
        }
    }
}
