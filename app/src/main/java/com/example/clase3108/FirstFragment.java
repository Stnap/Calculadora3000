package com.example.clase3108;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.clase3108.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private EditText txt_number1, txt_number2, txt_res;

    private RadioButton rad_sum, rad_sub, rad_mul, rad_div;

    private RadioGroup rad_group;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        txt_number1 = (EditText) binding.txtNumber1;
        txt_number2 = (EditText) binding.txtNumber2;
        txt_res = (EditText) binding.txtRes;
        rad_sum = (RadioButton) binding.radSum;
        rad_sub = (RadioButton) binding.radSub;
        rad_mul = (RadioButton) binding.radMultiply;
        rad_div = (RadioButton) binding.radDivide;
        rad_group = (RadioGroup) binding.radGroup;

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.btnCalculate.setOnClickListener((View v) -> {
            if (rad_sum.isChecked()) {
                sum();
            } else if (rad_sub.isChecked()) {
                sub();
            } else if (rad_mul.isChecked()) {
                mul();
            } else if (rad_div.isChecked()) {
                div();
            } else {
                showMessage();
            }
        });
    }

    public void showMessage() {
        Toast.makeText(this.getContext(), "No se ha seleccionado ninguna operación", Toast.LENGTH_SHORT).show();
    }

    public String sum() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 + val_2;
        String res = String.valueOf(sum);
        txt_res.setText(res);
        return res;
    }

    public String sub() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 - val_2;
        String res = String.valueOf(sum);
        txt_res.setText(res);
        return res;
    }

    public String mul() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        double sum = val_1 * val_2;
        String res = String.valueOf(sum);
        txt_res.setText(res);
        return res;
    }

    public String div() {
        double val_1 = Integer.parseInt(txt_number1.getText().toString());
        double val_2 = Integer.parseInt(txt_number2.getText().toString());
        String res = "";
        if (val_2 != 0) {
            double sum = val_1 * val_2;
            res = String.valueOf(sum);
            txt_res.setText(res);
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