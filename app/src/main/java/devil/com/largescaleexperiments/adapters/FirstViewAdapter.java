package devil.com.largescaleexperiments.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import devil.com.largescaleexperiments.R;
import devil.com.largescaleexperiments.activitys.ShowMassageActivity;
import devil.com.largescaleexperiments.entityclass.FirstViewEntityClass;


public class FirstViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<FirstViewEntityClass> mFirstViewEntityList;
    FirstViewEntityClass mFirstViewEntity;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public FirstViewAdapter(Context context, ArrayList<FirstViewEntityClass> newslist){
        this.mFirstViewEntityList = newslist;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        Log.d("firstadapter", "First_RecyclerViewAdapter: ");
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView state;
        TextView id;
        TextView temperature;
        TextView Illumination;
        View myitemView ;
        public ItemViewHolder(View itemView) {
            super(itemView);
            myitemView=itemView;
            state=(ImageView) itemView.findViewById(R.id.first_page_item_state);
            id =(TextView)itemView.findViewById(R.id.first_page_item_id);
            temperature=(TextView)itemView.findViewById(R.id.first_page_item_temperature);
            Illumination=(TextView)itemView.findViewById(R.id.first_page_item_Illumination);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = mLayoutInflater.inflate(R.layout.first_view_item, viewGroup, false);
        FirstViewAdapter.ItemViewHolder holder = new FirstViewAdapter.ItemViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        mFirstViewEntity = mFirstViewEntityList.get(position);
         ItemViewHolder myViewHolder = (FirstViewAdapter.ItemViewHolder)viewHolder;
        myViewHolder.id.setText(mFirstViewEntity.getId());
        myViewHolder.Illumination.setText(mFirstViewEntity.getIllumination());
        myViewHolder.temperature.setText(mFirstViewEntity.getTemperature());
        myViewHolder.state.setImageResource(R.mipmap.icon_normal);
//        ((FirstViewAdapter.ItemViewHolder)viewHolder).id.setText(mFirstViewEntity.getId());
//        ((FirstViewAdapter.ItemViewHolder)viewHolder).Illumination.setText(mFirstViewEntity.getIllumination());
//        ((FirstViewAdapter.ItemViewHolder)viewHolder).temperature.setText(mFirstViewEntity.getTemperature());
//        ((FirstViewAdapter.ItemViewHolder)viewHolder).state.setImageResource(R.mipmap.icon_normal);
        ((FirstViewAdapter.ItemViewHolder)viewHolder).myitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*myViewHolder.state.setImageResource(R.mipmap.icon_alarm);*/
                Intent intent = new Intent(mContext, ShowMassageActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
         return mFirstViewEntityList.size();
    }
}
