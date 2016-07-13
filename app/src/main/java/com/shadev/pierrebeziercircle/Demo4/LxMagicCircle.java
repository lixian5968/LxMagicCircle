package com.shadev.pierrebeziercircle.Demo4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.shadev.pierrebeziercircle.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lixian on 2016/7/11.
 */
public class LxMagicCircle extends View {
    public LxMagicCircle(Context context) {
        super(context);
        init(context);
    }

    public LxMagicCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public LxMagicCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    PointF one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve;
    private Path mPath;
    //画笔
    private Paint mFillCirclePaint;
    private Paint CirclePoint;
    float point_to_point;
    float point_ridio;

    private void init(Context context) {
        point_to_point = context.getResources().getDimension(R.dimen.point_to_point);
        point_ridio = context.getResources().getDimension(R.dimen.point_ridio);


        mFillCirclePaint = new Paint();
        mFillCirclePaint.setColor(0xFFfe626d);
        mFillCirclePaint.setStyle(Paint.Style.FILL);
        mFillCirclePaint.setStrokeWidth(1);
        mFillCirclePaint.setAntiAlias(true);
        mPath = new Path();

        CirclePoint = new Paint();
        CirclePoint.setColor(0xFFfe626d);
        CirclePoint.setStyle(Paint.Style.STROKE);
        CirclePoint.setStrokeWidth(1);
        CirclePoint.setAntiAlias(true);


    }

    private int width;
    private int height;
    private int centerX;
    private int centerY;
    private float radius;
    private float blackMagic = 0.551915024494f;
    private float c;
    float stretchDistance;
    float cDistance;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
        centerX = width / 2;
        centerY = height / 2;
        radius = point_ridio;
        stretchDistance = point_ridio;
        cDistance = c * 0.45f;
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


        if (points != null && points.size() > check) {
            float px = (float) points.get(check).x;
            if (isLeft) {
                px -= stretchDistance;
            }
            adjustAllX(1, px);
            adjustAllX(2, px);
            adjustAllX(3, px);
            adjustAllX(4, px);
        }


    }


    public int check = 0;
    boolean isLeft = false;

    public void setCheck(int myCheck) {
        if (myCheck > check) {
            isLeft = true;
        } else {
            isLeft = false;
        }
        this.check = myCheck;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        canvas.translate(centerX, centerY); // 将坐标系移动到画布中央
        if (points != null && points.size() > 0) {
            for (int i = 0; i < points.size(); i++) {
                canvas.drawCircle((float) points.get(i).x, (float) points.get(i).y, point_ridio, CirclePoint);// 小圆
            }
        }

        float px = (float) points.get(check).x;
        if (isLeft) {
            px -= stretchDistance;
        }

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


    public void setPosition(float position) {

        Log.e("LxPosition", position + "");
        try {
            if (position >= 0 && position <= 0.2) {
                model1(position);
            } else if (position > 0.2 && position <= 0.5) {
                model2(position);
            } else if (position > 0.5 && position <= 0.8) {
                model3(position);
            } else if (position > 0.8 && position <= 0.9) {
                model4(position);
            } else if (position > 0.9 && position <= 1) {
                model5(position);
            }

            invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void model1(float time) {//0~0.2
        setPoint();
        adjustAllX(2, stretchDistance * time * 5);
    }

    private void model2(float time) {//0.2~0.5
        model1(0.2f);
        time = (time - 0.2f) * (10f / 3);
        adjustAllX(1, stretchDistance / 2 * time);
        adjustAllX(3, stretchDistance / 2 * time);
        adjustY(2, cDistance * time);
        adjustY(4, cDistance * time);
    }

    private void model3(float time) {//0.5~0.8
        model2(0.5f);
        time = (time - 0.5f) * (10f / 3);

        adjustAllX(1, stretchDistance / 2 * time);
        adjustAllX(3, stretchDistance / 2 * time);
        adjustY(2, -cDistance * time);
        adjustY(4, -cDistance * time);
        adjustAllX(4, stretchDistance / 2 * time);

    }

    private void model4(float time) {//0.8~0.9
        model3(0.8f);
        time = (time - 0.8f) * 10;
        adjustAllX(4, stretchDistance / 2 * time);
    }

    private void model5(float time) {
        model4(0.9f);
        time = time - 0.9f;
        adjustAllX(4, (float) (Math.sin(Math.PI * time * 10f) * (2 / 10f * radius)));
    }


    private void adjustY(int i, float offset) {

        if (i == 2) {
            five.y -= offset;
            seven.y += offset;
        }

        if (i == 4) {
            nine.y -= offset;
            eleven.y += offset;
        }

    }

    private void adjustAllX(int i, float offset) {
        Log.e("lxoffset", offset + "");
        try {
            if (i == 1) {
                one.x += offset;
                twelve.x += offset;
                two.x += offset;
            } else if (i == 2) {
                three.x += offset;
                four.x += offset;
                five.x += offset;
            } else if (i == 3) {
                six.x += offset;
                seven.x += offset;
                eight.x += offset;
            } else if (i == 4) {
                nine.x += offset;
                ten.x += offset;
                eleven.x += offset;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    int allSize = 0;
    List<CheckPoint> points;
    boolean even;
    int evenNumber;

    public void setSize(int size) {
        points = new ArrayList<>();
        allSize = size;
        even = allSize % 2 == 0;
        evenNumber = allSize / 2;
        if (size > 0) {
            for (int i = 0; i < allSize; i++) {
                if (even) {
                    CheckPoint mCheckPoint = new CheckPoint();
                    if (i < evenNumber) {
                        mCheckPoint.x = -(evenNumber - i - 0.5) * point_to_point;
                    } else {
                        mCheckPoint.x = (i - evenNumber + 0.5) * point_to_point;
                    }
                    mCheckPoint.y = 0;
                    points.add(mCheckPoint);
                } else {
                    CheckPoint mCheckPoint = new CheckPoint();
                    if (i < evenNumber) {
                        mCheckPoint.x = -(evenNumber - i) * point_to_point;
                    } else if (i == evenNumber) {
                        mCheckPoint.x = 0;
                    } else {
                        mCheckPoint.x = (i - evenNumber) * point_to_point;
                    }
                    mCheckPoint.y = 0;
                    points.add(mCheckPoint);
                }
            }
        }


    }

    public class CheckPoint {
        public double x;
        public double y;
        public boolean check;
    }
}
