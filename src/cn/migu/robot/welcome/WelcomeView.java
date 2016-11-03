package cn.migu.robot.welcome;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.Random;


/**
 * Created by liangbin on 2016/11/2.
 */

public class WelcomeView extends View {
    private static final String TAG = "WelcomeView";
    private Context context;
    private WelcomePoint[] points;
    private int screenWidth;
    private int screenHeight;
    private Random random;

    public WelcomeView(Context context) {
        super(context);
        this.context = context;

        random = new Random();

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        this.screenWidth = display.getWidth();
        this.screenHeight = display.getHeight();
        Log.d(TAG, "onDraw: "+ display.getWidth()+","+display.getHeight());

        this.points = new WelcomePoint[100];
        generatePoints();
    }

    private void generatePoints() {
        for (int i =0; i<points.length; i++){
            //RGB
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            //Position
            int x = random.nextInt(1080);
            int y = random.nextInt(1920);
            Position position = new Position(x,y);
            //Radius
            int radius = random.nextInt(20);
            //angle
            int angle = random.nextInt(360);
            //speed
            int speed = random.nextInt(5)+3;

            points[i] = new WelcomePoint(Color.argb(255,r,g,b),position,radius,angle,speed);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPoints(canvas);
        invalidate();
    }

    private void drawPoints(Canvas canvas) {
        Paint paint = new Paint();
        for (WelcomePoint point:
             this.points) {
            paint.setColor(point.getColor());
            int angle = point.getAngle();
            int x = point.getPosition().getX();
            int y = point.getPosition().getY();
            int speed = point.getSpeed();
            x = (int) (x + speed*Math.cos(angle*Math.PI/180));
            y = (int) (y + speed*Math.sin(angle*Math.PI/180));

            if(x<0||x>screenWidth){
                x = random.nextInt(screenWidth);
            }

            if(y<0||y>screenHeight){
                y = random.nextInt(screenHeight);
            }

            point.setPosition(new Position(x,y));
            canvas.drawCircle(point.getPosition().getX(),point.getPosition().getY(),point.getRadius(),paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            Log.d(TAG, "onTouchX: "+event.getX()+",Y:"+event.getY());
        }
        return false;
    }

    private void drawLines(Canvas canvas, float x, float y){
        for (WelcomePoint point :
                points) {
            //TODO draw lines
        }
    }
}
