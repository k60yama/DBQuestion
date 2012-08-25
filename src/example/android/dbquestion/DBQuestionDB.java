package example.android.dbquestion;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class DBQuestionDB extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		//ActivityクラスのonCreateを実行
		super.onCreate(savedInstanceState);
		
		//レイアウト設定ファイルの指定
		setContentView(R.layout.result_layout);
		
		//DB作成
		DBQuestionHelper helper = new DBQuestionHelper(this);
		
		//該当DBオブジェクト取得
		SQLiteDatabase db = helper.getWritableDatabase();
		
		//インテント取得
		Intent intent = getIntent();
		
		//インテント付加情報取得
		Bundle data = intent.getExtras();
		String[] registry_array = data.getStringArray("DATA"); 
		
		try{	
			//トランザクション制御開始
			db.beginTransaction();
			
			//登録データ設定
			ContentValues val = new ContentValues();
			val.put("name", registry_array[0]);
			val.put("address", registry_array[1]);
			val.put("birthday", registry_array[2] + "月" + registry_array[3] + "日");
			val.put("sex", registry_array[4]);
			val.put("apple_num", registry_array[5]);
			val.put("orange_num", registry_array[6]);
			val.put("peach_num", registry_array[7]);
			
			//データ登録
			db.insert("orderlist", null, val);
			
			//コミット
			db.setTransactionSuccessful();
			
			//トランザクション制御終了
			db.endTransaction();

			//DB閉じる
			db.close();
			
			//メッセージ表示
			Toast.makeText(this, "データを登録しました。", Toast.LENGTH_SHORT).show();
			
		}catch(Exception e){
			//メッセージ表示
			Toast.makeText(this, "データを登録に失敗しました。", Toast.LENGTH_SHORT).show();	
		}
	}
}
