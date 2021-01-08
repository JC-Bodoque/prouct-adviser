package com.company.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ProductsViewHolder> {
    Context context;
    List<Product> shoppingCart;
    TextView tvTotal;
    double total = 0;

    public ShoppingCartAdapter(Context context, List<Product> shoppingCart, TextView tvTotal) {
        this.context = context;
        this.shoppingCart = shoppingCart;
        this.tvTotal = tvTotal;

        for (int i = 0; i < shoppingCart.size(); i++) {
            total = total + Double.parseDouble("" + shoppingCart.get(i).getPrice());
        }
        tvTotal.setText("" + total);
    }

    /**
     * Crea una vista para mostrar
     */
    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_shopping_cart, null, false);
        return new ProductsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductsViewHolder productsViewHolder, final int i) {
        productsViewHolder.textViewProductName.setText(shoppingCart.get(i).getProductName());
        productsViewHolder.textViewDescription.setText(shoppingCart.get(i).getDescription());
        productsViewHolder.textViewPrice.setText("" + shoppingCart.get(i).getPrice());

    }

    @Override
    public int getItemCount() {
        return shoppingCart.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {

        TextView textViewProductName, textViewDescription, textViewPrice;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
