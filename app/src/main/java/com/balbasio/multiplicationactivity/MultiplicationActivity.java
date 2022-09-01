package com.balbasio.multiplicationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.balbasio.multiplicationactivity.databinding.ActivityMultiplicationBinding;

import java.util.Random;


class MultiplicationActivity extends AppCompatActivity {
    private ActivityMultiplicationBinding binding;
    int result=0;
    Random random = new Random();
    int n1,n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication);
        binding = ActivityMultiplicationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
    public void startButtonClick(View view){
        n1= random.nextInt(10)+1;
        binding.firstNumber.setText("" +n1);
        n2= random.nextInt(10)+1;
        binding.secondNumber.setText(""+n2);
    }
    public void guessButtonClick(View view){
        int correct = n1*n2;
        if (binding.resultText.getText().toString().matches("")) {
            binding.resultText.setText("Enter a number");
        } else {
            result = Integer.parseInt(binding.resultText.getText().toString());
        }
        if(result==correct){
            Toast.makeText(MultiplicationActivity.this,"CORRECT!", Toast.LENGTH_SHORT).show();
            //veritabanında skor arttır
        }else{
            Toast.makeText(MultiplicationActivity.this,"False! Correct was : " + correct  , Toast.LENGTH_SHORT).show();
        }

    }
}