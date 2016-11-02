package cn.migu.robot.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/*
 * 登录成功之后，跳转到MiDuChatActivity聊天界面，即程序的主界面
 */
public class MiDuChatActivity extends Activity {
	
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mi_du_chat_layout);
	}
	
	private void initMiDuAc(){
		
	}
}
