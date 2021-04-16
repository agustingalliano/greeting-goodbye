package galliano.android.sectionexcercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    private TextView text;
    private RadioGroup radioGroup;
    private SeekBar sbr;
    private TextView textAge;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private Button btn2;

    private int age;
    private String name;
    public boolean info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        text = (TextView) findViewById(R.id.text2);
        radioGroup = (RadioGroup) findViewById(R.id.radio);
        sbr = (SeekBar) findViewById(R.id.seekbar);
        textAge = (TextView) findViewById(R.id.textAge);
        radioButton1 = (RadioButton) findViewById(R.id.button1);
        radioButton2 = (RadioButton) findViewById(R.id.button2);
        btn2 = (Button) findViewById(R.id.btn2);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("key");
        }

        textAge.setText("Age: " + sbr.getProgress() + "/" + sbr.getMax());
        sbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textAge.setText("Age: " + sbr.getProgress() + "/" + sbr.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                btn2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (sbr.getProgress() >= 16 && sbr.getProgress() <= 60) {
                    btn2.setVisibility(View.VISIBLE);
                } else {
                    btn2.setVisibility(View.GONE);
                    Toast.makeText(SecondActivity.this, "The age must be between 16 and 60 years", Toast.LENGTH_LONG).show();
                }
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info = choose();
                age = sbr.getProgress();
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("key2", info);
                intent.putExtra("key3", name);
                intent.putExtra("key4", age);
                startActivity(intent);
            }
        });


    }

    public boolean choose() {
        return radioButton1.isChecked();
    }
}