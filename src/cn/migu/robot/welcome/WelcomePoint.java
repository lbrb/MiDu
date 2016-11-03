package cn.migu.robot.welcome;

import android.graphics.Color;

/**
 * Created by liangbin on 2016/11/2.
 */

public class WelcomePoint {
    private int color;
    private int radius;
    private Position position;
    private int angle;
    private int speed;

    public WelcomePoint(int color, Position position, int radius, int angle, int speed) {
        this.color = color;
        this.radius = radius;
        this.position = position;
        this.angle = angle;
        this.speed = speed;
    }

    public int getColor() {
        return color;
    }

    public int getRadius() {
        return radius;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public int getAngle() {
        return angle;
    }

    public int getSpeed() {
        return speed;
    }
}
