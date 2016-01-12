package com.gaopinwei.kutianqi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.gaopinwei.kutianqi.R;
import com.gaopinwei.kutianqi.activity.AddNotebookActivity;
import com.gaopinwei.kutianqi.adapters.ShowNoteBookAdapter;
import com.gaopinwei.kutianqi.base.BaseFragment;
import com.gaopinwei.kutianqi.request.db.NoteBookDB;
import com.gaopinwei.kutianqi.request.entitys.NoteBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;


/**
 * 心情日记
 */
public class Fragment04 extends BaseFragment {

    private ImageView imageView_addNoteBook;
    private ListView list_view_notebook;
    private NoteBookDB db;  //日记数据库操作类
    private ShowNoteBookAdapter adapter;  //日记列表适配器
    private int currentPos; //用来记录当前点击的条目下标
    private List<String> titles;

    private String cityName;  //从主界面获得当前城市名
    private ImageView imageview_cehua;

    public Fragment04(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public void onResume() {
        super.onResume();
        flashView(); //刷洗界面
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment004, container, false);
        db = NoteBookDB.getInstance(getContext()); //实例化日记数据库操作类
        imageView_addNoteBook = (ImageView) view.findViewById(R.id.imageView_addNoteBook);
        imageview_cehua = ((ImageView) view.findViewById(R.id.imageView_cehua));
        imageview_cehua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出侧滑菜单
                activity.mDrawerLayout.openDrawer(activity.navigationView);
            }
        });

//        //构建EventBus实例
//         EventBus.getDefault().register(this);

        //点击添加日记
        imageView_addNoteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), AddNotebookActivity.class);
                intent2.putExtra("title", "kong");
                intent2.putExtra("content", "kong");
                intent2.putExtra("cityName", cityName);
                startActivity(intent2);

            }
        });
        //日记列表
        list_view_notebook = (ListView) view.findViewById(R.id.list_view_notebook);

        registerForContextMenu(list_view_notebook);//注册上下文
        flashView(); //刷新界面

        return view;
    }

    /**
     * 刷新界面
     */
    public void flashView() {
        //获取数据源
        List<NoteBook> datas = db.queryAll();
        if (datas != null) {
            //获取标题的集合
            titles = new ArrayList<>();
            for (NoteBook title : datas) {
                titles.add(title.getTitle());
            }

            Collections.reverse(titles); //反转集合

            //设置适配器
            adapter = new ShowNoteBookAdapter(getContext(), titles);
            list_view_notebook.setAdapter(adapter);
            adapter.notifyDataSetChanged();  //刷新

            //设置监听事件
            MyOnItemLongClickListener longListener = new MyOnItemLongClickListener();
            MyOnItemClickListener Listener = new MyOnItemClickListener();
            list_view_notebook.setOnItemLongClickListener(longListener);
            list_view_notebook.setOnItemClickListener(Listener);
        }

    }

    /**
     * listview 长按监听器
     */
    public class MyOnItemLongClickListener implements AdapterView.OnItemLongClickListener {

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            //长按某一条目时,获得此条目的编号
            currentPos = position;

            return false;
        }
    }

    /**
     * 长按列表条目,触发的方法(删除条目)
     */
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(Menu.NONE, 100, 1, "删除");
        menu.add(Menu.NONE, 200, 2, "取消");
    }

    /**
     * 点击上述方法中的"删除"按钮,触发的方法
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 100:
                //从数据库删除
                db.deleteByTitle(titles.get(currentPos));

                //刷新界面
                flashView();
                break;

            case 200:
                break;
        }
        return super.onContextItemSelected(item);
    }

    /**
     * listview 短按监听器
     */
    public class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //获取本条的标题
            String currentTitle = parent.getItemAtPosition(position).toString();

            //根据标题从数据库查询出内容
            String currentContent = db.queryByTitle(currentTitle);

            //根据标题从数据库查询出图片路径
            String currentPathName = db.queryPathByTitle(currentTitle);

            //跳到编辑界面（可以编辑和展示）
            Intent intent = new Intent(getActivity(), AddNotebookActivity.class);
            intent.putExtra("title", currentTitle);
            intent.putExtra("content", currentContent);
            intent.putExtra("cityName", cityName);
            intent.putExtra("pathName", currentPathName);
            startActivity(intent);
        }
    }

}
