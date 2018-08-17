package ht2ml.com.br.ht2money.views;


import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

import ht2ml.com.br.ht2money.R;
import ht2ml.com.br.ht2money.controllers.EarningController;
import ht2ml.com.br.ht2money.controllers.ExpenseController;


/**
 * A simple {@link Fragment} subclass.
 */
public class EarningsFormFragment extends Fragment implements View.OnClickListener{

    private EditText valueField;
    private EditText descriptionField;
    private EditText dateField;
    private CheckBox consolidatedField;
    private Button saveBtn;
    private DatePickerDialog.OnDateSetListener dateListener;
    private Spinner categoryList;
    private Button cancelBtn;


    public EarningsFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_earnings_form, container, false);

        valueField = view.findViewById(R.id.valueField);
        descriptionField = view.findViewById(R.id.descriptionField);

        categoryList= view.findViewById(R.id.spinnerCategoriesList);
        setCategorySpinner(view.getContext());
        dateField = view.findViewById(R.id.dateField);
        setDateField();

        cancelBtn = view.findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(this);

        consolidatedField = view.findViewById(R.id.consolidatedField);
        saveBtn = view.findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.saveBtn){

            if(!valueField.getText().toString().isEmpty() && !descriptionField.getText().toString().isEmpty()){
                getFieldsData();
                Toast.makeText(view.getContext(), "Ganho criado com sucesso!", Toast.LENGTH_SHORT).show();
                backToHome();
            }else{
                Snackbar.make(view, "Nenhum dos campos podem ser vazios!", Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        })
                        .show();
                return;
            }

        }else if(view.getId() == R.id.cancelBtn){
            backToHome();

        }

    }


    private void getFieldsData() {
        float value = Float.parseFloat(valueField.getText().toString());
        String description = descriptionField.getText().toString();
        String date = dateField.getText().toString();
        String category = categoryList.getSelectedItem().toString();
        boolean checkConsolidated = consolidatedField.isChecked();
        EarningController.newEarning(value, description, date, category, checkConsolidated);
    }

    private void setDateField() {

        Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        final int month = cal.get(Calendar.MONTH) + 1;
        final int day = cal.get(Calendar.DAY_OF_MONTH);

        String dateString = Integer.toString(day) + '/' + Integer.toString(month) + '/' + Integer.toString(year);

        dateField.setText(dateString);
        dateField.setKeyListener(null);

        dateField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("new", "ok");

                DatePickerDialog dialog = new DatePickerDialog(
                        view.getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dateListener,
                        year,
                        month,
                        day
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                String dateString = Integer.toString(day) + '/' + Integer.toString(month+1) + '/' + Integer.toString(year);
                dateField.setText(dateString);

            }
        };


    }

    private void setCategorySpinner(Context c) {

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(
                c,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.earning_category)
        );
        categoriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoryList.setAdapter(categoriesAdapter);

    }


    private void backToHome() {
        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        //((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.app_name);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MainFragment()).commit();
    }
}
