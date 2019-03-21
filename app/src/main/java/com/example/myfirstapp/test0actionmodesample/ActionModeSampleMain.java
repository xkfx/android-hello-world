package com.example.myfirstapp.test0actionmodesample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.myfirstapp.R;
import com.example.myfirstapp.test0actionmodesample.fragment.ListViewFragment;
import com.example.myfirstapp.test0actionmodesample.fragment.RecyclerViewFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考资料：
 * http://www.androhub.com/android-contextual-action-mode-over-toolbar/
 */
public class ActionModeSampleMain extends AppCompatActivity {
    /**
     * 作者这么写是为了在其它地方通过
     * new ActionModeSampleMain().getFragment
     * 共享这些数据。。。
     */
    private static List<String> mTitles = new ArrayList<>();
    private static List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex3_4_main);

        // toolbar部件定义在ex3_4_main中
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // 默认的app bar在style里面取消掉了

        // TabLayout和ViewPager关联，这种使用方法比较灵活，
        // 在实际开发中一般都是这样配合使用
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);
        // 1. 设置TabLayout标题
        mTitles.add("ListView");
        mTitles.add("RecyclerView");
        // 2. 设置TabLayout内容
        mFragments.add(new ListViewFragment());
        mFragments.add(new RecyclerViewFragment());
        // 3. 配置适配器
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }
        };
        // 4. 设置适配器
        viewPager.setAdapter(adapter);
        // 5. 将ViewPager和TabLayout关联起来
        tabLayout.setupWithViewPager(viewPager);
    }

    // Return current fragment on basis of Position
    public Fragment getFragment(int pos) {
        return mFragments.get(pos);
    }
}
