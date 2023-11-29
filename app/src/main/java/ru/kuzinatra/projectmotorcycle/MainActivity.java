package ru.kuzinatra.projectmotorcycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int YEAR_PERCENT = 7;
    private static final int MONTHLY_INCOME = 3800;
    private static final int INIT_SUM = 5000;
    private static final int MOTO_PRICE = 23_500;

    private TextView output;
    private TextView output2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setValues();

        int monthResult = Calculate.monthsToDream(MOTO_PRICE, INIT_SUM, MONTHLY_INCOME, YEAR_PERCENT);
        output.setText(String.valueOf(monthResult));
        output.append(" месяца(-ев)");

        printCapital();
    }

    private void setValues() {
        output = findViewById(R.id.output);
        output2 = findViewById(R.id.output2);
        TextView value1 = findViewById(R.id.value_1);
        TextView value2 = findViewById(R.id.value_2);
        TextView value3 = findViewById(R.id.value_3);
        TextView value4 = findViewById(R.id.value_4);

        value1.setText(String.valueOf(INIT_SUM));
        value2.setText(String.valueOf(MONTHLY_INCOME));
        value3.setText(String.valueOf(YEAR_PERCENT));
        value4.setText(String.valueOf(MOTO_PRICE));
    }

    private void printCapital() {
        List<String> capitalList = Calculate.getCapitalList();
        for (int i = 0; i < capitalList.size(); i++) {
            if (i == 0) {
                output2.append("Начальный капитал: ");
                output2.append(capitalList.get(i));
                output2.append(" монет\n");
            } else {
                output2.append(i + " месяц: ");
                output2.append(capitalList.get(i));
                output2.append(" монет\n");
            }
        }
    }
}