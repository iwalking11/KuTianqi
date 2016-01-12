package com.gaopinwei.kutianqi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gaopinwei.kutianqi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDetailfragment extends Fragment {


    private WebView wv_news_item_details;

    public NewsDetailfragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view =  inflater.inflate(R.layout.fragment_news_detailfragment, container, false);

            wv_news_item_details = ((WebView) view.findViewById(R.id.wv_news_item_details));
             String string = getArguments().getString("link");
             //Log.e("link",string);
             wv_news_item_details.getSettings().setSupportZoom(true);
             wv_news_item_details.getSettings().setBuiltInZoomControls(true);
             wv_news_item_details.getSettings().setJavaScriptEnabled(true);
             wv_news_item_details.setBackgroundColor(0);
             wv_news_item_details.loadUrl(string);
             wv_news_item_details.setWebViewClient(new WebViewClient());
//             wv_news_item_details.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
        return view;
    }


}
