package com.kshitijpatil.tusk.ui.listproducts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kshitijpatil.tusk.R;

public class ProductListActivity extends AppCompatActivity implements ListProductContract.View {
    boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
    }

    @Override
    public void progressBarEnabled(boolean status) {
        isLoading = status;
    }
}
