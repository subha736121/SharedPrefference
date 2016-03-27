package app.com.android.www.sharedprefference;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText text1,text2;
    TextView text5;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(EditText)findViewById(R.id.editText);
        text2=(EditText)findViewById(R.id.editText2);
        text5=(TextView)findViewById(R.id.textView3);
    }
    public void save(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("My Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",text1.getText().toString());
        editor.putString("pass",text2.getText().toString());
        name=sharedPreferences.getString("name","");
        editor.commit();
        text5.setText(name);//just to check working of SharedPreferences

        Toast.makeText(this,"cradentials saved",Toast.LENGTH_SHORT).show();
    }
    public void next(View view)
    {

        Toast.makeText(this,"next",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,AnotherActivity.class);
        startActivity(intent);

    }
}

