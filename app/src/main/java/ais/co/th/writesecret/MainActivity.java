package ais.co.th.writesecret;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    EditText inputSC;
    Button btnSave;
    SharedPreferences prefs;
    String secret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputSC = (EditText) findViewById(R.id.input_sc);
        btnSave = (Button) findViewById(R.id.btn_save);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secret = inputSC.getEditableText().toString();
                if (!secret.matches("")) {
                    prefs.edit().putString("Secret", secret).apply();
                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
                    returnSecret();
                }
            }
        });
        secret = prefs.getString("Secret", "");
        if (!secret.matches("")) {
            returnSecret();
        }
    }

    private void returnSecret() {
        if (!secret.matches("")) {
            Intent data = new Intent();
            data.putExtra("Secret", secret);
            setResult(RESULT_OK, data);
            finish();
        }
    }

}
