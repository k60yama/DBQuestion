package example.android.dbquestion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBQuestionHelper extends SQLiteOpenHelper {

	//�R���X�g���N�^�̒�`
	public DBQuestionHelper(Context con){
		//�f�[�^�x�[�X�̃I�[�v������
		super(con,"dbquestion",null,1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		//TABLE�쐬
		String sql 
		= "create table orderlist(_id integer primary key autoincrement," +
		  "name text not null," +
		  "address text not null," +
		  "birthday text not null," +
		  "sex text not null," +
		  "apple_num integer default 0," +
		  "orange_num integer default 0," +
		  "peach_num integer default 0)";
		
		//SQL�����s
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

}
