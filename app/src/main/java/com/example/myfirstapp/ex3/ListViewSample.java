package com.example.myfirstapp.ex3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.myfirstapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 参考教程：
 * https://abhiandroid.com/ui/simpleadapter.html
 */
public class ListViewSample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex3_1_my_list_view);
        ListView myListView = findViewById(R.id.ex3_1_myListView);

        // 1. 定义打算呈现到ListView中的原始数据
        final String[] animalNames = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
        int[] animalImages = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};

        // 2. 将每行数据都包装成一个HashMap
        ArrayList<HashMap<String, Object>> hashMaps = new ArrayList<>();
        for (int i = 0; i < animalNames.length; i++) {
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("name", animalNames[i]);
            hashMap.put("image", animalImages[i]);
            hashMaps.add(hashMap);
        }
        // 3. from和to数组定义每条HashMap到实际UI部件的映射规则。
        // 例如有一个HashMap为：{"name": "lion", "image": R.drawable.lion}
        // => "lion"将被映射为ex3_1_textView_of_aListItem（"name"字段所对应的内容被映射为textView），
        // R.drawable.lion将被映射为R.id.ex3_1_imageView_of_aListItem（"image"字段所对应的内容被映射为imageView）
        String[] from = {"name", "image"};
        int[] to = {R.id.ex3_1_textView_of_aListItem, R.id.ex3_1_imageView_of_aListItem};

        // 4. 创建SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                hashMaps, R.layout.ex3_1_custom_list_item, from,to);

        // 5. 将SimpleAdapter设置到对应ListView容器中
        myListView.setAdapter(simpleAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), animalNames[i], Toast.LENGTH_LONG).show();
                // Toast是Android中的一种简易消息提示框。
            }
        });
    }
}
