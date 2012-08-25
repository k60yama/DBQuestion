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
		
		//Activity�N���X��onCreate�����s
		super.onCreate(savedInstanceState);
		
		//���C�A�E�g�ݒ�t�@�C���̎w��
		setContentView(R.layout.result_layout);
		
		//DB�쐬
		DBQuestionHelper helper = new DBQuestionHelper(this);
		
		//�Y��DB�I�u�W�F�N�g�擾
		SQLiteDatabase db = helper.getWritableDatabase();
		
		//�C���e���g�擾
		Intent intent = getIntent();
		
		//�C���e���g�t�����擾
		Bundle data = intent.getExtras();
		String[] registry_array = data.getStringArray("DATA"); 
		
		try{	
			//�g�����U�N�V��������J�n
			db.beginTransaction();
			
			//�o�^�f�[�^�ݒ�
			ContentValues val = new ContentValues();
			val.put("name", registry_array[0]);
			val.put("address", registry_array[1]);
			val.put("birthday", registry_array[2] + "��" + registry_array[3] + "��");
			val.put("sex", registry_array[4]);
			val.put("apple_num", registry_array[5]);
			val.put("orange_num", registry_array[6]);
			val.put("peach_num", registry_array[7]);
			
			//�f�[�^�o�^
			db.insert("orderlist", null, val);
			
			//�R�~�b�g
			db.setTransactionSuccessful();
			
			//�g�����U�N�V��������I��
			db.endTransaction();

			//DB����
			db.close();
			
			//���b�Z�[�W�\��
			Toast.makeText(this, "�f�[�^��o�^���܂����B", Toast.LENGTH_SHORT).show();
			
		}catch(Exception e){
			//���b�Z�[�W�\��
			Toast.makeText(this, "�f�[�^��o�^�Ɏ��s���܂����B", Toast.LENGTH_SHORT).show();	
		}
	}
}
