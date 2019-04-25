package com.kshitijpatil.tusk.ui.buy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.ui.products.ProductListActivity;

public class BuyActivity extends AppCompatActivity implements BuyContract.View {
    ListView listProductReceipt;
    BuyPresenter<BuyActivity> presenter;
    TextView txtTotal;
    FloatingActionButton fabCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        listProductReceipt = findViewById(R.id.list_items);
        txtTotal = findViewById(R.id.txt_total);
        presenter = new BuyPresenter<>();
        presenter.onAttach(this);
        BuyAdapter adapter = new BuyAdapter(this, presenter.getCart());
        listProductReceipt.setAdapter(adapter);
        txtTotal.setText(String.format(getResources().getString(R.string.total), presenter.getTotal()));
        fabCheckout = findViewById(R.id.fab_checkout);
        fabCheckout.setOnClickListener(v -> {
            presenter.placeOrder();
            Intent home = new Intent(BuyActivity.this, ProductListActivity.class);
            home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(home);
            finish();
        });
    }

    @Override
    public void progressBarEnabled(boolean status) {

    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
