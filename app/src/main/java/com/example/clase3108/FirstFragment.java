package com.example.clase3108;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.clase3108.databinding.FragmentFirstBinding;

import java.util.concurrent.ScheduledExecutorService;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private EditText txt_number1, txt_number2, txt_res;

    private RadioButton rad_sum, rad_sub, rad_mul, rad_div;

    private RadioGroup rad_group;

    private CheckBox box_sum, box_res, box_mul, box_div;


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

        box_sum = (CheckBox) binding.boxSum;
        box_res = (CheckBox) binding.boxRes;
        box_mul = (CheckBox) binding.boxMul;
        box_div = (CheckBox) binding.boxDiv;

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

        binding.boxSum.setOnClickListener((View v) ->{
            rad_group.clearCheck();
        });
        binding.boxRes.setOnClickListener((View v) ->{
            rad_group.clearCheck();
        });
        binding.boxDiv.setOnClickListener((View v) ->{
            rad_group.clearCheck();
        });
        binding.boxMul.setOnClickListener((View v) ->{
            rad_group.clearCheck();
        });
        binding.radSum.setOnClickListener((View v) ->{
            clearBoxes();
        });
        binding.radSub.setOnClickListener((View v) ->{
            clearBoxes();
        });
        binding.radMultiply.setOnClickListener((View v) ->{
            clearBoxes();
        });
        binding.radDivide.setOnClickListener((View v) ->{
            clearBoxes();
        });

        binding.btnCalculate.setOnClickListener((View v) -> {
            txt_res.setText("");
            if (rad_sum.isChecked()) {
                sum();

            } else if (rad_sub.isChecked()) {
                sub();

            } else if (rad_mul.isChecked()) {
                mul();

            } else if (rad_div.isChecked()) {
                div();

            }else if(box_sum.isChecked()||box_res.isChecked()||box_mul.isChecked()||box_div.isChecked()){
                if (box_sum.isChecked()) {
                    txt_res.setText("SUM:" + sum());
                }
                if (box_res.isChecked()) {
                    txt_res.setText(txt_res.getText() + "  RES:" + sub());
                }
                if (box_mul.isChecked()) {
                    txt_res.setText(txt_res.getText() + "  MUL:" + mul());
                }
                if (box_div.isChecked()) {
                    txt_res.setText(txt_res.getText() + "  DIV:" + div());
                }
            }else{
                Toast.makeText(this.getContext(),
                        "No se ha seleccionado una operación",Toast.LENGTH_LONG).show();
            }


        });
    }

    public void clearBoxes(){
        box_sum.setChecked(false);
        box_res.setChecked(false);
        box_mul.setChecked(false);
        box_div.setChecked(false);
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
            double sum = val_1 / val_2;
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