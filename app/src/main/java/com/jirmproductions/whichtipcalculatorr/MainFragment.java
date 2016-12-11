package com.jirmproductions.whichtipcalculatorr;

/**
 * Created by Josh on 12/10/2016.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainFragment extends Fragment {

    TextView tipPerPerson;
    TextView billPerPerson;
    EditText billAmount;
    EditText percentToTip;
    EditText numberInParty;
    Button calcButton;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        tipPerPerson = (TextView) rootView.findViewById(R.id.textViewTipPerPerson);
        billPerPerson = (TextView) rootView.findViewById(R.id.textViewBillPerPerson);

        billAmount = (EditText) rootView.findViewById(R.id.billAmountEditText);
        percentToTip = (EditText) rootView.findViewById(R.id.percentToTipEditText);
        numberInParty = (EditText) rootView.findViewById(R.id.numberInPartyEditText);

        calcButton = (Button) rootView.findViewById(R.id.button);

        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                try{
                    double bill = Double.parseDouble(billAmount.getText().toString());
                    double percent = Double.parseDouble(percentToTip.getText().toString());
                    double party = Double.parseDouble(numberInParty.getText().toString());

                    if(party<=0.0d)
                    {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Please enter a party greater than 0 :-)",
                                Toast.LENGTH_SHORT).show();
                    }else {

                        double billPerPersons = bill / party;
                        double totalTip = billPerPersons * (percent / 100);
                        double totalBill = billPerPersons + totalTip;

                        NumberFormat formatter = NumberFormat.getCurrencyInstance();

                        tipPerPerson.setText(formatter.format(totalTip));
                        billPerPerson.setText(formatter.format(totalBill));
                    }

                }catch(Exception e)
                {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Please fill in all fields",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }
}
