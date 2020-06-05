package q.rorbin.verticaltablayoutdemo;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.DisplayUtil;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewpager;
    private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        myPagerAdapter = new MyPagerAdapter();

        viewpager.setAdapter(myPagerAdapter);
        initTab0();


    }

    private void initTab0() {
        final VerticalTabLayout tablayout = (VerticalTabLayout) findViewById(R.id.tablayout0);
        tablayout.setupWithViewPager(viewpager);
//        tablayout.setTabBadge(7, 32);
//        tablayout.setTabBadge(2, -1);
//        tablayout.setTabBadge(3, -1);
//        tablayout.setTabBadge(4, -1);
    }


    private class MyPagerAdapter extends PagerAdapter implements TabAdapter {
        List<String> titles;

        public MyPagerAdapter() {
            titles = new ArrayList<>();
            Collections.addAll(titles, "Android", "IOS", "Web", "JAVA", "C++",
                    ".NET", "JavaScript", "Swift", "PHP", "Python", "C#", "Groovy", "SQL", "Ruby",
                    ".NET", "JavaScript", "Swift", "PHP", "Python", "C#", "Groovy", "SQL", "Ruby",
                    ".NET", "JavaScript", "Swift", "PHP", "Python", "C#", "Groovy", "SQL", "Ruby",
                    ".NET", "JavaScript", "Swift", "PHP", "Python", "C#", "Groovy", "SQL", "Ruby");
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public TabView.TabBadge getBadge(int position) {
            return null;
        }

        @Override
        public TabView.TabIcon getIcon(int position) {
            return null;
        }

        @Override
        public TabView.TabTitle getTitle(int position) {

            return new TabView.TabTitle.Builder()
                    .setContent(titles.get(position))
                    .setTextSize(12)
                    .setTextColor(Color.BLACK, R.color.gray)
                    .build();
        }

        @Override
        public int getBackground(int position) {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return null;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    protected int dp2px(float dp) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
