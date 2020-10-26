package com.example.hellowword;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {
    private float currentX=40f;
    private float currentT=50f;
    private Paint p = new Paint();
    public DrawView(Context context)
    {
        super(context);
    }
    public DrawView(Context context, AttributeSet set)
    {
        super(context,set);
    }
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        p.setColor(Color.RED);
        canvas.drawCircle(currentX,currentT,15F,p);
    }
    public boolean onTouchEvent(MotionEvent event)
    {
        currentX = event.getX();
        currentT = event.getY();
        invalidate();
        return true;
    }


}
