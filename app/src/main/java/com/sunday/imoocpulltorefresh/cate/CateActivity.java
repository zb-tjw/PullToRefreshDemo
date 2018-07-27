package com.sunday.imoocpulltorefresh.cate;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sunday.imoocpulltorefresh.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CateActivity extends AppCompatActivity {

    private Handler mHandler;
    private List<CateModel> mDataSource;

    private RecyclerView mRecyclerView;
    private CateAdapter mAdapter;
    private RefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate);
        mHandler = new Handler();
        mDataSource = new ArrayList<>();

        mRefreshLayout = findViewById(R.id.refresh_layout);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CateAdapter(this, mDataSource);
        mRecyclerView.setAdapter(mAdapter);

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initDataSource();
                        mRefreshLayout.finishRefresh();
                    }
                }, 3000);
            }
        });

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initDataSource();
                        mRefreshLayout.finishLoadMore();
                    }
                }, 3000);
            }
        });

        mRefreshLayout.setEnableLoadMore(true);
        mRefreshLayout.autoRefresh();

    }

    private void initDataSource() {

        mDataSource.addAll(getDatas());
        mAdapter.setDataSource(mDataSource);
    }


    private List<CateModel> getDatas () {
        return Arrays.asList(
                new CateModel("但家香酥鸭", "爱过那张脸", R.mipmap.image_practice_repast_1, R.mipmap.image_avatar_1)
                , new CateModel("香菇蒸鸟蛋", "淑女算个鸟", R.mipmap.image_practice_repast_2, R.mipmap.image_avatar_2)
                , new CateModel("花溪牛肉粉", "性感妩媚", R.mipmap.image_practice_repast_3, R.mipmap.image_avatar_3),
                new CateModel("破酥包", "一丝丝纯真", R.mipmap.image_practice_repast_4,  R.mipmap.image_avatar_4)
                , new CateModel("盐菜饭", "等着你回来", R.mipmap.image_practice_repast_5, R.mipmap.image_avatar_5)
                , new CateModel("米豆腐", "宝宝树人", R.mipmap.image_practice_repast_6, R.mipmap.image_avatar_6));
    }
}
