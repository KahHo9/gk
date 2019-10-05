package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.view.View;
import android.util.Log;



public class MainActivity extends AppCompatActivity {
    int amount =1;
    int basePrice =5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMinus=findViewById(R.id.btn_minus);
        Button btnPlus=findViewById(R.id.btn_plus);
        final TextView tvAmount=findViewById(R.id.tv_amount);
        final CheckBox checkboxCream=findViewById(R.id.checkbox_cream);
        final CheckBox checkboxChocolateShip=findViewById(R.id.checkbox_chocolateship);
        final CheckBox checkboxVanilla=findViewById(R.id.checkbox_vanilla);
        Button btnOrder=findViewById(R.id.btn_order);
        final TextView tvThankYou=findViewById(R.id.tv_ty);

        btnMinus.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if(amount>1){
                amount--;
            }else{
                amount=1;
            }
            tvAmount.setText(Integer.toString(amount));
        }
    });
       btnPlus.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               amount++;
               tvAmount.setText(Integer.toString(amount));
           }
       });
        btnOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int finalPrice=basePrice;
                if(checkboxCream.isChecked()){
                    finalPrice += 1;
                }
                if(checkboxChocolateShip.isChecked()){
                    finalPrice += 2;
                }
                if(checkboxVanilla.isChecked()){
                    finalPrice+=3;
                }
                finalPrice*= amount;

               Log.d("Final Price",Integer.toString(finalPrice));

                tvThankYou.setText("Thank for your order. \n The total price is $"+Integer.toString(finalPrice));
            }
        });
    }
    }

