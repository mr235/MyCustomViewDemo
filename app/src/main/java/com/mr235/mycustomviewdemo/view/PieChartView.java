package com.mr235.mycustomviewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by Administrator on 2017/2/5.
 */

public class PieChartView extends View {

    private int[] colors = {
            0xffff1100,
            0xff1111ff,
            0xffffee00,
            0xffcc11bb,
            0xffaaee00,
            0xff3311ee,
            0xffff6688
    };

    private int count = 7;

    private Paint mPaint = null;
    private int[] pies = null;
    private int total = 0;

    private int mWidth = 0;
    private int mHeight = 0;

    public PieChartView(Context context) {
        this(context, null);
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        pies = new int[count];
        Random random = new Random();
        for (int i=0; i < count; i++) {
            pies[i] = random.nextInt(100) + 1;
            total += pies[i];
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (total <= 0) {
            return;
        }
        canvas.translate(mWidth / 2, mHeight / 2);
        float r = Math.min(mWidth, mHeight) / 2 * 0.8f;
        RectF rect = new RectF(-r, -r, r, r);
        float startAngle = 0f;
        for (int i = 0; i < pies.length; i++) {
            float sweepAngle = (float)pies[i] / total * 360;
            mPaint.setColor(colors[i % colors.length]);
            canvas.drawArc(rect, startAngle, sweepAngle, true, mPaint);
            startAngle += sweepAngle;
        }
    }
}
