package com.company.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductsViewHolder> {
    Context context;
    TextView textViewProductQuantity;
    Button buttonViewShoppingCart;
    List<Product> productList;
    List<Product> shoppingCart;

    /**
     * @param context                 context en el que se va a aplicar el adapter
     * @param productList             lista de productos
     * @param buttonViewShoppingCart  boton para mostrar el carrito de compra
     * @param shoppingCart            carrito de compra al que se enviara
     * @param textViewProductQuantity cantidad de productos en el carrito
     */
    public ProductAdapter(Context context, TextView textViewProductQuantity, Button buttonViewShoppingCart, List<Product> productList, List<Product> shoppingCart) {
        this.context = context;
        this.textViewProductQuantity = textViewProductQuantity;
        this.buttonViewShoppingCart = buttonViewShoppingCart;
        this.productList = productList;
        this.shoppingCart = shoppingCart;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_products, null, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductsViewHolder productsViewHolder, final int i) {
        productsViewHolder.textViewProductName.setText(productList.get(i).getProductName());
        productsViewHolder.textViewDescription.setText(productList.get(i).getDescription());
        productsViewHolder.textViewPrice.setText("" + productList.get(i).getPrice());

        productsViewHolder.checkBoxShoppingCart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (productsViewHolder.checkBoxShoppingCart.isChecked()) {
                    textViewProductQuantity.setText("" + (Integer.parseInt(textViewProductQuantity.getText().toString().trim()) + 1));
                    shoppingCart.add(productList.get(i));
                } else if (!productsViewHolder.checkBoxShoppingCart.isChecked()) {
                    textViewProductQuantity.setText("" + (Integer.parseInt(textViewProductQuantity.getText().toString().trim()) - 1));
                    shoppingCart.remove(productList.get(i));
                }
            }
        });

        buttonViewShoppingCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent viewShoppingCartIntent = new Intent(context, ShoppingCartActivity.class);
                viewShoppingCartIntent.putExtra("ShoppingCart", (Serializable) shoppingCart);
                context.startActivity(viewShoppingCartIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {
        TextView textViewProductName, textViewDescription, textViewPrice;
        CheckBox checkBoxShoppingCart;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            checkBoxShoppingCart = itemView.findViewById(R.id.checkboxShoppingCart);
        }
    }
}