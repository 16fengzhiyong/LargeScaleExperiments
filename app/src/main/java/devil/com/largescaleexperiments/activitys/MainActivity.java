package devil.com.largescaleexperiments.activitys;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import devil.com.largescaleexperiments.R;
import devil.com.largescaleexperiments.adapters.FirstViewAdapter;
import devil.com.largescaleexperiments.entityclass.FirstViewEntityClass;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView =null;
    ArrayList<FirstViewEntityClass> mFirstViewEntityList = new ArrayList<>();
    private TextView mIKnow;
    private LinearLayout mainTip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        initView();

        setDate();
        eventFloatingActionButton();

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new FirstViewAdapter(MainActivity.this, mFirstViewEntityList));
        initClick();
    }
    public void initView(){
        mRecyclerView=(RecyclerView)findViewById(R.id.first_page_show);
        mainTip = findViewById(R.id.main_tip);
        mIKnow = findViewById(R.id.konw_tip);
    }
    public void initClick(){
        mIKnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainTip.setVisibility(View.GONE);
                mainTip.setMinimumHeight(0);
                mRecyclerView.setAdapter(new FirstViewAdapter(MainActivity.this, mFirstViewEntityList));
            }
        });
    }
    public void eventFloatingActionButton(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                mFirstViewEntityList.add(new FirstViewEntityClass("3","15","56",true));
                mRecyclerView.setAdapter(new FirstViewAdapter(MainActivity.this, mFirstViewEntityList));

            }
        });
    }
    public void setDate(){
        mFirstViewEntityList.add(new FirstViewEntityClass("1","23","320",true));
        mFirstViewEntityList.add(new FirstViewEntityClass("2","45","46",true));

    }

}
