package sg.edu.rp.c346.id20026389.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TimePicker tp;
    DatePicker dp;
    EditText inputname;
    EditText inputnumber;
    EditText inputpax;
    CheckBox inputsmoking;
    Button reset;
    Button submit;
    TextView displayname;
    TextView displaynumber;
    TextView displaypax;
    TextView displaysmoking;
    TextView displaybooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tp=findViewById(R.id.timePicker);
        dp=findViewById(R.id.datePicker);
        inputname=findViewById(R.id.editTextName);
        inputnumber=findViewById(R.id.editTextNumber);
        inputpax=findViewById(R.id.editTextGroupSize);
        inputsmoking=findViewById(R.id.checkBoxSmoking);
        reset=findViewById(R.id.reset);
        submit=findViewById(R.id.submit);
        displayname=findViewById(R.id.textViewDisplayName);
        displaynumber=findViewById(R.id.textViewContact);
        displaypax=findViewById(R.id.textViewPax);
        displaysmoking=findViewById(R.id.textViewSmokingTable);
        displaybooking=findViewById(R.id.textViewDateTime);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputname.getText().toString().trim().length()!=0 && inputnumber.getText().toString().trim().length()!=0
                        && inputpax.getText().toString().trim().length()!=0){
                    displayname.setText("Name: "+inputname.getText().toString());
                    displaynumber.setText("Contact: "+inputnumber.getText().toString());
                    displaypax.setText("Group Size: "+inputpax.getText().toString());
                    if(inputsmoking.isChecked()==true){
                        displaysmoking.setText("You chose Smoking Table Area.");
                    }else{
                        displaysmoking.setText("You chose Non-Smoking Table Area.");
                    }
                    displaybooking.setText("Your Booking is on "+dp.getDayOfMonth()+"/"+(1+dp.getMonth())+"/"+dp.getYear()+
                            " at "+tp.getCurrentHour()+":"+tp.getCurrentMinute()+".");
                }
                else{
                    Toast.makeText(MainActivity.this, "Please Provide All Information", Toast.LENGTH_LONG).show();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputname.setText("");
                inputnumber.setText("");
                inputpax.setText("");
                inputsmoking.setChecked(false);

                displaybooking.setText("");
                displaynumber.setText("");
                displaysmoking.setText("");
                displaypax.setText("");
                displayname.setText("");

                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020,5,1);
            }
        });


    }
}