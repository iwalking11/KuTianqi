package com.gaopinwei.kutianqi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gaopinwei.kutianqi.R;

import java.util.List;

/**
 * Created by xiazhenjie on 2015/11/12.
 *
 *  日记列表适配器
 */
public class ShowNoteBookAdapter extends BaseAdapter {

    private Context context; //上下文
    private List<String> lists; //数据源

    public ShowNoteBookAdapter(Context context, List<String> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        if(lists!=null){
          return lists.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
           convertView = LayoutInflater.from(context).inflate(R.layout.notebook_item,null);
           holder = new ViewHolder();

           holder.textView_notebook_item = (TextView) convertView.findViewById(R.id.textView_notebook_item);
           convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView_notebook_item.setText(lists.get(position));
        return convertView;
    }

    static class ViewHolder{
        private TextView textView_notebook_item;
    }
}
