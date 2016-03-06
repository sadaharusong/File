package com.example.files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText edt;
	private Button but;
	private TextView contentvalue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		File file = new File("/mnt/sdcard/test");
//		if (!file.exists()) {
//			try {
//				file.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}else {
//			Toast.makeText(MainActivity.this, "�ļ��Ѵ���", 1000);
//		}
		
//		File file = this.getFilesDir();//���Ŀ¼�ǵ�ǰӦ�ó���Ĭ�ϵ����ݴ洢Ŀ¼
//		Log.i("tag", file.toString());
		
//		File file = this.getCacheDir();//���Ŀ¼�ǵ�ǰӦ�ó���Ĭ�ϵĻ����ļ�Ŀ¼
//		//��һЩ���Ƿǳ���Ҫ���ļ��ڴ˴�����ʹ�á�
//		//����ֻ����ڴ治���ʱ��ϵͳ���Զ���ɾ��APP��cacheĿ¼�����ݡ�
//		Log.i("tag", file.toString());
		
//		File file = this.getDir("file", MODE_PRIVATE);
//		Log.i("info", file.toString());
//		
		//���Եõ��ⲿ�Ĵ洢λ�� ��λ�õ����ݸ����õ�ʹ��ʹһ����
		//���APPж���� �����������Ҳ���Զ������
		//File file = this.getExternalCacheDir();
		//��������߲����������Ĺ��� �������ݷ��� /mnt/sdcard/Android/data/data/<����>
//		ж��֮�����ݽ������Զ������ ���������ν����������
		
		edt = (EditText) findViewById(R.id.editText1);
		but = (Button) findViewById(R.id.write);
		contentvalue = (TextView) findViewById(R.id.contentvalue);
		but.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				WriteFiles(edt.getText().toString());
				contentvalue.setText(ReadFiles());
			}
		});
	}
	
	public void WriteFiles(String content)
	{
		
			FileOutputStream fos = null;
			try {
				fos = openFileOutput("a.txt", MODE_PRIVATE);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fos.write(content.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	public String ReadFiles()
	{
		String content = null;
		FileInputStream fis = null;
		try {
			fis = openFileInput("a.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte []buffer = new byte [1024];
		int len = 0;
		try {
			while ((len= fis.read(buffer))!=-1) {
				baos.write(buffer, 0, len);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		content = baos.toString();
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return content;
	}
}
