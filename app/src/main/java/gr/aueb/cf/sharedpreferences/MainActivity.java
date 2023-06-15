package gr.aueb.cf.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nameET;
    private Button sendBtn;
    public static final String SHARED_PREF = "sharedPrefs";
    public static final String SAVED_DATA = "savedName";
    private String name="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = findViewById(R.id.nameET);
        sendBtn = findViewById(R.id.sendBtn);


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        name = sharedPreferences.getString(SAVED_DATA,"");
        nameET.setText(name);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(SAVED_DATA, nameET.getText().toString().trim());
                editor.apply();
            }
        });
    }
}