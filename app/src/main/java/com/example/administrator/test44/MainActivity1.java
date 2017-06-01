package com.example.administrator.test44;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends FragmentActivity {

    private float mStartY;
    private float mLastY;
    private float mLastDeltaY;
    private int mFirstY;
    private int mCurrentY;
    private boolean mShow;
    private int direction;
    private MyRecyclerAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_main);





    }



    ObjectAnimator mAnimator;

    private void animToolBar(int flag, Toolbar toolbar) {

        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if (flag == 0) {//向上滑隐藏toolBar
            mAnimator = new ObjectAnimator().ofFloat(toolbar, "translationY", toolbar.getTranslationY(), -toolbar.getHeight());
        } else {//向下滑
            mAnimator = new ObjectAnimator().ofFloat(toolbar, "translationY", toolbar.getTranslationY(), 0);
        }

        mAnimator.start();
    }


    public List<String> getDatas() {
        List list_datas = new ArrayList();
        for (int i = 0; i < 50; i++) {
            list_datas.add("data" + i);
        }
        return list_datas;
    }


    public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
        private List<String> mDatas;
        private Context mContext;
        private LayoutInflater inflater;

        public MyRecyclerAdapter(Context context, List<String> datas) {
            this.mContext = context;
            this.mDatas = datas;
            inflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getItemCount() {

            return mDatas.size();
        }

        //填充onCreateViewHolder方法返回的holder中的控件
        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {

            holder.tv.setText(mDatas.get(position));
        }

        //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.item_home, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.tv_item);
            }

        }
    }


}
