package com.example.sdkkit.statistic_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_sdkkitsdk_statistic_test.R;
import com.sdkkit.gameplatform.statistic.SDKKitStatisticSDK;
import com.sdkkit.gameplatform.statistic.util.C;
import com.sdkkit.gameplatform.statistic.util.InitListener;
import com.sdkkit.gameplatform.statistic.util.ProtocolKeys;

public class MainActivity extends Activity {
private static String TAG="SDKKitStatistic_MainActivity";
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		
		Map<String, Object> params = new HashMap<String, Object>() ; 
		//游戏类型 ： 1， 网游 ； 0 ， 单机
		params.put(ProtocolKeys.KEY_GAMETYPE, "1");
		
		SDKKitStatisticSDK.getInstance().init(this,params, new InitListener() {
			
			@Override
			public void onSuccess() {
				Log.i(TAG,"INIT SUCCESS");
				System.out.println(" 初始化成功......");
			}
			
			@Override
			public void onFailed() {
				Log.i(TAG,"INIT FAILED"); 
				System.out.println(" 初始化失败......");
				
			}
		});
		
	}

	

	
	/** 登录*/
	public void doLogin(View v){

		Map<String, Object> params = new HashMap<String, Object>();
		//必填，用户标识 :传入用户ID即可,*请注意：平台标识，不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_USERMARK,"loginUserId123");
		//可选，整型(int(3))，用户类型：0为 临时用户，1为注册用户，2为第三方登录用户，游戏没有此字段的可不填
		params.put(ProtocolKeys.KEY_USERTYPE,2);
		//网游必填， 服务器编号,不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_SERVERNO, "10");
		
		SDKKitStatisticSDK.getInstance().doUserLogin(params);
		
	
		
	}
	/**创建角色*/
	public void doCreateRole(View v){

		Map<String, Object> params = new HashMap<String, Object>();

		//网游必填，角色唯一标识,不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_ROLEMARK, "rolemark");
		
		SDKKitStatisticSDK.getInstance().doCreateRole(params);
		
		
	}

	
	
	/**提交订单*/
	public void doPostOrder(View v){
		
	
		Map<String, Object> params = new HashMap<String, Object>();
		//必填，支付方式,可为中文
		params.put(ProtocolKeys.KEY_PAYNAME, "支付宝");
		//必填，充值金额，不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_AMOUNT, "12");
		//必填，订单号，不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_ORDERNUMBER, "11100");
		//网游必填，整型(int),玩家等级
		params.put(ProtocolKeys.KEY_UPGRADE,4);
		//可选，商品描述,可为中文
		params.put(ProtocolKeys.KEY_PRODUCT_DESC, "这里是我的商品描述");
		
		SDKKitStatisticSDK.getInstance().doPostOrder(params) ;
		
		
	}
	
	
	/**游戏点击*/
	public void doGameClick(View v){

		Map<String, Object> params = new HashMap<String, Object>();
		//必填，按钮名称，可为中文
		params.put(ProtocolKeys.KEY_NAME, "登录");
		
		SDKKitStatisticSDK.getInstance().doGameClick(params);
		
	} 
	
	/**玩家升级*/
	public void doUserUpgrade(View v){

			
		Map<String, Object> params = new HashMap<String, Object>();
		//必填，整型(int),玩家等级
		params.put(ProtocolKeys.KEY_UPGRADE, 1);
		SDKKitStatisticSDK.getInstance().doUserUpgrade(params);
	}
	
	
	/**获得道具*/
	public void doItemGet(View v){
	
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		//必填，道具唯一标识，不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_ITEMID, "3");
		//必填，道具类型，不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_ITEMTYPE, "2");
		//必填，整型(int),道具数量
		params.put(ProtocolKeys.KEY_ITEMCOUNT, 1);
		//可选，原因,可为中文
		params.put(ProtocolKeys.KEY_REASON, "原因");
		SDKKitStatisticSDK.getInstance().doItemGet(params);
	}
	/**使用道具*/
	public void doItemConsume(View v){
	
		
		Map<String, Object> params = new HashMap<String, Object>();
		//必填，道具唯一标识，不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_ITEMID, "3");
		//必填，道具类型，不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_ITEMTYPE,"2");
		//必填，整型(int)道具数量
		params.put(ProtocolKeys.KEY_ITEMCOUNT, 1);
		//可选，原因，可为中文
		params.put(ProtocolKeys.KEY_REASON, "原因");
		SDKKitStatisticSDK.getInstance().doItemConsume(params);
	}
	/**购买道具*/
	public void doItemBuy(View v){
	
		
		Map<String, Object> params = new HashMap<String, Object>();
		//必填，道具唯一标识，不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_ITEMID, "3");
		//必填，道具类型，不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_ITEMTYPE, "3");
		//必填，整型(int),道具数量
		params.put(ProtocolKeys.KEY_ITEMCOUNT,1);
		//必填，整型(int),虚拟币数量
		params.put(ProtocolKeys.KEY_CURRENCYCOUNT,1);
		//必填，虚拟币类型,可为中文
		params.put(ProtocolKeys.KEY_CURRENCYTYPE, "1");
		//可选，计费点，可为中文
		params.put(ProtocolKeys.KEY_POINT, "");
		SDKKitStatisticSDK.getInstance().doItemBuy(params);
	}
	/**开始关卡*/
	public void doStartLevel(View v){

		
		Map<String, Object> params = new HashMap<String, Object>();
		//必填，玩家等级，整型(int)
		params.put(ProtocolKeys.KEY_GRADE, 1);
		//必填，关卡序号，整型(int)
		params.put(ProtocolKeys.KEY_SEQNO,1);
		//必填，关卡唯一标识,不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_LEVELID, "levelmark1");
		//必填，整型(int),关卡难度：0简单 1一般2困难，3.很困难，4.非常困难（以此类推，越难的排后，数字递增）
		params.put(ProtocolKeys.KEY_DIFFICULTY, 4);
		SDKKitStatisticSDK.getInstance().doStartLevel(params);
	}
	
	/**结束关卡*/
	public void doEndLevel(View v){
		
		Map<String, Object> params = new HashMap<String, Object>();
		//必填，关卡序号，整型(int)
		params.put(ProtocolKeys.KEY_SEQNO,1);
		//必填，关卡唯一标识,不能为中文或中文类型的特殊字符
		params.put(ProtocolKeys.KEY_LEVELID,  "levelmark1");
		//必填，整型(int),关卡状态： 0.成功， 2失败，3退出 ；此处固定只能填0，或2，或3，填其他数字会导致没有统计数据
		params.put(ProtocolKeys.KEY_STATUS,0);
		//可选，原因（如失败点）,可为中文
		params.put(ProtocolKeys.KEY_REASON, "失败点");

		SDKKitStatisticSDK.getInstance().doEndLevel(params);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			android.os.Process.killProcess(android.os.Process.myPid());
		}
		return super.onKeyDown(keyCode, event);
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		//界面重新进入前台，记录时间
		if (!C.isActive) {
			SDKKitStatisticSDK.getInstance().saveFrontTime();
			C.isActive = true ;
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
		
		if (!SDKKitStatisticSDK.getInstance().isAppOnForeground()) {
			SDKKitStatisticSDK.getInstance().saveBackTime() ;
			C.isActive = false ;
		}
		
	}

	
	


}











