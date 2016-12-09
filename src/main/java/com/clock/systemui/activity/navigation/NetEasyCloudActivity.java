package com.clock.systemui.activity.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.clock.systemui.R;
import com.clock.systemui.activity.base.BaseActivity;

/**
 * 仿网易云音乐
 *
 * @author daniel
 * @since 2016-12-7
 */
public class NetEasyCloudActivity extends BaseActivity {

    private NavigationView navigation_view;
    private DrawerLayout drawer;
    private boolean isOpen;
    private Button btn_set,btn_exit;
    private ImageView drawer_icon;
    //控制返回键
    long time = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_net_easy_cloud);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                isOpen = true;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                isOpen = false;
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        navigation_view = (NavigationView) findViewById(R.id.navigation_view_);
        navigation_view.setItemIconTintList(null);
        removeNavigationViewScrollbar(navigation_view);
        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //切换相应 Fragment 等操作
                switch (menuItem.getItemId()){
                    case R.id.item_msg:
                        Toast.makeText(NetEasyCloudActivity.this,menuItem.getItemId()+"",0).show();
                        break;
                    case R.id.item_store:
                        Toast.makeText(NetEasyCloudActivity.this,menuItem.getItemId()+"",0).show();
                        break;
                    case R.id.item_member:
                        Toast.makeText(NetEasyCloudActivity.this,menuItem.getItemId()+"",0).show();
                        break;
                    case R.id.item_free:
                        Toast.makeText(NetEasyCloudActivity.this,menuItem.getItemId()+"",0).show();
                        break;
                }
                drawer.closeDrawers();
                menuItem.setChecked(true);
                return true;
            }
        });
        btn_set = (Button) findViewById(R.id.btn_set);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        drawer_icon =  (ImageView) findViewById(R.id.drawer_icon);
        drawer_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isOpen){
                   // drawer.openDrawer(navigation_view);//.openDrawer(GravityCompat.START);
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NetEasyCloudActivity.this,"你点击了设置按钮",0).show();
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NetEasyCloudActivity.this,"你点击了退出按钮",0).show();
            }
        });
    }


    private void removeNavigationViewScrollbar(NavigationView navigationView){
        if (navigationView != null){
            NavigationMenuView navigationMenuView =  (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null){
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawer.isDrawerOpen(Gravity.LEFT)) {
                drawer.closeDrawer(navigation_view);
                isOpen = false;
                return true;
            } /*else {
                if ((System.currentTimeMillis() - time > 1000)) {
                    Toast.makeText(this, "再按一次返回桌面", Toast.LENGTH_SHORT).show();
                    time = System.currentTimeMillis();
                } else {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    startActivity(intent);
                }
                return true;
            }*/
        }
        return super.onKeyDown(keyCode, event);
    }

}
