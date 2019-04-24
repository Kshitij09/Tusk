package com.kshitijpatil.tusk.ui.products;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.data.model.Product;
import com.kshitijpatil.tusk.ui.productdetail.ProductDetailsActivity;

import java.util.List;

public class ProductListActivity extends AppCompatActivity implements ListProductContract.View, ProductsAdapter.OnItemClickListener {
    boolean isLoading = false;
    ProductListPresenter<ListProductContract.View> presenter;
    ProductsAdapter adapter;
    RecyclerView recyclerProducts;

    public static final String EXTRA_INDEX = "com.kshitijpatil.tusk.ui.products.EXTRA_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        presenter = new ProductListPresenter<>();
        presenter.onAttach(this);
        List<Product> productList = presenter.getProductList();
        adapter = new ProductsAdapter(productList, this);
        recyclerProducts = findViewById(R.id.rv_product_list);
        recyclerProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerProducts.setAdapter(adapter);
    }

    @Override
    public void progressBarEnabled(boolean status) {
        isLoading = status;
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(ProductListActivity.this, ProductDetailsActivity.class);
        intent.putExtra(EXTRA_INDEX, position);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
