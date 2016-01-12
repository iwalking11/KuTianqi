package com.gaopinwei.kutianqi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.request.entitys.History;

import java.util.List;

/**
 * Created by Administrator on 2015/11/12.
 */
public class HistoryAdapter extends BaseAdapter {
    private List<History> histories ;
    private Context context;



    public HistoryAdapter(Context context,List<History> histories) {
        this.histories = histories;
        this.context = context;
    }

    @Override
    public int getCount() {
        if(histories!=null)
        {
            return histories.size() ;
        }
        return  0;
    }

    @Override
    public Object getItem(int position) {
        return histories.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_history_item, null);
           }
        TextView txt_date_time =((TextView) convertView.findViewById(R.id.txt_date_time));
        TextView txt_date_content =((TextView) convertView.findViewById(R.id.txt_date_content));
        txt_date_time.setText(histories.get(position).getTime());
        txt_date_content.setText(histories.get(position).getStory());
        return convertView;
    }
}
