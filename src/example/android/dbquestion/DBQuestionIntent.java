package example.android.dbquestion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DBQuestionIntent extends Activity implements OnClickListener{

	//�\���p�z��
	private static String[] array_view;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		//Activity�N���X��onCreate���s
		super.onCreate(savedInstanceState);
		
		//���C�A�E�g�ݒ�t�@�C���w��
		setContentView(R.layout.confirm_layout);
		
		//�C���e���g�擾
		Intent intent = getIntent();
		
		//�C���e���g�̕t�����擾
		Bundle data = intent.getExtras();
		array_view = data.getStringArray("DATA");
		
		//���O�I�u�W�F�N�g�擾(�\���p)
		TextView name = (TextView)findViewById(R.id.name);
		name.setText(array_view[0]);
		
		//�Z���I�u�W�F�N�g�擾(�\���p)
		TextView address = (TextView)findViewById(R.id.address);
		address.setText(array_view[1]);
		
		//���I�u�W�F�N�g�擾(�\���p)
		TextView month = (TextView)findViewById(R.id.month);
		month.setText(array_view[2]);
		
		//���I�u�W�F�N�g�擾(�\���p)
		TextView day = (TextView)findViewById(R.id.day);
		day.setText(array_view[3]);
		
		//���ʃI�u�W�F�N�g�擾(�\���p)
		TextView sex = (TextView)findViewById(R.id.sex);
		sex.setText(array_view[4]);

		//��񂲃I�u�W�F�N�g�擾(�\���p)
		TextView apple_view = (TextView)findViewById(R.id.apple_num);
		apple_view.setText(array_view[5]);
		
		//�݂���I�u�W�F�N�g�擾(�\���p)
		TextView orange_view = (TextView)findViewById(R.id.orange_num);
		orange_view.setText(array_view[6]);
		
		//�����I�u�W�F�N�g�擾(�\���p)
		TextView peach_view = (TextView)findViewById(R.id.peach_num);
		peach_view.setText(array_view[7]);		
		
		//Button�I�u�W�F�N�g�擾
		Button confirm = (Button)findViewById(R.id.confirm);
		Button back = (Button)findViewById(R.id.back);
		
		//Button�I�u�W�F�N�g�ɃN���b�N���X�i�[�ݒ�
		confirm.setOnClickListener(this);
		back.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		
		//�����ʏ���
		switch(view.getId()){
		case R.id.confirm:
			
			//�C���e���g����
			Intent intent = new Intent(this,DBQuestionDB.class);
			
			//�C���e���g�t�����ݒ�
			intent.putExtra("DATA", array_view);
			
			//�A�N�e�B�r�e�B���s
			startActivity(intent);
			break;
		case R.id.back:
			
			//�A�N�e�B�r�e�B�I��
			finish();
			break;
		}
	}
}
