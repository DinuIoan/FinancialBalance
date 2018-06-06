package financialbalance.appsyouneed.idinu.financialbalance;



import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;
import android.support.design.widget.TabLayout;

import java.util.ArrayList;
import java.util.List;

import financialbalance.appsyouneed.idinu.financialbalance.allMonths.AllMonthsActivity;
import financialbalance.appsyouneed.idinu.financialbalance.currentMonth.CurrentMonthActivity;

public class MainActivity extends AppCompatActivity {
    private Button currentMonthButton;
    private Button allMonthsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentMonthButton = (Button) findViewById(R.id.button_current_month);
        allMonthsButton = (Button) findViewById(R.id.button_all_months);

        currentMonthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent currentMonthIntent = new Intent(MainActivity.this, CurrentMonthActivity.class);
                startActivity(currentMonthIntent);
            }
        });

        allMonthsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allMonthsIntent = new Intent(MainActivity.this, AllMonthsActivity.class);
                startActivity(allMonthsIntent);
            }
        });
    }


}
