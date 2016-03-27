package app.com.android.www.sharedprefference;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {
  TextView text3,text4;
    String name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("hello", "another started-on create");
        setContentView(R.layout.activity_another);
        text3=(TextView)findViewById(R.id.editText3);
        text4=(TextView)findViewById(R.id.editText2);
    }
    public void load(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("My Data", Context.MODE_PRIVATE);
        name=sharedPreferences.getString("name","");
        pass=sharedPreferences.getString("pass","");
        if(name.equals("")||pass.equals(""))
        {
            Toast.makeText(this, "Blank Cradentials-Go bback and enter crediantials", Toast.LENGTH_SHORT).show();
        }
        else
        {
            text3.setText(name);
            text4.setText(pass);
        }

    }
    public void previous(View view)
    {
        Toast.makeText(this, "display", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
