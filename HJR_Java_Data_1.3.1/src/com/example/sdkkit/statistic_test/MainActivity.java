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
		//��Ϸ���� �� 1�� ���� �� 0 �� ����
		params.put(ProtocolKeys.KEY_GAMETYPE, "1");
		
		SDKKitStatisticSDK.getInstance().init(this,params, new InitListener() {
			
			@Override
			public void onSuccess() {
				Log.i(TAG,"INIT SUCCESS");
				System.out.println(" ��ʼ���ɹ�......");
			}
			
			@Override
			public void onFailed() {
				Log.i(TAG,"INIT FAILED"); 
				System.out.println(" ��ʼ��ʧ��......");
				
			}
		});
		
	}

	

	
	/** ��¼*/
	public void doLogin(View v){

		Map<String, Object> params = new HashMap<String, Object>();
		//����û���ʶ :�����û�ID����,*��ע�⣺ƽ̨��ʶ������Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_USERMARK,"loginUserId123");
		//��ѡ������(int(3))���û����ͣ�0Ϊ ��ʱ�û���1Ϊע���û���2Ϊ��������¼�û�����Ϸû�д��ֶεĿɲ���
		params.put(ProtocolKeys.KEY_USERTYPE,2);
		//���α�� ���������,����Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_SERVERNO, "10");
		
		SDKKitStatisticSDK.getInstance().doUserLogin(params);
		
	
		
	}
	/**������ɫ*/
	public void doCreateRole(View v){

		Map<String, Object> params = new HashMap<String, Object>();

		//���α����ɫΨһ��ʶ,����Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_ROLEMARK, "rolemark");
		
		SDKKitStatisticSDK.getInstance().doCreateRole(params);
		
		
	}

	
	
	/**�ύ����*/
	public void doPostOrder(View v){
		
	
		Map<String, Object> params = new HashMap<String, Object>();
		//���֧����ʽ,��Ϊ����
		params.put(ProtocolKeys.KEY_PAYNAME, "֧����");
		//�����ֵ������Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_AMOUNT, "12");
		//��������ţ�����Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_ORDERNUMBER, "11100");
		//���α������(int),��ҵȼ�
		params.put(ProtocolKeys.KEY_UPGRADE,4);
		//��ѡ����Ʒ����,��Ϊ����
		params.put(ProtocolKeys.KEY_PRODUCT_DESC, "�������ҵ���Ʒ����");
		
		SDKKitStatisticSDK.getInstance().doPostOrder(params) ;
		
		
	}
	
	
	/**��Ϸ���*/
	public void doGameClick(View v){

		Map<String, Object> params = new HashMap<String, Object>();
		//�����ť���ƣ���Ϊ����
		params.put(ProtocolKeys.KEY_NAME, "��¼");
		
		SDKKitStatisticSDK.getInstance().doGameClick(params);
		
	} 
	
	/**�������*/
	public void doUserUpgrade(View v){

			
		Map<String, Object> params = new HashMap<String, Object>();
		//�������(int),��ҵȼ�
		params.put(ProtocolKeys.KEY_UPGRADE, 1);
		SDKKitStatisticSDK.getInstance().doUserUpgrade(params);
	}
	
	
	/**��õ���*/
	public void doItemGet(View v){
	
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		//�������Ψһ��ʶ������Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_ITEMID, "3");
		//����������ͣ�����Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_ITEMTYPE, "2");
		//�������(int),��������
		params.put(ProtocolKeys.KEY_ITEMCOUNT, 1);
		//��ѡ��ԭ��,��Ϊ����
		params.put(ProtocolKeys.KEY_REASON, "ԭ��");
		SDKKitStatisticSDK.getInstance().doItemGet(params);
	}
	/**ʹ�õ���*/
	public void doItemConsume(View v){
	
		
		Map<String, Object> params = new HashMap<String, Object>();
		//�������Ψһ��ʶ������Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_ITEMID, "3");
		//����������ͣ�����Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_ITEMTYPE,"2");
		//�������(int)��������
		params.put(ProtocolKeys.KEY_ITEMCOUNT, 1);
		//��ѡ��ԭ�򣬿�Ϊ����
		params.put(ProtocolKeys.KEY_REASON, "ԭ��");
		SDKKitStatisticSDK.getInstance().doItemConsume(params);
	}
	/**�������*/
	public void doItemBuy(View v){
	
		
		Map<String, Object> params = new HashMap<String, Object>();
		//�������Ψһ��ʶ������Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_ITEMID, "3");
		//����������ͣ�����Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_ITEMTYPE, "3");
		//�������(int),��������
		params.put(ProtocolKeys.KEY_ITEMCOUNT,1);
		//�������(int),���������
		params.put(ProtocolKeys.KEY_CURRENCYCOUNT,1);
		//������������,��Ϊ����
		params.put(ProtocolKeys.KEY_CURRENCYTYPE, "1");
		//��ѡ���Ʒѵ㣬��Ϊ����
		params.put(ProtocolKeys.KEY_POINT, "");
		SDKKitStatisticSDK.getInstance().doItemBuy(params);
	}
	/**��ʼ�ؿ�*/
	public void doStartLevel(View v){

		
		Map<String, Object> params = new HashMap<String, Object>();
		//�����ҵȼ�������(int)
		params.put(ProtocolKeys.KEY_GRADE, 1);
		//����ؿ���ţ�����(int)
		params.put(ProtocolKeys.KEY_SEQNO,1);
		//����ؿ�Ψһ��ʶ,����Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_LEVELID, "levelmark1");
		//�������(int),�ؿ��Ѷȣ�0�� 1һ��2���ѣ�3.�����ѣ�4.�ǳ����ѣ��Դ����ƣ�Խ�ѵ��ź����ֵ�����
		params.put(ProtocolKeys.KEY_DIFFICULTY, 4);
		SDKKitStatisticSDK.getInstance().doStartLevel(params);
	}
	
	/**�����ؿ�*/
	public void doEndLevel(View v){
		
		Map<String, Object> params = new HashMap<String, Object>();
		//����ؿ���ţ�����(int)
		params.put(ProtocolKeys.KEY_SEQNO,1);
		//����ؿ�Ψһ��ʶ,����Ϊ���Ļ��������͵������ַ�
		params.put(ProtocolKeys.KEY_LEVELID,  "levelmark1");
		//�������(int),�ؿ�״̬�� 0.�ɹ��� 2ʧ�ܣ�3�˳� ���˴��̶�ֻ����0����2����3�����������ֻᵼ��û��ͳ������
		params.put(ProtocolKeys.KEY_STATUS,0);
		//��ѡ��ԭ����ʧ�ܵ㣩,��Ϊ����
		params.put(ProtocolKeys.KEY_REASON, "ʧ�ܵ�");

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
		//�������½���ǰ̨����¼ʱ��
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











