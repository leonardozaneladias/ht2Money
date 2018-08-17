package ht2ml.com.br.ht2money.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import ht2ml.com.br.ht2money.R;
import ht2ml.com.br.ht2money.controllers.EarningController;
import ht2ml.com.br.ht2money.controllers.ExpenseController;
import ht2ml.com.br.ht2money.models.Expense;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TextView expensesTxt = view.findViewById(R.id.expensesTxt);
        float totalExpenses = ExpenseController.getMonthTotal();
        String totalExpensesTxt = String.format("%.2f", totalExpenses);
        expensesTxt.setText(getString(R.string.coin) + " " + totalExpensesTxt);

        TextView earningxt = view.findViewById(R.id.earningsTxt);
        float totalEarning = EarningController.getMonthTotal();
        String totalEarningsTxt = String.format("%.2f", totalEarning);
        earningxt.setText(getString(R.string.coin) + " " + totalEarningsTxt);

        TextView economyTxt = view.findViewById(R.id.economyTxt);
        float economyTotal = totalEarning - totalExpenses;
        String economyTotalTxt = String.format("%.2f", economyTotal);
        economyTxt.setText(getString(R.string.coin) + " " + economyTotalTxt);

        if(economyTotal > 0){
            economyTxt.setTextColor(getResources().getColor(R.color.economyPositive));
        }else{
            economyTxt.setTextColor(getResources().getColor(R.color.economyNegative));
        }

        return view;
    }

}
