package com.gaopinwei.kutianqi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaopinwei.kutianqi.R;

import java.util.List;


public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.MyViewHolder> {

    private List<String> cityList;

    private Context context;
    private MyOnItemClickListener myOnItemClickListener;
    public CityListAdapter(Context context,List<String> cityList) {
        this.context = context;
        this.cityList = cityList;
    }

    public void setMyOnItemClickListener(MyOnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
    }


    /**
     * 当 view 被复用的时候调用,将传回来的 holder 传递给了 onbindview, 做到了复用的功能,这个时候 onCreateViewHolder不会再执行
     * @param holder
     */
    @Override
    public void onViewRecycled(MyViewHolder holder) {
//        Log.e("recycler", "onViewRecycled");
        super.onViewRecycled(holder);
    }

    /**
     * 创建 viewhoder, 返回值是我们自己的内部类MyViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.search_item, null);
//        itemView.setOnClickListener(this);
        return new MyViewHolder(itemView);
    }

    /**
     * 绑定视图,将内容显示出来的方法
     *
     * @param holder   onCreateViewHolder 返回的对象,传递到这里来 显示内容
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView = (TextView) holder.itemView.findViewById(R.id.tv_city);//查找控件
        holder.textView.setText(cityList.get(position));
    }

    /**
     * 返回数据源的长度
     * @return
     */
    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        /**
         *
         * @param itemView 每一条 item 的 view
         */
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);//给 每一条 item设置点击事件
        }
        TextView textView;//控件上面的 textview

        @Override
        public void onClick(View v) {//每一条 item 点击事件的具体执行内容
            if (myOnItemClickListener != null) {
                myOnItemClickListener.myOnItemClick(v,getLayoutPosition());
            }
        }
    }

    public interface  MyOnItemClickListener{//自己声明的点击事件对象
        void myOnItemClick(View view,int postion);//点击事件具体执行的方法
    }
}
