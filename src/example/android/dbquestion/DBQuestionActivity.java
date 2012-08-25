package example.android.dbquestion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.view.View.OnClickListener;
import android.view.View;

public class DBQuestionActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	
	//�C���e���g�t�����p�z�񏉊���
	private static String[] input_array;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	//Activity�N���X��onCreate�����s
        super.onCreate(savedInstanceState);
        
        //���C�A�E�g�ݒ�t�@�C���̎w��
        setContentView(R.layout.apply_layout);
        
        //Button�I�u�W�F�N�g�擾
        Button send = (Button)findViewById(R.id.send);
        
        //Button�I�u�W�F�N�g�ɃN���b�N���X�i�[��ݒ�
        send.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View view){
    	
    	//���O�I�u�W�F�N�g�擾
    	String name = "��������";
    	EditText name_obj = (EditText)findViewById(R.id.name);
    	if(!(name_obj.getText().toString().equals(""))){
    		name =  name_obj.getText().toString();
    	}
    	
    	//�Z���I�u�W�F�N�g�擾
    	String address = "��������";
    	EditText address_obj = (EditText)findViewById(R.id.address);
    	if(!(address_obj.getText().toString().equals(""))){
    		address = address_obj.getText().toString();
    	}
    	
    	//���I�u�W�F�N�g�擾
    	Spinner month_obj = (Spinner)findViewById(R.id.month);
    	
    	//���I�u�W�F�N�g�擾
    	Spinner day_obj = (Spinner)findViewById(R.id.day);
    	
    	//���ʃI�u�W�F�N�g�擾
    	String sex = "�����I��";
    	RadioGroup sex_group = (RadioGroup)findViewById(R.id.sexgroup);
    	if(sex_group.getCheckedRadioButtonId() != -1){
    		RadioButton sex_obj = (RadioButton)findViewById(sex_group.getCheckedRadioButtonId());
    		sex = sex_obj.getText().toString(); 
    	}
    	
    	//��񂲃I�u�W�F�N�g�擾
    	String apple_num = "0";
    	CheckBox apple_chk = (CheckBox)findViewById(R.id.apple_chk);
    	if(apple_chk.isChecked()){
    		EditText apple_obj = (EditText)findViewById(R.id.apple_num);
    		apple_num = apple_obj.getText().toString();
    	}
    	
    	//�݂���I�u�W�F�N�g�擾
    	String orange_num = "0";
    	CheckBox orange_chk = (CheckBox)findViewById(R.id.orange_chk);
    	if(orange_chk.isChecked()){
    		EditText orange_obj = (EditText)findViewById(R.id.orange_num);
    		orange_num = orange_obj.getText().toString();
    	}
    	
    	//�����I�u�W�F�N�g�擾
    	String peach_num = "0";
    	CheckBox peach_chk = (CheckBox)findViewById(R.id.peach_chk);
    	if(peach_chk.isChecked()){
    		EditText peach_obj = (EditText)findViewById(R.id.peach_num);
    		peach_num = peach_obj.getText().toString();
    	}
    	
    	//�C���e���g�t�����p�z��ݒ�
    	input_array = new String[]{
    		name,
    		address,
    		month_obj.getSelectedItem().toString(),
    		day_obj.getSelectedItem().toString(),
    		sex,
    		apple_num,
    		orange_num,
    		peach_num
    	};
    	
    	//�C���e���g����
    	Intent intent = new Intent(this,DBQuestionIntent.class);
    	
    	//�C���e���g�t�����ݒ�
    	intent.putExtra("DATA", input_array);
    	
    	//�A�N�e�B�r�e�B���s
    	startActivity(intent);
    }
    
}