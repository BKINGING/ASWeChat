package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class weixinFragment extends Fragment {
    private List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
    private View view;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_weixin, container, false);
        initRecyclerView();
        initData();
        // Inflate the layout for this fragment
        return view;
    }

    private void initData() {
        String[] imgSrc = {"https://img.touxiangwu.com/zb_users/upload/2022/12/202212051670208807419337.jpg",
                "https://www.beihaiting.com/uploads/allimg/160212/10723-1602120951452J.jpg",
                "https://upload-images.jianshu.io/upload_images/18279216-625cefbb47c316a1?imageMogr2/auto-orient/strip|imageView2/2/format/webp",
                "https://tse4-mm.cn.bing.net/th/id/OIP-C.5edzIeOn6loCRwkYK1LnjgHaED?pid=ImgDet&rs=1",
                "https://ts1.cn.mm.bing.net/th/id/R-C.e3ee06dd3fd26471fc34656a7c45df79?rik=X%2bxecOO1lLXcLw&riu=http%3a%2f%2fqimg.hxnews.com%2f2017%2f0820%2f1503191526949.jpeg&ehk=4V4cqIgdhI2z8WAfrhCRw2zQlaiDUQycu0OG4xNuEy0%3d&risl=&pid=ImgRaw&r=0",
                "https://ts1.cn.mm.bing.net/th/id/R-C.d63793ae33409c0c1d34d9d0a018b070?rik=bSj2dvd%2fJzQzFQ&riu=http%3a%2f%2fimg1.gtimg.com%2fent%2fpics%2fhv1%2f86%2f39%2f1704%2f110812631.jpg&ehk=IMqiuo4zmlFwCz6GcDc1ksbEDLaAxJRsCnfOx8pFaSg%3d&risl=&pid=ImgRaw&r=0",
                "https://c-ssl.duitang.com/uploads/item/202004/24/20200424193152_cdpzf.jpeg",
                "https://gss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=8ae53caa70899e5178db32127297f50b/0823dd54564e92586e1669b99782d158ccbf4e43.jpg"

        };
        String[] cttName = {"蓦山溪", "离亭燕", "山亭柳","两同心","泠青沼","山月","秋日薄暮","摘星"};
        String[] cttTime = {"下午4：32","下午3：10","上午11：20","上午8：21","昨天","昨天","3月21日","2021年12月10日"};
        String[] cttMsg = {"须知少时凌云志","加油","怎么回事？","可以可以","哈哈","也许不过如此","牛的","万丈高楼平地起"};
        for (int i = 0; i < imgSrc.length; i++) {
            Map<String, Object> itemData = new HashMap<String, Object>();
            itemData.put("key1", imgSrc[i]);
            itemData.put("key2", cttName[i]);
            itemData.put("key3",cttTime[i]);
            itemData.put("key4",cttMsg[i]);
            data.add(itemData);
        }
    }
    private void initRecyclerView () {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.getItemAnimator().setChangeDuration(500);
        recyclerView.getItemAnimator().setMoveDuration(500);
        myAdapter = new MyAdapter(getActivity(), data);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(manager);
    }

}
