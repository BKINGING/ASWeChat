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
        String[] imgSrc = {"https://uploadfile.huiyi8.com/2015/0610/20150610023414897.jpg",
                "https://tupian.qqw21.com/article/UploadPic/2020-10/2020102118172486410.jpg",
                "https://tse1-mm.cn.bing.net/th/id/R-C.f06917566447b07f1fd02df8d2b90afe?rik=gcK32hcXo%2fECSQ&riu=http%3a%2f%2fwww.fzlol.com%2fupimg%2fallimg%2f140321%2f1_19401130B.jpg&ehk=4tikPQlp0d5wKQ1m1Y%2fuK0giIpiRn6Cp1pb6lfJwl8I%3d&risl=&pid=ImgRaw&r=0",
                "https://tupian.qqw21.com/article/UploadPic/2012-9/2012928918625.jpg",
                "https://tse1-mm.cn.bing.net/th/id/R-C.b9c66bc2c06e04ea70aa694cd270661e?rik=8cfGRPR073C6AQ&riu=http%3a%2f%2ftouxiang.vipyl.com%2fattached%2fimage%2f20130222%2f20130222152219531953.jpg&ehk=rECfEJntkfPQN2acCWpC6PqeI8xP1%2bGs59IOEKCd2tQ%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1",
                "https://tse1-mm.cn.bing.net/th/id/R-C.60c49ed1f68019e00572dd33dff274f4?rik=eOWqUDbxEyvn%2fQ&riu=http%3a%2f%2fscimg.jianbihuadq.com%2f202008%2f202008282115115.jpg&ehk=upxZxNKo1zee4RtaKIAgzk%2b7rdB0t084DdNXO6o8V%2fE%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1",
                "https://tse1-mm.cn.bing.net/th/id/R-C.a13d84b340cd08244268db8f8f8b1922?rik=Z0t8GBFlkY4Mhg&riu=http%3a%2f%2fscimg.jianbihuadq.com%2f202010%2f2020101711593861.jpg&ehk=yfqLWJ5S5%2fBHEzqv0YaZcSXYqFDpw6I8kKaRBoh%2fxcI%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1",
                "https://tse2-mm.cn.bing.net/th/id/OIP-C.eQ-HYGnNOjgSAvllNDVS4AAAAA?w=150&h=150&c=7&r=0&o=5&pid=1.7"

        };
        String[] cttName = {"张三", "李四", "王五","赵六","杨七","李八","刘XX","周十"};
        String[] cttTime = {"下午4：32","下午3：10","上午11：20","上午8：21","昨天","昨天","3月21日","2021年12月10日"};
        String[] cttMsg = {"愉悦~","呵呵","怎么回事？","从未如此美妙的开局","哈哈","也许不过如此","在哪里碰头？","万丈高楼平地起"};
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