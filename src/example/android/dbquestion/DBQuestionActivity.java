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
	
	//インテント付加情報用配列初期化
	private static String[] input_array;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	//ActivityクラスのonCreateを実行
        super.onCreate(savedInstanceState);
        
        //レイアウト設定ファイルの指定
        setContentView(R.layout.apply_layout);
        
        //Buttonオブジェクト取得
        Button send = (Button)findViewById(R.id.send);
        
        //Buttonオブジェクトにクリックリスナーを設定
        send.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View view){
    	
    	//名前オブジェクト取得
    	String name = "※未入力";
    	EditText name_obj = (EditText)findViewById(R.id.name);
    	if(!(name_obj.getText().toString().equals(""))){
    		name =  name_obj.getText().toString();
    	}
    	
    	//住所オブジェクト取得
    	String address = "※未入力";
    	EditText address_obj = (EditText)findViewById(R.id.address);
    	if(!(address_obj.getText().toString().equals(""))){
    		address = address_obj.getText().toString();
    	}
    	
    	//月オブジェクト取得
    	Spinner month_obj = (Spinner)findViewById(R.id.month);
    	
    	//日オブジェクト取得
    	Spinner day_obj = (Spinner)findViewById(R.id.day);
    	
    	//性別オブジェクト取得
    	String sex = "※未選択";
    	RadioGroup sex_group = (RadioGroup)findViewById(R.id.sexgroup);
    	if(sex_group.getCheckedRadioButtonId() != -1){
    		RadioButton sex_obj = (RadioButton)findViewById(sex_group.getCheckedRadioButtonId());
    		sex = sex_obj.getText().toString(); 
    	}
    	
    	//りんごオブジェクト取得
    	String apple_num = "0";
    	CheckBox apple_chk = (CheckBox)findViewById(R.id.apple_chk);
    	if(apple_chk.isChecked()){
    		EditText apple_obj = (EditText)findViewById(R.id.apple_num);
    		apple_num = apple_obj.getText().toString();
    	}
    	
    	//みかんオブジェクト取得
    	String orange_num = "0";
    	CheckBox orange_chk = (CheckBox)findViewById(R.id.orange_chk);
    	if(orange_chk.isChecked()){
    		EditText orange_obj = (EditText)findViewById(R.id.orange_num);
    		orange_num = orange_obj.getText().toString();
    	}
    	
    	//ももオブジェクト取得
    	String peach_num = "0";
    	CheckBox peach_chk = (CheckBox)findViewById(R.id.peach_chk);
    	if(peach_chk.isChecked()){
    		EditText peach_obj = (EditText)findViewById(R.id.peach_num);
    		peach_num = peach_obj.getText().toString();
    	}
    	
    	//インテント付加情報用配列設定
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
    	
    	//インテント生成
    	Intent intent = new Intent(this,DBQuestionIntent.class);
    	
    	//インテント付加情報設定
    	intent.putExtra("DATA", input_array);
    	
    	//アクティビティ実行
    	startActivity(intent);
    }
    
}