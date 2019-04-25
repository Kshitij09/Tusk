package com.kshitijpatil.tusk.ui.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.databinding.ActivityCartBinding;
import com.kshitijpatil.tusk.ui.buy.BuyActivity;

public class CartActivity extends AppCompatActivity implements CartContract.View {
    CartPresenter<CartContract.View> presenter;
    CartAdapter adapter;
    ActivityCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart);

        presenter = new CartPresenter<>();
        presenter.onAttach(this);
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

    @Override
    public void progressBarEnabled(boolean status) {

    }

    @Override
    public void navigateBuy(View view) {
        startActivity(new Intent(CartActivity.this, BuyActivity.class));
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
