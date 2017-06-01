package com.example.administrator.test44;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/22.
 */


/**
 * 学习组合控件  自定义属性
 * 　我们用<declare-styleable>标签声明要使用的自定义属性，用name属性来确定引用的名称。
 * 用format来确定引用数据的格式。在这个自定义控件自定义属性对应列表如下：
 */
public class TimerTextView extends LinearLayout {


    private String secondText;
    private String firstText;

    public TimerTextView(Context context) {
        this(context,null);
    }



    public TimerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        initView();

        Log.e("TimerTextView", "TimerTextView");
    }





    public void initView() {

        Log.e("initView", "initView");
        View view = inflate(getContext(), R.layout.self_ll, this);

        if (leftLogo != null) {
//            this.setBackground(leftLogo);
            ImageView imageView = ((ImageView) view.findViewById(R.id.left_logo));
            imageView.setBackground(leftLogo);
        }

        if (!TextUtils.isEmpty(firstText)) {
            TextView mtv1 = (TextView) view.findViewById(R.id.tv_first);
            mtv1.setText(firstText);
        }
        if (!TextUtils.isEmpty(secondText)) {
            TextView mtv2 = (TextView) view.findViewById(R.id.tv_second);
            mtv2.setText(secondText);
        }


    }




    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);



    }

    /**
     *    rect = new Rect();
     mPaint = new Paint();
     mTextBound = new Rect();
     // 计算了描绘字体需要的范围
     mPaint.getTextBounds(title, 0, title.length(), mTextBound);
     */


    private Drawable leftLogo;

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TimerTextView);
        if (ta != null) {
            leftLogo = ta.getDrawable(R.styleable.TimerTextView_leftLogo);
            firstText = ta.getString(R.styleable.TimerTextView_firstText);
            secondText = ta.getString(R.styleable.TimerTextView_secondText);
        }

    }





}
