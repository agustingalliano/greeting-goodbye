package galliano.android.sectionexcercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText UserName;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_myicon);

        UserName = (EditText) findViewById(R.id.UserName);
        btn = (Button) findViewById(R.id.btnMain);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String INFO = UserName.getText().toString();
                if (INFO.equals("Username")||INFO.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Complete with Username!", Toast.LENGTH_LONG).show();
                }else{
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtra("key", INFO);
                    startActivity(i);
                }
            }
        });

    }
}