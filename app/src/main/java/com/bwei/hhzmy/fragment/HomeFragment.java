package com.bwei.hhzmy.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.bwei.hhzmy.OkHttpUtil.OkHttp;
import com.bwei.hhzmy.R;
import com.bwei.hhzmy.activity.ErweimaActivity;
import com.bwei.hhzmy.activity.LoginActivity;
import com.bwei.hhzmy.activity.SousuoActivity;
import com.bwei.hhzmy.adapter.MyShouYeGridAdapter;
import com.bwei.hhzmy.adapter.MyShouYePagerAdapter;
import com.bwei.hhzmy.bean.Bean;
import com.bwei.hhzmy.view.MyGridView;
import com.bwei.hhzmy.view.MyListView;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by zhangjie on 2016/11/7.
 */
public class HomeFragment extends Fragment implements View.OnClickListener ,EasyPermissions.PermissionCallbacks{
    private static final int REQUEST_CODE_QRCODE_PERMISSIONS = 1;
    private ImageView ivScanTop;
    private ImageView ivMesTop;
    private ViewPager vpShouye;
    private MyGridView gvShouye;
    private MyListView lvShouye;
    private ScrollView svShouye;
    private LinearLayout ll;
    private LinearLayout layout;
    private List<Bean.DataBean.TagBean> list = new ArrayList<>();
    private List<Bean.DataBean.TagBean> list1 = new ArrayList<>();
    private List<Bean.DataBean.TagBean> mlist = new ArrayList<>();
    private List<Bean.DataBean.TagBean> mvlist = new ArrayList<>();
    private List<Bean.DataBean.TagBean> mv1list = new ArrayList<>();
    private List<Bean.DataBean.TagBean> mv2list = new ArrayList<>();
    private List<Bean.DataBean.TagBean> mv3list = new ArrayList<>();
    private List<Bean.DataBean.TagBean> muyinlist = new ArrayList<>();
    private List<Bean.DataBean.TagBean> muyin1list = new ArrayList<>();
    private List<Bean.DataBean.TagBean> babylist = new ArrayList<>();
    private List<Bean.DataBean.TagBean> themelist = new ArrayList<>();
    private List<Bean.DataBean.TagBean> theme1list;
    private List<Bean.DataBean.TagBean> theme2list;
    private List<Bean.DataBean.TagBean> bigjuhuilist;
    private List<Bean.DataBean.TagBean> bigjuhui1list;
    private List<Bean.DataBean.TagBean> tag18;
    private List<Bean.DataBean.TagBean> tag19;
    private List<Bean.DataBean.TagBean> tag20;
    private List<Bean.DataBean.TagBean> tag21;
    private List<Bean.DataBean.TagBean> tag23;
    private List<Bean.DataBean.TagBean> tag24;
    private List<Bean.DataBean.TagBean> tag26;
    private List<Bean.DataBean.TagBean> tag28;
    private List<Bean.DataBean.TagBean> tag30;
    private List<Bean.DataBean.TagBean> tag32;
    private List<Bean.DataBean.TagBean> tag33;
    private MyShouYePagerAdapter adapter;
    private MyShouYeGridAdapter adapter1;
    private String path = "http://mock.eoapi.cn/success/jSWAxchCQfuhI6SDlIgBKYbawjM3QIga";
    private String murl="http://image1.suning.cn/";
    private LayoutInflater mInflater;
    private LinearLayout mGallery;
    private LinearLayout mGallery1;
    private LinearLayout mGallery2;
    private LinearLayout mGallery3;
    private LinearLayout mGallery4;
    private ImageView image;
    private ImageView pinpai;
    private ImageView shipin;
    private ImageView yi;
    private ImageView yu;
    private ImageView wan;
    private ImageView yong;
    private ImageView zhuxing;
    private ImageView yun;
    private ImageView zunmm;
    private ImageView muyin;
    private ImageView newstart;
    private ImageView baby;
    private ImageView child;
    private ImageView xueqian;
    private ImageView theme;
    private ImageView accesories;
    private ImageView bigjuhui;
    private ImageView liangfh;
    private ImageView smoney;
    private ImageView spellgroup;
    private ImageView yunzb;
    private ImageView kangbei;
    private ImageView xilang;
    private ImageView queshi;
    private ImageView linyao;
    private ImageView more;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        //找到控件
        ivMesTop = (ImageView) view.findViewById(R.id.iv_mes_top);//消息图片
        ivScanTop = (ImageView) view.findViewById(R.id.iv_scan_top);//扫描图片
        ll = (LinearLayout) view.findViewById(R.id.ll);
        vpShouye = (ViewPager) view.findViewById(R.id.vp_shouye);//viewpager轮播
        gvShouye = (MyGridView) view.findViewById(R.id.gv_shouye);//GridView

        layout = (LinearLayout) view.findViewById(R.id.linearlayout);
        mGallery = (LinearLayout) view.findViewById(R.id.id_gallery);//横向布局
        mGallery1 = (LinearLayout) view.findViewById(R.id.id_gallery1);
        mGallery2 = (LinearLayout) view.findViewById(R.id.id_gallery2);
        mGallery3 = (LinearLayout) view.findViewById(R.id.id_gallery3);
        mGallery4 = (LinearLayout) view.findViewById(R.id.id_gallery4);

        image = (ImageView) view.findViewById(R.id.iv_shouye_jin);
        pinpai = (ImageView) view.findViewById(R.id.iv_shouye_pin);
        yi = (ImageView) view.findViewById(R.id.iv_shouye_yi);
        shipin = (ImageView) view.findViewById(R.id.iv_shouye_shipin);
        zhuxing = (ImageView) view.findViewById(R.id.iv_shouye_zhuxing);
        yong = (ImageView) view.findViewById(R.id.iv_shouye_yong);
        wan = (ImageView) view.findViewById(R.id.iv_shouye_wan);
        yu = (ImageView) view.findViewById(R.id.iv_shouye_yu);
        yun = (ImageView) view.findViewById(R.id.iv_shouye_yun);
        zunmm = (ImageView) view.findViewById(R.id.iv_shouye_zunmm);
        muyin = (ImageView) view.findViewById(R.id.iv_shouye_muyin);
        xueqian = (ImageView) view.findViewById(R.id.iv_shouye_xueqian);
        child = (ImageView) view.findViewById(R.id.iv_shouye_child);
        baby = (ImageView) view.findViewById(R.id.iv_shouye_baby);
        newstart = (ImageView) view.findViewById(R.id.iv_shouye_newstart);
        theme = (ImageView) view.findViewById(R.id.iv_shouye_theme);
        accesories = (ImageView) view.findViewById(R.id.iv_shouye_accesories);
        bigjuhui = (ImageView) view.findViewById(R.id.iv_shouye_bigjuhui);
        liangfh = (ImageView) view.findViewById(R.id.iv_shouye_liangfh);
        smoney = (ImageView) view.findViewById(R.id.iv_shouye_smoney);
        spellgroup=(ImageView) view.findViewById(R.id.iv_shouye_spellgroup);
        yunzb=(ImageView) view.findViewById(R.id.iv_shouye_yunzb);
        linyao=(ImageView) view.findViewById(R.id.iv_shouye_linyao);
        queshi=(ImageView) view.findViewById(R.id.iv_shouye_queshi);
        kangbei=(ImageView) view.findViewById(R.id.iv_shouye_kangbei);
        xilang=(ImageView) view.findViewById(R.id.iv_shouye_xilang);
        more=(ImageView) view.findViewById(R.id.iv_shouye_more);

        //发送消息
        myHandler.sendEmptyMessage(1);
        //请求数据
        initShuju();

        //viewpager小圆点联动
        vpShouye.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int arg0 = position % list.size();
                //遍历所有的点对应的ImageView ，判断点的索引是否跟ViewPager当前的索引一致
                for (int i = 0; i < layout.getChildCount(); i++) {

                    ImageView imageView = (ImageView) layout.getChildAt(i);
                    if (i == arg0) {
                        imageView.setSelected(true);
                    } else {
                        imageView.setSelected(false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        //点击
        ivMesTop.setOnClickListener(this);
        ivScanTop.setOnClickListener(this);
        ll.setOnClickListener(this);
        return view;
    }

    /**
     * 请求数据
     */
    private void initShuju() {
        OkHttp.getAsync(path, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(result, Bean.class);

                //加载viewpager
                list = bean.getData().get(0).getTag();
                adapter = new MyShouYePagerAdapter(getActivity(), list);
                //加载GridView
                list1 = bean.getData().get(1).getTag();
                adapter1 = new MyShouYeGridAdapter(getActivity(), list1);
                //添加小圆点
                initYuanDian();
                //适配器
                vpShouye.setAdapter(adapter);
                gvShouye.setAdapter(adapter1);

                //加载秒杀图片
                mlist = bean.getData().get(2).getTag();
                ImageLoader.getInstance().displayImage(murl + mlist.get(0).getPicUrl(), image);

                //加载横向图片
                List<View> mview = new ArrayList<View>();
                for (int i = 1; i < 7; i++) {
                    mInflater = LayoutInflater.from(getActivity());
                    View view = mInflater.inflate(R.layout.shouye_horizontalscroll, null);
                    ImageView iv = (ImageView) view.findViewById(R.id.iv_horizontal_image);
                    ImageLoader.getInstance().displayImage(murl + mlist.get(i).getPicUrl(), iv);
                    mview.add(view);
                }
                for (int i = 0; i < 6; i++) {
                    mGallery.addView(mview.get(i));
                }

                //加载品牌图片
                mvlist = bean.getData().get(4).getTag();
                ImageLoader.getInstance().displayImage(murl + mvlist.get(0).getPicUrl(), pinpai);

                //加载衣食图片
                mv1list = bean.getData().get(5).getTag();
                ImageLoader.getInstance().displayImage(murl + mv1list.get(0).getPicUrl(), yi);
                ImageLoader.getInstance().displayImage(murl + mv1list.get(1).getPicUrl(), shipin);

                //加载住行图片
                mv2list = bean.getData().get(6).getTag();
                ImageLoader.getInstance().displayImage(murl + mv2list.get(0).getPicUrl(), zhuxing);
                ImageLoader.getInstance().displayImage(murl + mv2list.get(1).getPicUrl(), yong);
                //加载玩育图片
                mv3list = bean.getData().get(7).getTag();
                ImageLoader.getInstance().displayImage(murl + mv3list.get(0).getPicUrl(), wan);
                ImageLoader.getInstance().displayImage(murl + mv3list.get(1).getPicUrl(), yu);
                //加载母婴图片
                muyinlist = bean.getData().get(9).getTag();
                ImageLoader.getInstance().displayImage(murl + muyinlist.get(0).getPicUrl(), muyin);

                //加载准妈妈图片
                muyin1list = bean.getData().get(10).getTag();
                ImageLoader.getInstance().displayImage(murl + muyin1list.get(0).getPicUrl(), zunmm);
                ImageLoader.getInstance().displayImage(murl + muyin1list.get(1).getPicUrl(), yun);

                //加载宝贝专区图片
                babylist = bean.getData().get(11).getTag();
                ImageLoader.getInstance().displayImage(murl+ babylist.get(0).getPicUrl(), newstart);
                ImageLoader.getInstance().displayImage(murl + babylist.get(1).getPicUrl(), baby);
                ImageLoader.getInstance().displayImage(murl + babylist.get(2).getPicUrl(), child);
                ImageLoader.getInstance().displayImage(murl + babylist.get(3).getPicUrl(), xueqian);

                //加载主题专区图片
                themelist = bean.getData().get(13).getTag();
                ImageLoader.getInstance().displayImage(murl + themelist.get(0).getPicUrl(), theme);
                theme1list=bean.getData().get(14).getTag();
                ImageLoader.getInstance().displayImage(murl + theme1list.get(0).getPicUrl(), accesories);

                //加载主题横向图片
                theme2list = bean.getData().get(15).getTag();
                List<View> mview1 = new ArrayList<View>();
                for (int i = 0; i < theme2list.size(); i++) {
                    mInflater = LayoutInflater.from(getActivity());
                    View view = mInflater.inflate(R.layout.shouye_horizontalscroll, null);
                    ImageView iv = (ImageView) view.findViewById(R.id.iv_horizontal_image);
                    ImageLoader.getInstance().displayImage(murl + theme2list.get(i).getPicUrl(), iv);
                    mview1.add(view);
                }
                for (int i = 0; i < theme2list.size(); i++) {
                    mGallery1.addView(mview1.get(i));
                }

                //加载大聚惠图片
                bigjuhuilist = bean.getData().get(16).getTag();
                ImageLoader.getInstance().displayImage(murl + bigjuhuilist.get(0).getPicUrl(), bigjuhui);

                //加载大聚惠横向图片
                bigjuhui1list = bean.getData().get(17).getTag();
                List<View> mview2 = new ArrayList<View>();
                for (int i = 0; i < bigjuhui1list.size(); i++) {
                    mInflater = LayoutInflater.from(getActivity());
                    View view = mInflater.inflate(R.layout.shouye_horizontalscroll, null);
                    ImageView iv = (ImageView) view.findViewById(R.id.iv_horizontal_image);
                    ImageLoader.getInstance().displayImage(murl + bigjuhui1list.get(i).getPicUrl(), iv);
                    mview2.add(view);
                }
                for (int i = 0; i < bigjuhui1list.size(); i++) {
                    mGallery2.addView(mview2.get(i));
                }

                //加载量贩惠图片
                tag18 = bean.getData().get(18).getTag();
                ImageLoader.getInstance().displayImage(murl + tag18.get(0).getPicUrl(), liangfh);

                //加载量贩惠横向图片
                tag19 = bean.getData().get(19).getTag();
                List<View> mview3 = new ArrayList<View>();
                for (int i = 0; i < tag19.size(); i++) {
                    mInflater = LayoutInflater.from(getActivity());
                    View view = mInflater.inflate(R.layout.shouye_horizontalscroll, null);
                    ImageView iv = (ImageView) view.findViewById(R.id.iv_horizontal_image);
                    ImageLoader.getInstance().displayImage(murl + tag19.get(i).getPicUrl(), iv);
                    mview3.add(view);
                }
                for (int i = 0; i < tag19.size(); i++) {
                    mGallery3.addView(mview3.get(i));
                }

                //加载省钱图片
                tag20 = bean.getData().get(20).getTag();
                ImageLoader.getInstance().displayImage(murl + tag20.get(0).getPicUrl(), smoney);

                //加载省钱横向图片
                tag21 = bean.getData().get(21).getTag();
                List<View> mview4 = new ArrayList<View>();
                for (int i = 0; i < tag21.size(); i++) {
                    mInflater = LayoutInflater.from(getActivity());
                    View view = mInflater.inflate(R.layout.shouye_horizontalscroll, null);
                    ImageView iv = (ImageView) view.findViewById(R.id.iv_horizontal_image);
                    ImageLoader.getInstance().displayImage(murl + tag21.get(i).getPicUrl(), iv);
                    mview4.add(view);
                }
                for (int i = 0; i < tag21.size(); i++) {
                    mGallery4.addView(mview4.get(i));
                }

                //加载拼团图片
                tag23 = bean.getData().get(23).getTag();
                ImageLoader.getInstance().displayImage(murl + tag23.get(0).getPicUrl(), spellgroup);

                //加载运智贝图片
                tag24 = bean.getData().get(24).getTag();
                ImageLoader.getInstance().displayImage(murl + tag24.get(0).getPicUrl(), yunzb);

                //加载康贝图片
                tag26 = bean.getData().get(26).getTag();
                ImageLoader.getInstance().displayImage(murl+ tag26.get(0).getPicUrl(), kangbei);

                //加载喜朗图片
                tag28 = bean.getData().get(28).getTag();
                ImageLoader.getInstance().displayImage(murl + tag28.get(0).getPicUrl(), xilang);

                //加载玲瑶宝宝图片
                tag30 = bean.getData().get(30).getTag();
                ImageLoader.getInstance().displayImage(murl + tag30.get(0).getPicUrl(), linyao);

                //加载雀氏图片
                tag32 = bean.getData().get(32).getTag();
                ImageLoader.getInstance().displayImage(murl + tag32.get(0).getPicUrl(), queshi);

                //加载更多图片
                tag33 = bean.getData().get(33).getTag();
                ImageLoader.getInstance().displayImage(murl + tag33.get(0).getPicUrl(), more);



            }
        });
    }

    /**
     * 添加小圆点
     */
    private void initYuanDian() {
        //添加下面的圆点
        for (int i = 0; i < list.size(); i++) {
            //动态实例化ImageView对象，添加到LinearLayout里面
            ImageView imageView = new ImageView(getActivity());
            //手动代码设置间距
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 0, 5, 0);
            //将当前属性设置给ImageView
            imageView.setLayoutParams(params);
            //给ImageView设置显示资源
            imageView.setBackgroundResource(R.drawable.item_selector);
            //将ImageView添加到LinearLayout里面
            layout.addView(imageView);
            //设置默认选中第一个
            if (i == 0) {
                imageView.setSelected(true);
            }
        }
    }

    /**
     * 点击效果
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_mes_top:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.ll:
                Intent intent1 = new Intent(getActivity(), SousuoActivity.class);
                startActivity(intent1);
                break;
            case R.id.iv_scan_top:
                Intent intent2 = new Intent(getActivity(), ErweimaActivity.class);
                startActivity(intent2);
                break;
        }
    }

    /**
     * 更新显示UI
     */
    public Handler myHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    //获得ViewPager当前索引
                    int index = vpShouye.getCurrentItem();
                    //当前页卡索引加1

                    //设置当前显示页卡
                    vpShouye.setCurrentItem(index += 1);
                    //延迟发送消息，调用自己
                    myHandler.sendEmptyMessageDelayed(1, 5000);

                    break;
            }
        }
    };

    /**
     * 二维码扫描
     */
    public static final int REQUEST_CODE = 111;
    @Override
    public void onStart() {
        super.onStart();
        requestCodeQrcodePermissions();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
    }

    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private void requestCodeQrcodePermissions() {
        String[] perms = {Manifest.permission.CAMERA};
        if (!EasyPermissions.hasPermissions(getActivity(), perms)) {
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_QRCODE_PERMISSIONS, perms);
        }
    }
}
