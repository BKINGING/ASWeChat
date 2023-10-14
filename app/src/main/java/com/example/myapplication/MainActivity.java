package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Fragment
    private Fragment weixinFragment =new weixinFragment();
    private Fragment Fragment_contacts =new contacts();
    private Fragment Fragment_circleoffriend =new circleoffriend();
    private Fragment Fragment_setting =new setting();

    //底端菜单栏LinearLayout
    private LinearLayout linear_chat;
    private LinearLayout linear_contacts;
    private LinearLayout linear_circleoffriend;
    private LinearLayout linear_setting;

    //底端菜单栏中的Imageview
    private ImageView imageView_chat;
    private ImageView imageView_contacts;
    private ImageView imageView_circleoffriend;
    private ImageView imageView_setting;

    //FragmentManager
    private FragmentManager fragmentManager;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this;

        initView();
        initFragment();
        initEvent();
        Fragment_select(0);
        //将第一个图标设为选中状态
        imageView_chat.setImageResource(R.drawable.chat);
        imageView_chat.setImageResource(R.drawable.chat1);
    }

    //监听函数，监听到底是哪一个图标被击中从而显示哪一个界面的内容
    @Override
    public void onClick(View view) {
        // 每次点击之后，将所有的ImageView和TextView设置为未选中
        restartButton();
        int viewId = view.getId();  // 将view的id赋值给变量viewId
        if (viewId == R.id.chat) {
            // 选择所点击的菜单对应的图层片段
            Fragment_select(0);
            // 将该菜单的点击状态置为点击态
            imageView_chat.setImageResource(R.drawable.chat);
            imageView_chat.setImageResource(R.drawable.chat1);
        } else if (viewId == R.id.contacts) {
            Fragment_select(1);
            imageView_contacts.setImageResource(R.drawable.contracts);
            imageView_contacts.setImageResource(R.drawable.contracts1);
        } else if (viewId == R.id.circle_friend) {
            Fragment_select(2);
            imageView_circleoffriend.setImageResource(R.drawable.circleoffirend);
            imageView_circleoffriend.setImageResource(R.drawable.circleoffriend1);
        } else if (viewId == R.id.settings) {
            Fragment_select(3);
            imageView_setting.setImageResource(R.drawable.setting);
            imageView_setting.setImageResource(R.drawable.setting1);
        } else {
            // 处理默认情况
        }
    }
    //重置菜单的点击状态，设为未点击
    private void restartButton() {
        //设置为未点击状态
        imageView_chat.setImageResource(R.drawable.chat);
        imageView_chat.setImageResource(R.drawable.chat2);
        imageView_contacts.setImageResource(R.drawable.contracts);
        imageView_contacts.setImageResource(R.drawable.contracts2);
        imageView_circleoffriend.setImageResource(R.drawable.circleoffirend);
        imageView_circleoffriend.setImageResource(R.drawable.circleoffriend2);
        imageView_setting.setImageResource(R.drawable.setting);
        imageView_setting.setImageResource(R.drawable.setting2);
    }

    //初始化中间的部分的图层片段
    private void initFragment(){
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.frame_content, weixinFragment);
        transaction.add(R.id.frame_content, Fragment_contacts);
        transaction.add(R.id.frame_content, Fragment_circleoffriend);
        transaction.add(R.id.frame_content, Fragment_setting);
        hideView(transaction);
        transaction.show(weixinFragment);
        //提交事务
        transaction.commit();
    }

    //初始化各底端的LinearLayout、ImageView和TextView组件
    private  void initView(){
        //改变图标颜色
        linear_chat =findViewById(R.id.chat);
        linear_contacts =findViewById(R.id.contacts);
        linear_circleoffriend =findViewById(R.id.circle_friend);
        linear_setting =findViewById(R.id.settings);
        imageView_chat =findViewById(R.id.imageView1);
        imageView_contacts =findViewById(R.id.imageView2);
        imageView_circleoffriend =findViewById(R.id.imageView3);
        imageView_setting =findViewById(R.id.imageView4);

    }

    //初始化点击监听事件
    private void initEvent(){
        linear_chat.setOnClickListener(this);
        linear_contacts.setOnClickListener(this);
        linear_circleoffriend.setOnClickListener(this);
        linear_setting.setOnClickListener(this);
    }

    //把没有使用的界面的内容隐藏
    private void hideView(FragmentTransaction transaction){
        transaction.hide(weixinFragment);
        transaction.hide(Fragment_contacts);
        transaction.hide(Fragment_circleoffriend);
        transaction.hide(Fragment_setting);
    }

    //显示选中界面的内容，选中界面图标为绿色
    private void Fragment_select(int i){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        //调用隐藏所有图层函数
        hideView(transaction);
        switch (i){
            case 0:
                transaction.show(weixinFragment);
                break;
            case 1:
                transaction.show(Fragment_contacts);
                break;
            case 2:
                transaction.show(Fragment_circleoffriend);
                break;
            case 3:
                transaction.show(Fragment_setting);
                break;
            default:
                break;
        }
        //提交转换事务
        transaction.commit();
    }

}