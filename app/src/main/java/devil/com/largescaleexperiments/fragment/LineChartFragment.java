package devil.com.largescaleexperiments.fragment;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.idtk.smallchart.chart.LineChart;
import com.idtk.smallchart.data.LineData;
import com.idtk.smallchart.interfaces.iData.ILineData;

import java.util.ArrayList;

import devil.com.largescaleexperiments.R;


/**
 * Created by Fzy on 2016/6/26.
 * Blog : http://www.idtkm.com
 * GitHub : https://github.com/Idtk
 * 描述 :
 */
public class LineChartFragment extends BaseFragment {
    protected float[][] points = new float[][]{{0,0}, {1,0}, {2,23920}, {3,24000}, {4,24000},{5,24000}, {6,24000}, {7,24000}, {9,29}, {10,31}};
    protected float[][] points2 = new float[][]{{1,52}, {2,13}, {3,51}, {4,20}, {5,19},{6,20}, {7,54}, {8,7}, {9,19}, {10,41}};

    private LineData mLineData = new LineData();
    private ArrayList<ILineData> mDataList = new ArrayList<>();
    private ArrayList<PointF> mPointArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_linechart,container,false);
        initData();
        LineChart lineChart = (LineChart) view.findViewById(R.id.lineChart);
//        lineChart.setData(mLineData);
        lineChart.setDataList(mDataList);
        return view;
    }

    private void initData() {
        for (int i = 0; i < 7; i++) {
            mPointArrayList.add(new PointF(points[i][0], points[i][1]));
        }
        mLineData.setValue(mPointArrayList);
        mLineData.setColor(Color.MAGENTA);
//        mLineData.setPaintWidth(pxTodp(3));
//        mLineData.setTextSize(pxTodp(10));
        mDataList.add(mLineData);
    }
}
