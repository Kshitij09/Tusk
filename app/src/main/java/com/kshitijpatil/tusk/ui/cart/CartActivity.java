package com.kshitijpatil.tusk.ui.cart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
    private static final String TAG = "CartActivity";
    CartPresenter<CartContract.View> presenter;
    CartAdapter adapter;
    ActivityCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart);

        presenter = new CartPresenter<>();
        adapter = new CartAdapter(presenter.getCartItems());
        adapter.setItemRemovedListener(product -> presenter.removeCartItem(product));
        adapter.setQuantityChangedListener((product, quantity) -> presenter.setItemQuantity(product, quantity));
        binding.recyclerCart.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerCart.setAdapter(adapter);
        binding.setPresenter(presenter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.setCartList(presenter.getCartItems());
    }
}
