package galliano.android.sectionexcercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class ThirdActivity extends AppCompatActivity {

    private Button btn3;
    private Button btnShare;
    private String finalName;
    private boolean action;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        btn3 = (Button) findViewById(R.id.btnInfo);
        btnShare = (Button) findViewById(R.id.btnShare);
        btnShare.setVisibility(GONE);

        Bundle bundle = getIntent().getExtras();
        if(bundle!= null) {
            action = bundle.getBoolean("key2");
            finalName = bundle.getString("key3");
            age = bundle.getInt("key4");
        }

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this,createMessage(finalName,age,action),Toast.LENGTH_LONG).show();
                btn3.setVisibility(GONE);
                btnShare.setVisibility(VISIBLE);
            }
        });
        
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT,createMessage(finalName,age,action));
                startActivity(Intent.createChooser(share, "Title of the dialog the system will open"));

            }
        });
    }

    private String createMessage(String name, int age, boolean action){
        if(action){
            return "Hola "+finalName+",¿Como llevas esos " +age+" años?";
        }
        else{
            return "Espero verte pronto "+finalName+", antes que cumplas " +(age+1);
        }
    }
}

