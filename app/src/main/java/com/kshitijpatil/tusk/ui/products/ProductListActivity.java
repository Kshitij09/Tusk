package com.kshitijpatil.tusk.ui.products;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.data.model.Product;

import java.util.List;

public class ProductListActivity extends AppCompatActivity implements ListProductContract.View {
    boolean isLoading = false;
    ProductListPresenter<ListProductContract.View> presenter;
    ProductsAdapter adapter;
    RecyclerView recyclerProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        presenter = new ProductListPresenter<>();
        presenter.onAttach(this);

        List<Product> productList = presenter.getProductList();
        adapter = new ProductsAdapter(productList);
        recyclerProducts = findViewById(R.id.rv_product_list);
        recyclerProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerProducts.setAdapter(adapter);
    }

    @Override
    public void progressBarEnabled(boolean status) {
        isLoading = status;
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
