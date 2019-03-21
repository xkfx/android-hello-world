package com.example.myfirstapp.ex3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.myfirstapp.R;

/**
 * 参考资料：
 * https://www.cnblogs.com/smyhvae/p/4133292.html
 */
public class MenuSample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex3_3_menu_sample);
    }

    public void popupMenu(View view) {
        //创建弹出式菜单对象（最低版本11）
        PopupMenu popup = new PopupMenu(this, view);//第二个参数是绑定的那个view
        //获取菜单填充器
        MenuInflater inflater = popup.getMenuInflater();
        //填充菜单
        inflater.inflate(R.menu.ex3_3_menu, popup.getMenu());
        //绑定菜单项的点击事件
        popup.setOnMenuItemClickListener((menuItem) -> {
            int itemId = menuItem.getItemId();
            Button button = view.findViewById(R.id.ex3_3_popup_menu);
            if (itemId == R.id.small_size) {
                button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f);
            } else if (itemId == R.id.mid_size) {
                button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30f);
            } else if (itemId == R.id.big_size) {
                button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50f);
            } else if (itemId == R.id.normal_item) {
                Toast.makeText(getApplicationContext(), "You just clicked the normal item.", Toast.LENGTH_LONG).show();
            } else if (itemId == R.id.color_red) {
                button.setBackgroundColor(Color.parseColor("#FF0000"));
            } else if (itemId == R.id.color_black) {
                button.setBackgroundColor(Color.parseColor("#000000"));
            }
            return true;
        });
        popup.show(); //这一行代码不要忘记了
    }
}
