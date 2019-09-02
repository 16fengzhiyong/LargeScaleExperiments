package devil.com.largescaleexperiments.activitys;

import android.graphics.Color;
import android.graphics.PointF;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.idtk.smallchart.chart.LineChart;
import com.idtk.smallchart.data.LineData;
import com.idtk.smallchart.interfaces.iData.ILineData;

import java.util.ArrayList;

import devil.com.largescaleexperiments.R;
import devil.com.largescaleexperiments.common.TitleBar;
import devil.com.largescaleexperiments.fragment.LineChartFragment;

public class ShowMassageActivity extends AppCompatActivity {
    protected float[][] points = new float[][]{{1,52}, {2,13}, {3,51}, {4,20}, {5,19},{6,20}, {7,54}, {8,7}, {9,19}, {10,41}};
    protected float[][] points1 = new float[][]{{1,24}, {2,46}, {3,77}, {4,60}, {5,78},{6,68}, {7,74}, {8,27}, {9,19}, {10,61}};
    TitleBar titleBar;
    private LineData mLineData = new LineData();
    LineChart lineChart,lineChart_temperature,lineChart_illumination;
//    private Fragment lineChartFragment,lineChartFragment2;
//    private FragmentTransaction fragmentTransaction,fragmentTransaction2;
    private ArrayList<ILineData> mDataList = new ArrayList<>();
    private ArrayList<PointF> mPointArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_massage);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        titleBar = findViewById(R.id.title_bar);
        titleBar.setMyCenterTitle("信息");
//        installData();
        initData();
//        inittest();
        initTemperatureData();
        intILluminationData();
    }


    private void initData() {
        for (int i = 0; i < 9; i++) {
            mPointArrayList.add(new PointF(points[i][0], points[i][1]));
        }
        mLineData.setValue(mPointArrayList);
        mLineData.setColor(Color.MAGENTA);
        mDataList.add(mLineData);
    }
//    public void inittest(){
//
//        lineChart = (LineChart)findViewById(R.id.lineChart_1);
////        lineChart.setData(mLineData);
//        lineChart.setDataList(mDataList);
//
//    }



    public void initTemperatureData(){
        lineChart_temperature = (LineChart)findViewById(R.id.lineChart_temperature);
        lineChart_temperature.setDataList(mDataList);
    }
    public void intILluminationData(){
        lineChart_illumination = (LineChart)findViewById(R.id.lineChart_illumination);
        lineChart_illumination.setDataList(mDataList);
    }
//    public void installData(){
//        FragmentManager manager=getSupportFragmentManager();
//        lineChartFragment = manager.findFragmentByTag("Tag0");
//        lineChartFragment2 = manager.findFragmentByTag("Tag2");
//        fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
//
//
//
//        if (lineChartFragment != null){
//            fragmentTransaction.hide(lineChartFragment);
//        }
//        if (lineChartFragment == null){
//            lineChartFragment = new LineChartFragment();
//            fragmentTransaction.add(R.id.chart_fragments_1,lineChartFragment,"Tag0");
//        }else {
//            fragmentTransaction.show(lineChartFragment);
//        }
//        fragmentTransaction.commit();//提交事务
//
//
//
//
//        if (lineChartFragment2 != null){
//            fragmentTransaction2.hide(lineChartFragment2);
//        }
//        if (lineChartFragment2 == null){
//            lineChartFragment2 = new LineChartFragment();
//            fragmentTransaction2.add(R.id.chart_fragments_2,lineChartFragment2,"Tag2");
//        }else {
//            fragmentTransaction2.show(lineChartFragment2);
//        }
//        fragmentTransaction2.commit();//提交事务
//    }
}
