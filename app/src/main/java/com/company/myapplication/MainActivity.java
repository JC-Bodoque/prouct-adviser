package com.company.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextView textViewProductQuantity;
    Button buttonViewCart;
    RecyclerView recyclerViewProductList;
    ProductAdapter productAdapter;

    List<Product> productList = new ArrayList<>();
    List<Product> shoppingCart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Catalog");

        textViewProductQuantity = findViewById(R.id.textViewProductQuantity);

        buttonViewCart = findViewById(R.id.buttonViewCart);

        recyclerViewProductList = findViewById(R.id.recyclerViewProductList);
        recyclerViewProductList.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));

        // Lista de productos
        productList.add(new Product("1", "Product 1", "Lorem ipsum dolor sit amet, sed et magna", 10.0));
        productList.add(new Product("2", "Product 2", "Lorem ipsum dolor sit amet, sed et magna", 20.0));
        productList.add(new Product("3", "Product 3", "Lorem ipsum dolor sit amet, sed et magna", 30.0));
        productList.add(new Product("4", "Product 4", "Lorem ipsum dolor sit amet, sed et magna", 40.0));
        productList.add(new Product("5", "Product 5", "Lorem ipsum dolor sit amet, sed et magna", 50.0));

        productAdapter = new ProductAdapter(MainActivity.this, textViewProductQuantity, buttonViewCart, productList, shoppingCart);

        recyclerViewProductList.setAdapter(productAdapter);
    }
}