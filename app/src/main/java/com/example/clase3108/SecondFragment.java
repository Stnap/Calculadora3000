package com.example.clase3108;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.clase3108.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private EditText txt_num1, txt_num2, txt_resp2;
    private Spinner sp_operations;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        txt_num1=(EditText) binding.num1;
        txt_num2=(EditText) binding.num2;
        txt_resp2=(EditText) binding.resultado;
        sp_operations=(Spinner) binding.spinOptions;

        String[] operations={
                "Sumar",
                "Restar",
                "Multiplicar",
                "Dividir",
        };

          ArrayAdapter <String> adapter = new ArrayAdapter<>(this.getContext(),R.layout.spinner_item_1,operations);

          sp_operations.setAdapter(adapter);


        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_thirdFragment);
            }
        });
        
        binding.btnCal.setOnClickListener((View v)-> {
            String selected = sp_operations.getSelectedItem().toString();
            
            switch (selected){
                case "Sumar":{
                    sum();
                    break;
                }
                case "Restar":{
                    sub();
                    break;
                }
                case "Multiplicar":{
                    mul();
                    break;
                }
                case "Dividir":{
                    div();
                    break;
                }
            }
        });
    }

    public String sum() {
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        double sum = val_1 + val_2;
        String res = String.valueOf(sum);
        txt_resp2.setText(res);
        return res;
    }

    public String sub() {
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        double sum = val_1 - val_2;
        String res = String.valueOf(sum);
        txt_resp2.setText(res);
        return res;
    }

    public String mul() {
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        double sum = val_1 * val_2;
        String res = String.valueOf(sum);
        txt_resp2.setText(res);
        return res;
    }

    public String div() {
        double val_1 = Integer.parseInt(txt_num1.getText().toString());
        double val_2 = Integer.parseInt(txt_num2.getText().toString());
        String res = "";
        if (val_2 != 0) {
            double sum = val_1 / val_2;
            res = String.valueOf(sum);
            txt_resp2.setText(res);
        } else {
            Toast.makeText(this.getContext(), "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
        }
        return res;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}