package cn.migu.robot.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import cn.migu.robot.welcome.WelcomeView;


/*
 * 启动动画Activity，动画结束跳转到登录界面
 */
public class MiDuChatWelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new WelcomeView(this));
	}
}
