package com.example.easytablemore;

import utils.Utility;

import com.example.easytablemore.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener {

	private Button btn;
	// ��ѡ���Ƿ��ס����
	private CheckBox rememberPaw;
	// ��ס�����booleaֵ��Ĭ��Ϊû��
	private Boolean isRememberPaw = false;
	// �û���
	private EditText editUserName;
	// ����
	private EditText editPassword;

	private TextView tvForgetPwd, rule;

	// ��ֵ�洢.
	private SharedPreferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		// ����Ѿ���¼������ֱ�ӽ�����ҳ��
		if (LoginState()) {
			startActivity(new Intent(LoginActivity.this, MainActivity.class));
			finish();
		}

		// ��ʼ���ؼ����󶨿ؼ���
		initView();
		// ����Ƿ����Ѿ������˵��˺ź�����
		checkIsSaveNameAndPass();
		initEvent();

	}

	private void initEvent() {
		// �󶨵����¼�
		tvForgetPwd.setOnClickListener(this);
		btn.setOnClickListener(this);
		rule.setOnClickListener(this);

		rememberPaw
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (isChecked) {
							isRememberPaw = true;
							changeRemeber(true);
						} else {
							isRememberPaw = false;
							changeRemeber(false);
						}
					}
				});
	}

	// ������ͳһ��ӵ����¼�
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tvForgetPwd:// ��������ĵ����¼�
			Toast.makeText(getApplicationContext(), "���˾����˰�",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.rule:// ��������ĵ����¼�
			Toast.makeText(
					getApplicationContext(),
					"�˺ű����λ���֣�ǰ��λΪ��ѧ�꣬��15���������2015����ѧ;֮����λΪרҵ���룬��001;֮����λΪ�༶���룬��01�������λΪ�Լ�����ţ���01������������150010101",
					Toast.LENGTH_LONG).show();
			break;

		case R.id.btnLogin:// ��¼��ť�ĵ����¼�
			Utility util = new Utility();
			if ("".equals(editUserName.getText().toString())
					|| "".equals(editPassword.getText().toString())) {
				Toast.makeText(getApplicationContext(), "ѧ�Ż�����Ϊ��",
						Toast.LENGTH_SHORT).show();
			} else if (editUserName.getText().toString().length() != 9) {
				Toast.makeText(getApplicationContext(), "��λͬ־��ѧ�ų��ȱ���Ϊ9λŶ��",
						Toast.LENGTH_SHORT).show();
			} else if (!util.isOK(editUserName.getText().toString())) {// ��ʱ�û�����ĳ���һ����9�������жϣ��ǲ������ڵĴ�ѧ��
				Toast.makeText(getApplicationContext(),
						"���������ѧ��������Ŷ���������±߲鿴ѧ�Ź���", Toast.LENGTH_SHORT).show();
			} else {// �����⣬��ô˵���û����˺�����ȷ����
				checkPassword();
			}

			break;

		default:
			break;
		}
	}

	protected void checkPassword() {
		// ����˺ź����벻��һ���ģ�����ʾ�û�
		if (!editPassword.getText().toString()
				.equals(editUserName.getText().toString())) {
			Toast.makeText(getApplicationContext(), "��λͬ־��������˺���һ���Ĳ���Ŷ",
					Toast.LENGTH_SHORT).show();
		} else {
			// ����
			checkIsRememberPaw();
			Toast.makeText(getApplicationContext(), "��ϲ����¼�ɹ���Ŷ����",
					Toast.LENGTH_SHORT).show();
			Intent i = new Intent(LoginActivity.this, MainActivity.class);
			startActivity(i);
			finish();
		}
	}

	// ����û�����˱������룬�����뱣�浽prefer��
	private void checkIsRememberPaw() {
		String name = editUserName.getText().toString();
		String password = editPassword.getText().toString();
		SharedPreferences.Editor editor = getSharedPreferences("data",
				MODE_PRIVATE).edit();
		editor.putString("name", name);
		if (isRememberPaw) {
			editor.putString("password", password);
		} else {
			editor.putString("password", "");
		}
		editor.apply();
	}

	private void checkIsSaveNameAndPass() {
		pref = getSharedPreferences("data", MODE_PRIVATE);
		String name = pref.getString("name", "");
		String password = pref.getString("password", "");
		if (!"".equals(password)) {// ������벻�ǿյģ�˵���ϴα��������ˣ����û�����˼�ס�����ˣ���ô���ü�ס����Ϊ��ס��
			rememberPaw.setChecked(true);
			// �±����д���ܹؼ���������д�Ļ����˳���¼���ٴε�¼��ͬ���˺ţ�Ȼ���˳���¼���ٴε�¼�Ļ��������Ǿͻ���գ�
			isRememberPaw = isRemeber();
		}
		editUserName.setText(name);
		editPassword.setText(password);

	}

	private void initView() {
		btn = (Button) findViewById(R.id.btnLogin);
		rule = (TextView) findViewById(R.id.rule);
		editUserName = (EditText) findViewById(R.id.edit_userName);
		editPassword = (EditText) findViewById(R.id.edit_passWord);
		rememberPaw = (CheckBox) findViewById(R.id.cb_rememberPsw);
		tvForgetPwd = (TextView) findViewById(R.id.tvForgetPwd);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// �����Ƿ��ѵ�¼�Ľ��
	public Boolean LoginState() {
		pref = getSharedPreferences("data", MODE_PRIVATE);
		return pref.getBoolean("LoginState", false);
	}

	// �����Ƿ��ѵ�¼�Ľ��
	public Boolean isRemeber() {
		pref = getSharedPreferences("data", MODE_PRIVATE);
		return pref.getBoolean("isRemeber", false);
	}

	// ����ı��ס����Ĳ���ֵ
	public void changeRemeber(boolean b) {
		SharedPreferences.Editor editor = getSharedPreferences("data",
				MODE_PRIVATE).edit();
		editor.putBoolean("isRemeber", b);
		editor.apply();
	}

}
