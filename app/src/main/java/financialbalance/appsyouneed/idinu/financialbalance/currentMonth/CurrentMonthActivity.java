package financialbalance.appsyouneed.idinu.financialbalance.currentMonth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import financialbalance.appsyouneed.idinu.financialbalance.R;
import financialbalance.appsyouneed.idinu.financialbalance.recyclerview.ItemModel;
import financialbalance.appsyouneed.idinu.financialbalance.recyclerview.RecyclerViewAdapter;


public class CurrentMonthActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    public CurrentMonthActivity() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_month);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(generateRecyclerViewList());
        recyclerView = (RecyclerView) findViewById(R.id.simple_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public List<ItemModel> generateRecyclerViewList() {
        return new ArrayList<>();
    }

}
