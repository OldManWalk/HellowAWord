package fuyu.javares;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {

    public float currentX= 40;
    public float currentY= 50;
    //定义创建画笔
    Paint paint =new Paint();

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet set) {
        super(context,set);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔的颜色
        paint.setColor(Color.GREEN);
        canvas.drawCircle(currentX,currentY,15,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //当前组件的currentX,currentY的两个属性
        this.currentX = event.getX();
        this.currentY = event.getY();
        //通知该组件重绘
        this.invalidate();

        //返回true表明方法已经处理事件
        return true;

    }
}

