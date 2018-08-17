package ht2ml.com.br.ht2money.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ht2ml.com.br.ht2money.R;
import ht2ml.com.br.ht2money.controllers.BankController;
import ht2ml.com.br.ht2money.models.Bank;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentBalanceFragment extends Fragment {


    public CurrentBalanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_current_balance, container, false);

        TextView balanceTxt = view.findViewById(R.id.balanceResultTxt);
        balanceTxt.setText(getResources().getString(R.string.coin) + " " + String.format("%.2f", BankController.getBalance()));

        return  view;
    }

}
