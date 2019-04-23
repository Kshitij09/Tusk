package com.kshitijpatil.tusk.ui.listproducts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.databinding.ActivityProductListBinding;
import com.kshitijpatil.tusk.ui.data.model.Product;

import java.util.List;

public class ProductListActivity extends AppCompatActivity implements ListProductContract.View {
    boolean isLoading = false;
    ActivityProductListBinding binding;
    ProductListPresenter<ListProductContract.View> presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list);

        presenter = new ProductListPresenter<>();

        List<Product> productList = presenter.getProductList();
        binding.setProductFirst(new Product("Amazon Echo", 7999, "Amazon Echo is a hands-free speaker you control with your voice", 4.7f));
    }

    @Override
    public void progressBarEnabled(boolean status) {
        isLoading = status;
    }
}
