package com.kshitijpatil.tusk.ui.cart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kshitijpatil.tusk.R;

public class CartActivity extends AppCompatActivity {
    private static final String TAG = "CartActivity";
    RecyclerView recyclerCart;
    CartPresenter<CartContract.View> presenter;
    CartAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        presenter = new CartPresenter<>();
        adapter = new CartAdapter(presenter.getCartItems());
        recyclerCart = findViewById(R.id.recycler_cart);
        recyclerCart.setLayoutManager(new LinearLayoutManager(this));
        recyclerCart.setAdapter(adapter);
    }
}
