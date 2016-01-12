package com.gaopinwei.kutianqi.adapters;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.fragment.NewsDetailfragment;
import com.gaopinwei.kutianqi.request.entitys.News;

import java.util.List;

/**
 * Created by Administrator on 2015/11/10.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context context;
    private List<News.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> newslist;
    private FragmentManager manager;

    public NewsAdapter(Context context, List<News.ShowapiResBodyEntity.PagebeanEntity.ContentlistEntity> newslist,
                       FragmentManager manager){
        this.context = context;
        this.newslist = newslist;
        this.manager = manager;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.fragment_news_item,null);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tv_item_news_title = ((TextView) holder.itemView.findViewById(R.id.tv_item_news_title));
        holder.tv_item_news_desc = ((TextView) holder.itemView.findViewById(R.id.tv_item_news_desc));
        holder.tv_item_news_source = ((TextView) holder.itemView.findViewById(R.id.tv_item_news_source));
        holder.tv_item_news_pubDate = ((TextView) holder.itemView.findViewById(R.id.tv_item_news_pubDate));

        holder.tv_item_news_title.setText(newslist.get(position).getTitle());
        Spanned desc= Html.fromHtml(newslist.get(position).getDesc());

        holder.tv_item_news_desc.setText("       "+ desc+"......");
        holder.tv_item_news_source.setText(newslist.get(position).getSource());
        holder.tv_item_news_pubDate.setText(newslist.get(position).getPubDate());

    }

    @Override
    public int getItemCount() {

        if(newslist!=null) {
            return newslist.size();
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_item_news_title;
        TextView tv_item_news_desc;
        TextView tv_item_news_source;
        TextView tv_item_news_pubDate;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            //当item被点击时执行
            NewsDetailfragment newsDetailfragment = new NewsDetailfragment();
            int position = getAdapterPosition();
            Bundle bundle = new Bundle();
            bundle.putString("link", newslist.get(position).getLink());
            newsDetailfragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction =  manager.beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.replace(R.id.news_container, newsDetailfragment) .commit();

        }
    }

}
