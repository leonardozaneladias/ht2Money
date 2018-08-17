package ht2ml.com.br.ht2money.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ht2ml.com.br.ht2money.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoBankFragment extends Fragment {


    public NoBankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_no_bank, container, false);

        Button newBankBtn = view.findViewById(R.id.newBankBtn);
        newBankBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new BankFormFragment()).commit();
            }
        });

        return view;


    }

}
