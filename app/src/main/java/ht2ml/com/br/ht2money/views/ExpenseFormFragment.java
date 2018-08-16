package ht2ml.com.br.ht2money.views;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

import ht2ml.com.br.ht2money.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpenseFormFragment extends Fragment {

    private EditText dateField;
    private DatePickerDialog.OnDateSetListener dateListener;

    public ExpenseFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_expense_form, container, false);

        Spinner categoryList = view.findViewById(R.id.spinnerCategoriesList);
        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(
                view.getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.expense_category)
        );
        categoriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoryList.setAdapter(categoriesAdapter);

        Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        final int month = cal.get(Calendar.MONTH);
        final int day = cal.get(Calendar.DAY_OF_MONTH);

        String dateString = Integer.toString(day) + '/' + Integer.toString(month) + '/' + Integer.toString(year);
        dateField = view.findViewById(R.id.dateField);
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

        return view;
    }

}
