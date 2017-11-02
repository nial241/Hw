package com.example.user.hw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.content.res.TypedArray;

public class DrawView extends View {
    private float[] points = new float[] {};
    private Paint paint = new Paint();
    private int color2;
    private boolean XName,YName,StepsName,Grid,LineName;


    @Override
    protected void onDraw(Canvas canvas) {
        drawMain(canvas,points,LineName,color2,"Line 1");
        if (Grid)
            drawGrid(canvas);
        //if (StepsName)
        //drawSteps(canvas);
        if (XName)
            drawXName(canvas,"X Values");
        if (YName)
            drawYName(canvas,"Y Values");
        setData(new float[]{1,1,5,5,10,5,17,17});
        drawMain(canvas,points,LineName,Color.BLUE,"Line 2");
    }

    private void drawXName(Canvas canvas,String name){
        paint.setColor(Color.DKGRAY);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(30);
        canvas.save();
        canvas.translate(getWidth(),0);
        canvas.rotate(90);
        canvas.drawText(name,getWidth()/2+2*getPaddingStart(),getWidth()-5,paint);
        canvas.restore();
    }

    private void drawYName(Canvas canvas,String name){
        paint.setColor(Color.DKGRAY);
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTextSize(30);
        canvas.drawText(name,getWidth()/2+getPaddingLeft()+5,getHeight()-5,paint);
    }

    public void setData(float[] data) {
        this.points = data.clone();
    }

    private void drawGrid(Canvas canvas){
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        int offs_x = (getWidth()-getPaddingLeft()-getPaddingRight())/points.length*2;
        int offs_y = (getHeight()-getPaddingTop()-getPaddingBottom())/points.length*2;
        for (int i = 0; i < points.length*2; i++){
            canvas.drawLine(getPaddingLeft(),offs_y*i+getPaddingTop(),
                    getWidth()-getPaddingRight(),offs_y*i+getPaddingTop(),paint);
            canvas.drawLine(offs_x*i+getPaddingLeft(),getPaddingTop(),
                    offs_x*i+getPaddingLeft(),getHeight()-getPaddingBottom(),paint);
        }
    }

        /*private void drawSteps(Canvas canvas){
            paint.setColor(Color.LTGRAY);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(20);
            double stepx=Math.ceil(getMin_Max(points)[0]/(getWidth()-getPaddingLeft()-getPaddingRight()-10));
            double stepy=Math.ceil(getMin_Max(points)[1]/(getHeight()-getPaddingBottom()-getPaddingTop()-10));
            int offs_x = (getWidth()-getPaddingLeft()-getPaddingRight())/points.length*2;
            int offs_y = (getHeight()-getPaddingTop()-getPaddingBottom())/points.length*2;
            for (int i = 0; i < points.length*2; i++){
                canvas.drawText(String.valueOf(stepx*i),offs_x*i+getPaddingLeft(),getHeight()-15,paint);

                }
            canvas.save();
            canvas.translate(getWidth(),0);
            canvas.rotate(90);
            for (int i = 0; i < points.length*2; i++){
                canvas.drawText(String.valueOf(stepx*i),offs_y*i+getPaddingLeft(),getPaddingTop(),paint);
                //canvas.drawText(String.valueOf(step*i),getWidth()-getPaddingRight(),offs_y*i+getPaddingTop(),paint);
            }

            canvas.restore();

        }*/

    private float[] getMin_Max(float[] data) {
        float max = data[0];
        float min = data[1];
        for (int i = 0; i<data.length;i++) {
            if (data[i]>max && i%2==0)
                max=data[i];
            if (data[i]>min && i%2==1)
                min=data[i];
        }
        Log.d("max x"," "+max);
        Log.d("max y"," "+min);
        return new float[]{max,min};
    }




    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DrawView,
                0, 0);

        try {
            color2 = a.getColor(R.styleable.DrawView_color1, 0);

            XName = a.getBoolean(R.styleable.DrawView_XName,false);
            YName = a.getBoolean(R.styleable.DrawView_YName,false);
            StepsName = a.getBoolean(R.styleable.DrawView_StepsName,false);
            Grid = a.getBoolean(R.styleable.DrawView_Grid,false);

            LineName = a.getBoolean(R.styleable.DrawView_LineName,false);
            Log.d("tag Line",String.valueOf(LineName));

        } finally {
            a.recycle();
            Log.d("tag",a.toString());
        }
    }







    private void drawMain(Canvas canvas,float[] data,boolean NameFlag,int color,String LineName) {

        paint.setColor(Color.DKGRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(getPaddingLeft(),getPaddingTop(),getWidth()-getPaddingRight(),getHeight()-getPaddingBottom(),paint);

        //set custom color to line
        paint.setColor(color);
        float offsetX = getWidth()-getPaddingLeft() - getPaddingRight() - 10;
        float offsetY = getHeight()-getPaddingTop()-getPaddingBottom() - 10;
        float max[] = getMin_Max(data).clone();
        for (int i = 0; i < data.length; i++) {
            if (i % 2 == 0){
                data[i] = data[i]/max[0] * offsetX + getPaddingLeft()+5;
            }
            else
            {
                data[i] =  data[i]/max[1] * offsetY + getPaddingTop()+ 5;
            }
        }
        Path path = new Path();
        path.moveTo(data[0], data[1]);
        for (int i = 2; i <data.length-1; i+=2) {
            path.lineTo(data[i], data[i+1]);
        }
        canvas.drawPath(path, paint);
        if (NameFlag){
            Log.d("NameFlag","true");
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(50);
            paint.setColor(color);
            canvas.drawText(LineName,data[2],data[3],paint);

        }
    }
}

