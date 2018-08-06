package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Spinner spnYesNo;
    Button btnUpdate;
    ArrayList<String> alNumber;
    ArrayAdapter<String> aaNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUpdate = findViewById(R.id.buttonUpdate);
        spnYesNo = findViewById(R.id.spinner);
        spn2 = findViewById(R.id.spinner2);


        alNumber = new ArrayList<>();
        aaNumber = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumber);
        /*
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spn1.getSelectedItemPosition();
                alNumber.clear();

                if (pos == 0){
                    String[] strNumber = getResources().getStringArray(R.array.even_numbers);
                    alNumber.addAll(Arrays.asList(strNumber));
                }else if (pos == 1){
                    String[] strNumber = getResources().getStringArray(R.array.odd_numbers);
                    alNumber.addAll(Arrays.asList(strNumber));
                }

                spn2.setAdapter(aaNumber);
            }
        });
        */
        spnYesNo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                i = spnYesNo.getSelectedItemPosition();
                String[] strNumber;
                switch(i){
                    case 0:
                        alNumber.clear();
                        strNumber = getResources().getStringArray(R.array.even_numbers);
                        alNumber.addAll(Arrays.asList(strNumber));
                        spn2.setAdapter(aaNumber);
                        spn2.setSelection(2);
                        break;
                    case 1:
                        alNumber.clear();
                        strNumber = getResources().getStringArray(R.array.odd_numbers);
                        alNumber.addAll(Arrays.asList(strNumber));
                        spn2.setAdapter(aaNumber);
                        spn2.setSelection(1);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
