package ht2ml.com.br.ht2money.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ht2ml.com.br.ht2money.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BankInfoFragment extends Fragment {


    public BankInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bank_info, container, false);
    }

}
