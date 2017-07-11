package recyclerviewanimation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.test44.R;
import com.example.xrecyclerview.XListViewHeader;
import com.scu.miomin.shswiperefresh.core.SHSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import recyclerviewanimation.weidget.MySwipeRefreshLayout;

public class MainActivity3 extends FragmentActivity {
    private static final String TAG = "MainActivity3";
    public Activity mActivity;
    private RecyclerView recyclerView;
    private MyAdapt myAdapt;
    private MySwipeRefreshLayout swipeRefreshLayout;
    private XListViewHeader refreshHeadView;
    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        Toast.makeText(mActivity, "hellow world1 ", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main3);

        TextView tv_test_span = (TextView) findViewById(R.id.tv_test_span);


        String str=" Hello everyone!";
        SpannableStringBuilder mSpannableStringBuilder=new SpannableStringBuilder(str);

        mSpannableStringBuilder.setSpan
                (new ForegroundColorSpan(Color.RED), 1, 3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mSpannableStringBuilder.setSpan
                (new ForegroundColorSpan(Color.GREEN), 5, 9, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);


//        tv_test_span.setText("=================================" + StringFormatUtil.setTextColor(mActivity, "红色的字" +mSpannableStringBuilder,android.R.color.holo_red_dark));
        tv_test_span.setText(mSpannableStringBuilder);

        swipeRefreshLayout = (MySwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout3);
        refreshHeadView = new XListViewHeader(mActivity);
        swipeRefreshLayout.setHeaderView(refreshHeadView);
//        swipeRefreshLayout.setHeaderView(R.layout.xlistview_header);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapt = new MyAdapt();
        recyclerView.setAdapter(new MyAdapt());
        myAdapt.addDatas(getDatas());

        swipeRefreshLayout.setOnRefreshListener(new MySwipeRefreshLayout.SHSOnRefreshListener() {
            @Override
            public void onRefresh() {

                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                swipeRefreshLayout.finishRefresh();
                            }
                        }, 500);
                        refreshHeadView.setState(3);
                    }
                }, 1600);

            }

            @Override
            public void onLoading() {


            }


            @Override
            public void onRefreshPulStateChange(float percent, int state) {
                switch (state) {
                    case SHSwipeRefreshLayout.NOT_OVER_TRIGGER_POINT:
                        swipeRefreshLayout.setLoaderViewText("下拉刷新");
                        refreshHeadView.setState(0);
                        break;
                    case SHSwipeRefreshLayout.OVER_TRIGGER_POINT:
                        swipeRefreshLayout.setLoaderViewText("松开刷新");
                        refreshHeadView.setState(1);
                        break;
                    case SHSwipeRefreshLayout.START:
                        swipeRefreshLayout.setLoaderViewText("正在刷新");
                        refreshHeadView.setState(2);
                        break;
                }
            }

            @Override
            public void onLoadmorePullStateChange(float percent, int state) {

            }
        });

    }

    public List<String> getDatas() {
        List<String> lists = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lists.add("item" + i);
        }
        return lists;
    }


    public class MyAdapt extends RecyclerView.Adapter<MyAdapt.MyViewHolder> {


        List<String> list_datas = new ArrayList<>();

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv_msg;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv_msg = (TextView) itemView.findViewById(R.id.tv_msg);
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_test, parent, false);
            MyViewHolder vh = new MyViewHolder(view);
            Log.e(TAG, "onCreateViewHolder: ");
//            Toast.makeText(mActivity, "MyAdapt", Toast.LENGTH_LONG).show();
            return vh;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            Log.d(TAG, "onBindViewHolder: hellow world");
            holder.tv_msg.setText("hellow world");
            holder.tv_msg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity4.start(mActivity);
                }
            });
        }

        @Override
        public int getItemCount() {
            return 20;
        }


        public void addDatas(List<String> lists) {
            this.list_datas.addAll(lists);
            this.notifyDataSetChanged();
        }

    }
}
