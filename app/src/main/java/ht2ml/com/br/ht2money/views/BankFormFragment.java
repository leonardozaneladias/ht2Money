package ht2ml.com.br.ht2money.views;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ht2ml.com.br.ht2money.R;
import ht2ml.com.br.ht2money.controllers.BankController;
import io.realm.Realm;


/**
 * A simple {@link Fragment} subclass.
 */
public class BankFormFragment extends Fragment implements View.OnClickListener {

    private EditText bankTxt;
    private EditText onwerTxt;
    private EditText agencyTxt;
    private EditText balanceTxt;
    private View view;

    private Button saveBtn, cancelBtn;

    public BankFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bank_form, container, false);

        bankTxt = view.findViewById(R.id.bankText);
        agencyTxt = view.findViewById(R.id.agencyText);
        onwerTxt = view.findViewById(R.id.onwerText);
        balanceTxt = view.findViewById(R.id.balanceText);

        saveBtn = view.findViewById(R.id.saveBankBtn);
        cancelBtn = view.findViewById(R.id.cancelBankBtn);

        saveBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

        return view;
    }

    public void saveBankAccount(){

        if(!bankTxt.getText().toString().isEmpty() && !agencyTxt.getText().toString().isEmpty() && !onwerTxt.getText().toString().isEmpty() && !balanceTxt.getText().toString().isEmpty()){

            String onwer = onwerTxt.getText().toString();
            Double balance = Double.valueOf(balanceTxt.getText().toString());
            String bankName = bankTxt.getText().toString();
            String agency = agencyTxt.getText().toString();

            BankController.create(onwer, balance, bankName, agency);
            Toast.makeText(view.getContext(), "Banco criado", Toast.LENGTH_LONG).show();

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new BankInfoFragment()).commit();

        }else{
            Log.i("actionHt2", "nao entrou");
            Snackbar.make(view, "Nenhum dos campos podem ser vazios!", Snackbar.LENGTH_LONG)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .show();
            return;
        }


    }

    public void cancelAction(){

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new NoBankFragment()).commit();

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.saveBankBtn){
            Log.i("actionHt2", "save");
            saveBankAccount();
        }else if(view.getId() == R.id.cancelBankBtn){
            Log.i("actionHt2", "save");
            cancelAction();
        }

    }
}
