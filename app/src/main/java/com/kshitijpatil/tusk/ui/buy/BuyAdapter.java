package com.kshitijpatil.tusk.ui.buy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.databinding.ItemBuyReceiptBinding;

import java.util.List;

public class BuyAdapter extends ArrayAdapter<Product> {
    List<Product> cartProducts;
    LayoutInflater inflater;
    Context context;

    public BuyAdapter(@NonNull Context context, @NonNull List<Product> cartProducts) {
        super(context, -1, cartProducts);
        this.context = context;
        this.cartProducts = cartProducts;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder")
        ItemBuyReceiptBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_buy_receipt, parent, false);
        binding.setProduct(cartProducts.get(position));
        return binding.getRoot();
    }
}
