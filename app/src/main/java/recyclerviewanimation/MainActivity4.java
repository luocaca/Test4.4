package recyclerviewanimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.test44.R;
import com.filter.FilterUtil;
import com.gson.GsonUtil;
import com.gson.MyProgramGsonBean;
import com.gson.PorgramDetailGsonBean;
import com.weidget.CustomDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter mAdapter;
    MainActivity4 mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_main4);
        TextView tv_test_gson = (TextView) findViewById(R.id.tv_test_gson);
        TextView tv_content = (TextView) findViewById(R.id.tv_content);
        TextView tv_content1 = (TextView) findViewById(R.id.tv_content1);
        TextView tv_content2 = (TextView) findViewById(R.id.tv_content2);
        tv_test_gson.setText(json);

        PorgramDetailGsonBean gsonBean = GsonUtil.formateJson2Bean(json, PorgramDetailGsonBean.class);


        MyProgramGsonBean.DataBeanX.PageBean.DataBean.ClerkBean clerkBean = gsonBean.data.project.clerk;

        tv_content.setText("过滤后 的值0：" + FilterUtil.strFilter("  -  ", null, "", "12" , "null" , "hellow world"));
        tv_content1.setText("过滤后 的值1：" + FilterUtil.strFilter(null));

//        tv_content.setText(TextUtils.isEmpty(clerkBean.id) + "" + "  text = " + clerkBean.id);



        CustomDialog customDialog = new CustomDialog(mActivity, R.style.Dialog);
//        customDialog.show();

        initData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView4);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());

    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    MainActivity4.this).inflate(R.layout.item_home, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.tv_item);
            }
        }
    }


    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity4.class));
    }


    String json = "{\n" +
            "    \"code\": \"1\",\n" +
            "    \"msg\": \"操作成功\",\n" +
            "    \"data\": {\"project\": {\n" +
            "        \"id\": \"48bb906b5efa4663bfaf7735d77f41c0\",\n" +
            "        \"createBy\": \"b9cef730fa6142eb80bbd7d646e40c66\",\n" +
            "        \"createDate\": \"2017-05-16 11:00:25\",\n" +
            "        \"cityCode\": \"3503\",\n" +
            "        \"cityName\": \"莆田\",\n" +
            "        \"prCode\": \"35\",\n" +
            "        \"ciCode\": \"3503\",\n" +
            "        \"coCode\": \"\",\n" +
            "        \"twCode\": \"\",\n" +
            "        \"num\": \"XM0000246\",\n" +
            "        \"consumerId\": \"2bfc5fbdb02d42df8eb457d34ee7a7c0\",\n" +
            "        \"consumerUserId\": \"36d218cafc8e4b8c9941f74b3ccef42e\",\n" +
            "        \"clerkId\": \"\",\n" +
            "        \"address\": \"未来城三期\",\n" +
            "        \"type\": \"direct\",\n" +
            "        \"projectName\": \"莆田未来城三期样板房补苗项目\",\n" +
            "        \"projectFullName\": \"莆田未来城三期样板房补苗项目\",\n" +
            "        \"consumerName\": \"莆田一鼎\",\n" +
            "        \"consumerUserName\": \"园林公司\",\n" +
            "        \"consumerUserPhone\": \"13058641289\",\n" +
            "        \"consumerInfo\": \"园林公司/13058641289\",\n" +
            "        \"clerkInfo\": \"\",\n" +
            "        \"typeName\": \"直购\"\n" +
            "    }}\n" +
            "}";

}
