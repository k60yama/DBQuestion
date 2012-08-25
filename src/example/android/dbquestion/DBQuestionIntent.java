package example.android.dbquestion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DBQuestionIntent extends Activity implements OnClickListener{

	//表示用配列
	private static String[] array_view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		//ActivityクラスのonCreate実行
		super.onCreate(savedInstanceState);
		
		//レイアウト設定ファイル指定
		setContentView(R.layout.confirm_layout);
		
		//インテント取得
		Intent intent = getIntent();
		
		//インテントの付加情報取得
		Bundle data = intent.getExtras();
		array_view = data.getStringArray("DATA");
		
		//名前オブジェクト取得(表示用)
		TextView name = (TextView)findViewById(R.id.name);
		name.setText(array_view[0]);
		
		//住所オブジェクト取得(表示用)
		TextView address = (TextView)findViewById(R.id.address);
		address.setText(array_view[1]);
		
		//月オブジェクト取得(表示用)
		TextView month = (TextView)findViewById(R.id.month);
		month.setText(array_view[2]);
		
		//日オブジェクト取得(表示用)
		TextView day = (TextView)findViewById(R.id.day);
		day.setText(array_view[3]);
		
		//性別オブジェクト取得(表示用)
		TextView sex = (TextView)findViewById(R.id.sex);
		sex.setText(array_view[4]);

		//りんごオブジェクト取得(表示用)
		TextView apple_view = (TextView)findViewById(R.id.apple_num);
		apple_view.setText(array_view[5]);
		
		//みかんオブジェクト取得(表示用)
		TextView orange_view = (TextView)findViewById(R.id.orange_num);
		orange_view.setText(array_view[6]);
		
		//ももオブジェクト取得(表示用)
		TextView peach_view = (TextView)findViewById(R.id.peach_num);
		peach_view.setText(array_view[7]);		
		
		//Buttonオブジェクト取得
		Button confirm = (Button)findViewById(R.id.confirm);
		Button back = (Button)findViewById(R.id.back);
		
		//Buttonオブジェクトにクリックリスナー設定
		confirm.setOnClickListener(this);
		back.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		
		//押下別処理
		switch(view.getId()){
		case R.id.confirm:
			
			//インテント生成
			Intent intent = new Intent(this,DBQuestionDB.class);
			
			//インテント付加情報設定
			intent.putExtra("DATA", array_view);
			
			//アクティビティ実行
			startActivity(intent);
			break;
		case R.id.back:
			
			//アクティビティ終了
			finish();
			break;
		}
	}
}
