package com.shadev.pierrebeziercircle.Demo3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lixian on 2016/7/11.
 */
public class LxView extends View {
    public LxView(Context context) {
        super(context);
        init(context);
    }

    public LxView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LxView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    PointF one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve;
    private Path mPath;
    //画笔
    private Paint mFillCirclePaint;

    private void init(Context context) {
        mFillCirclePaint = new Paint();
        mFillCirclePaint.setColor(0xFFfe626d);
        mFillCirclePaint.setStyle(Paint.Style.FILL);
        mFillCirclePaint.setStrokeWidth(1);
        mFillCirclePaint.setAntiAlias(true);
        mPath = new Path();


    }

    private int width;
    private int height;
    private int centerX;
    private int centerY;
    private float radius;
    private float blackMagic = 0.551915024494f;
    private float c;


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
        centerX = width / 2;
        centerY = height / 2;
        radius = 200;
        c = radius * blackMagic;
        setPoint();
    }

    private void setPoint() {
        one = new PointF(0, radius);
        two = new PointF(c, radius);
        three = new PointF(radius, c);
        four = new PointF(radius, 0);
        five = new PointF(radius, -c);
        six = new PointF(c, -radius);
        seven = new PointF(0, -radius);
        eight = new PointF(-c, -radius);
        nine = new PointF(-radius, -c);
        ten = new PointF(-radius, 0);
        eleven = new PointF(-radius, c);
        twelve = new PointF(-c, radius);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //
        mPath.reset();
        canvas.translate(centerX, centerY); // 将坐标系移动到画布中央


        mPath.moveTo(one.x, one.y);
        mPath.cubicTo(two.x, two.y, three.x, three.y, four.x, four.y);
        mPath.cubicTo(five.x, five.y, six.x, six.y, seven.x, seven.y);
        mPath.cubicTo(eight.x, eight.y, nine.x, nine.y, ten.x, ten.y);
        mPath.cubicTo(eleven.x, eleven.y, twelve.x, twelve.y, one.x, one.y);
        canvas.drawPath(mPath, mFillCirclePaint);


        //重置数据
        c = radius * blackMagic;
        setPoint();

    }

    public void setLeft() {
        invalidate();
    }

    public void setMleft() {
        four.x += radius;
        invalidate();
    }

    public void setMiddle() {
        c += c / 3;
        setPoint();
        four.x += radius/2;
        ten.x -= radius/2;
        invalidate();
    }

    public void setMRight() {
        ten.x -= radius;
        invalidate();
    }

    public void setRight() {
        invalidate();
    }
}
