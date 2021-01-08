package com.company.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

public class ShoppingCartActivity extends AppCompatActivity {
    List<Product> shoppingCart;
    ShoppingCartAdapter shoppingCartAdapter;
    RecyclerView recyclerViewShoppingCartList;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Shopping Cart");

        shoppingCart = (List<Product>) getIntent().getSerializableExtra("ShoppingCart");

        recyclerViewShoppingCartList = findViewById(R.id.recyclerViewCartList);
        recyclerViewShoppingCartList.setLayoutManager(new GridLayoutManager(ShoppingCartActivity.this, 1));

        tvTotal = findViewById(R.id.textViewTotal);

        shoppingCartAdapter = new ShoppingCartAdapter(ShoppingCartActivity.this, shoppingCart, tvTotal);

        recyclerViewShoppingCartList.setAdapter(shoppingCartAdapter);
    }
}
