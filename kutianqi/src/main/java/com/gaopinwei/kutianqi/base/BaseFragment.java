package com.gaopinwei.kutianqi.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.gaopinwei.kutianqi.activity.MainActivity;


/**
 * Fragment 基类
 *
 */
public class BaseFragment extends Fragment {

    protected MainActivity activity;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        if (activity instanceof MainActivity) {
            this.activity = (MainActivity) activity;
        }
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InputMethodManager manager=(InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if(motionEvent.getAction()== MotionEvent.ACTION_DOWN){
                    if(getActivity().getCurrentFocus()!=null &&getActivity().getCurrentFocus().getWindowToken()!=null){
                        manager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }
                return true;
            }
        });
        super.onViewCreated(view, savedInstanceState);

    }
}