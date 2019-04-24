package com.kshitijpatil.tusk.ui.productdetail;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.databinding.ActivityProductDetailsBinding;
import com.kshitijpatil.tusk.ui.products.ProductListActivity;

public class ProductDetailsActivity extends AppCompatActivity implements ProductDetailsContract.View {
    private static final String TAG = "ProductDetailsActivity";
    ActivityProductDetailsBinding binding;
    ProductDetailsPresenter<ProductDetailsContract.View> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_details);
        presenter = new ProductDetailsPresenter<>();
        presenter.onAttach(this);

        Intent intent = getIntent();
        int index = intent.getIntExtra(ProductListActivity.EXTRA_INDEX, 0);

        binding.setProduct(presenter.getProduct(index));

    }

    @Override
    public void navigateToCart() {

    }

    @Override
    public void navigateToBuy() {

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
