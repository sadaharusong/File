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
//			Toast.makeText(MainActivity.this, "文件已存在", 1000);
//		}
		
//		File file = this.getFilesDir();//这个目录是当前应用程序默认的数据存储目录
//		Log.i("tag", file.toString());
		
//		File file = this.getCacheDir();//这个目录是当前应用程序默认的缓存文件目录
//		//把一些不是非常重要的文件在此处创建使用。
//		//如果手机的内存不足的时候，系统会自动出删除APP的cache目录的数据。
//		Log.i("tag", file.toString());
		
//		File file = this.getDir("file", MODE_PRIVATE);
//		Log.i("info", file.toString());
//		
		//可以得到外部的存储位置 该位置的数据跟内置的使用使一样的
		//如果APP卸载了 这里面的数据也会自动清楚掉
		//File file = this.getExternalCacheDir();
		//如果开发者不遵守这样的规则 不把数据放入 /mnt/sdcard/Android/data/data/<包名>
//		卸载之后数据将不会自动清除掉 将会造成所谓的数据垃圾
		
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
