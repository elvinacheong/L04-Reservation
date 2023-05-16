package sg.edu.rp.c346.id22016916.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView tvName;
    EditText etName;

    TextView tvMobile;
    EditText etMobile;

    TextView tvGroup;
    EditText etGroup;

    TextView tvDate;
    DatePicker dp;

    TextView tvTime;
    TimePicker tp;

    TextView tvTable;
    RadioGroup rgTable;

    Button btReservation;

    Button btClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.textViewName);
        etName = findViewById(R.id.editTextName);

        tvMobile = findViewById(R.id.textViewNumber);
        etMobile = findViewById(R.id.editTextNumber);

        tvGroup = findViewById(R.id.textViewGroupSize);
        etGroup = findViewById(R.id.editTextGroupSize);

        tvDate = findViewById(R.id.textViewDate);
        dp = findViewById(R.id.datePicker);

        tvTime = findViewById(R.id.textViewTime);
        tp = findViewById(R.id.timePicker);

        tvTable = findViewById(R.id.textViewTable);
        rgTable = findViewById(R.id.radioGroup);

        btReservation = findViewById(R.id.buttonConfirmReservation);

        btClear = findViewById(R.id.buttonClear);


        btReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int groupSize = Integer.parseInt(etGroup.getText().toString());
                int tableOpt = rgTable.getCheckedRadioButtonId();
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() +1;
                int year = dp.getYear();
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();

                if (groupSize > 0) {
                    Toast.makeText(getApplicationContext(), "Table is booked for " + groupSize + " people", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid input", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(getApplicationContext(), "Day of reservation: " + day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Time of reservation: " + hour + ":" + min, Toast.LENGTH_SHORT).show();

                if (tableOpt == R.id.radioButton) {
                    Toast.makeText(getApplicationContext(), "Smoking table reserved", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Non-smoking table reserved", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etName.setText("");
                etMobile.getText().clear();
                etGroup.getText().clear();
                dp.updateDate(2020,0,1);
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);
            }
        });

    }
}