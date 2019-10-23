package com.example.cebrandy.uestcihms;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.avos.avoscloud.AVUser;


public class MainActivity extends AppCompatActivity implements OnClickListener,OnPageChangeListener{
    private List<ContentModel> mList = new ArrayList<ContentModel>();
    private ListView mListView;
    private DrawerLayout mDrawerLayout;
    private AVUser currentUser;

    // 底部菜单4个Linearlayout
    private LinearLayout ll_home;
    private LinearLayout ll_address;
    private LinearLayout ll_friend;
    private LinearLayout ll_setting;
    // 底部菜单4个菜单标题
    private TextView tv_home;
    private TextView tv_address;
    private TextView tv_friend;
    private TextView tv_setting;
    // 中间内容区域
    private ViewPager viewPager;
    // ViewPager适配器ContentAdapter
    private ContentAdapter adapter;
    private List<View> views;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentUser = AVUser.getCurrentUser();
        Button login= (Button) findViewById(R.id.login);
        Button exit= (Button) findViewById(R.id.exit);
        if(currentUser==null)
        {
            exit.setVisibility(View.INVISIBLE);
            login.setVisibility(View.VISIBLE);
        }
        else
        {
            login.setVisibility(View.INVISIBLE);
            exit.setVisibility(View.VISIBLE);
        }

        initData();
        mListView = (ListView) findViewById(R.id.left_listview);
        ContentAdapter2 adapter = new ContentAdapter2(this,mList);
        mListView.setAdapter(adapter);


        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBar actionBar =getSupportActionBar();
        if (actionBar !=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menuwhite);
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    //模拟两条数据
                    case 0:
                        if(currentUser==null)
                        {
                            startActivity(new Intent(MainActivity.this,denglu.class));
                        }
                        else{
                        startActivity(new Intent(MainActivity.this,gerenziliao.class));
                        }
                        break;
                    case 1:
                        if(currentUser==null)
                        {
                            startActivity(new Intent(MainActivity.this,denglu.class));
                        }
                        else {
                            startActivity(new Intent(MainActivity.this, xiugaimima.class));
                        }
                        break;
                    default:
                        break;
                }
                //点击任一项item项，都关闭左侧菜单
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }

            });

       // 初始化控件
           initView();
       // 初始化底部按钮事件
           initEvent();


    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fenxiang:
                Intent intent1 = new Intent(MainActivity.this,fenxiang1.class);
                startActivity(intent1);
                break;
            case R.id.guanyuwomen:
                Intent intent2 = new Intent(MainActivity.this, guanyuwomen2.class);
                startActivity(intent2);
                break;
            case R.id.mianzeshengming:
                Intent intent3 = new Intent(MainActivity.this, mianzeshengming3.class);
                startActivity(intent3);
                break;
            case R.id.yijianfankui:
                Intent intent4 = new Intent(MainActivity.this, yijianfankui4.class);
                startActivity(intent4);
                break;
            case R.id.lianxikefu:
                Intent intent5 = new Intent(MainActivity.this, lianxikefuActivity.class);
                startActivity(intent5);
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
                default:
        }
        return true;
    }




    private void initData() {
        mList.add(new ContentModel(R.drawable.account, "个人资料", 1));
        mList.add(new ContentModel(R.drawable.password, "修改密码", 2));
    }

    private void initEvent() {
    // 设置按钮监听
      ll_home.setOnClickListener(this);
      ll_address.setOnClickListener(this);
      ll_friend.setOnClickListener(this);
      ll_setting.setOnClickListener(this);

      //设置ViewPager滑动监听
       viewPager.setOnPageChangeListener(this);
  }

   private void initView() {

       // 底部菜单4个Linearlayout
       this.ll_home = (LinearLayout) findViewById(R.id.ll_home);
       this.ll_address = (LinearLayout) findViewById(R.id.ll_address);
       this.ll_friend = (LinearLayout) findViewById(R.id.ll_friend);
       this.ll_setting = (LinearLayout) findViewById(R.id.ll_setting);

   // 底部菜单4个菜单标题
          this.tv_home = (TextView) findViewById(R.id.tv_home);
          this.tv_address = (TextView) findViewById(R.id.tv_address);
          this.tv_friend = (TextView) findViewById(R.id.tv_friend);
          this.tv_setting = (TextView) findViewById(R.id.tv_setting);

          // 中间内容区域ViewPager
       this.viewPager = (ViewPager) findViewById(R.id.vp_content);

       // 适配器
                View page_01 = View.inflate(MainActivity.this, R.layout.activity_zhu, null);
                 View page_02 = View.inflate(MainActivity.this, R.layout.activity_reserve, null);
                 View page_03 = View.inflate(MainActivity.this, R.layout.activity_baogao, null);
                 View page_04 = View.inflate(MainActivity.this, R.layout.activity_message, null);

               views = new ArrayList<View>();
               views.add(page_01);
               views.add(page_02);
              views.add(page_03);
                views.add(page_04);

              this.adapter = new ContentAdapter(views);
             viewPager.setAdapter(adapter);

           }

    @Override
    public void onClick(View v) {
            // 在每次点击后将所有的底部按钮(ImageView,TextView)颜色改为灰色，然后根据点击着色
              restartBotton();
             // ImageView和TetxView置为绿色，页面随之跳转
              switch (v.getId()) {
                   case R.id.ll_home:
                          tv_home.setTextColor(0xff1B940A);
                          viewPager.setCurrentItem(0);
                          break;

                 case R.id.ll_address:
                             tv_address.setTextColor(0xff1B940A);
                             viewPager.setCurrentItem(1);
                             break;

                  case R.id.ll_friend:
                             tv_friend.setTextColor(0xff1B940A);
                             viewPager.setCurrentItem(2);
                             break;

                  case R.id.ll_setting:
                             tv_setting.setTextColor(0xff1B940A);
                             viewPager.setCurrentItem(3);
                      break;

                     default:
                         break;
                     }

             }

             private void restartBotton() {

                 // TextView置为白色
                 tv_home.setTextColor(0xfffffffB);
                 tv_address.setTextColor(0xfffffffB);
                 tv_friend.setTextColor(0xfffffffB);
                 tv_setting.setTextColor(0xfffffffB);
             }

             @Override
   public void onPageScrollStateChanged(int arg0) {

             }

    @Override
     public void onPageScrolled(int arg0, float arg1, int arg2) {

             }

    @Override
     public void onPageSelected(int arg0) {
                 restartBotton();
                 //当前view被选择的时候,改变底部菜单图片，文字颜色
                 switch (arg0) {
                     case 0:

                            tv_home.setTextColor(0xff1B940A);
                             break;
                    case 1:

                            tv_address.setTextColor(0xff1B940A);
                             break;
                     case 2:

                            tv_friend.setTextColor(0xff1B940A);
                          break;
                   case 3:

                          tv_setting.setTextColor(0xff1B940A);
                            break;

                  default:
                             break;
                   }

           }


    public void login(View v) {
        startActivity(new Intent(MainActivity.this, denglu.class));
    }

    public void exit(View v) {
        AVUser.logOut();// 清除缓存用户对象
        AVUser currentUser = AVUser.getCurrentUser();// 现在的 currentUser 是 null 了
        if (currentUser == null) {
            Toast.makeText(this, "注销成功", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,MainActivity.class));
        }
    }

    public void chaxunyisheng(View v) {
        startActivity(new Intent(MainActivity.this,depart.class));
    }
    public  void yiyuanjianjie(View v){ startActivity(new Intent(MainActivity.this,yiyuanjianjie.class));}
    public  void yiyuandaohang(View v){ startActivity(new Intent(MainActivity.this,yiyuandaohang.class));}
    public  void jiagegongshi(View v){ startActivity(new Intent(MainActivity.this,jiagegongshi.class));}
    public  void zhinengdaozhen(View v){ startActivity(new Intent(MainActivity.this,zhinengdaozhen.class));}
    public  void jingquechaxun(View v){ startActivity(new Intent(MainActivity.this,jingquechaxun.class));}

    public  void wodeyuyue(View v){
        if(currentUser==null)
        {
            startActivity(new Intent(MainActivity.this, denglu.class));
        }
        else{
        startActivity(new Intent(MainActivity.this,wodeyuyue.class));}
    }

    public  void wodexiaoxi(View v){
        if(currentUser==null)
        {
            startActivity(new Intent(MainActivity.this, denglu.class));
        }
        else{
        startActivity(new Intent(MainActivity.this,wodexiaoxi.class));}
        }

    public  void jianchabaogao(View v) {
        if (currentUser == null) {
            startActivity(new Intent(MainActivity.this, denglu.class));
        } else {
            startActivity(new Intent(MainActivity.this, jianchabaogao.class));
        }
    }
}
