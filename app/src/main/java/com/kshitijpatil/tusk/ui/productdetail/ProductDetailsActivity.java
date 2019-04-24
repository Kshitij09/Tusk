package com.kshitijpatil.tusk.ui.productdetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kshitijpatil.tusk.R;
import com.kshitijpatil.tusk.databinding.ActivityProductDetailsBinding;
import com.kshitijpatil.tusk.ui.cart.CartActivity;
import com.kshitijpatil.tusk.ui.products.ProductListActivity;
import com.kshitijpatil.tusk.util.Converter;

public class ProductDetailsActivity extends AppCompatActivity implements ProductDetailsContract.View {
    private static final String TAG = "ProductDetailsActivity";
    ActivityProductDetailsBinding binding;
    ProductDetailsPresenter<ProductDetailsContract.View> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_details);
        Intent intent = getIntent();
        int index = intent.getIntExtra(ProductListActivity.EXTRA_INDEX, 0);
        presenter = new ProductDetailsPresenter<>(index);
        presenter.onAttach(this);

        binding.setLifecycleOwner(this);
        binding.setProduct(presenter.getProduct(index));
        binding.setPresenter(presenter);
    }


    @Override
    public void onAddedToCart(boolean existing) {
        if (!existing) {
            // Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
            invalidateOptionsMenu();
        } else {
            startActivity(new Intent(ProductDetailsActivity.this, CartActivity.class));
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.cart_action);
        item.setIcon(Converter.convertLayoutToImage(this, presenter.getCartItemCount(), R.drawable.ic_shopping_cart));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
