package ais.co.th.writesecret;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    EditText inputSC;
    Button btnLogin;
    SharedPreferences prefs;
    String secret;
    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputSC = (EditText) findViewById(R.id.input_sc);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogOut = (Button) findViewById(R.id.btn_logout);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secret = inputSC.getEditableText().toString();
                if (!secret.matches("")) {
                    prefs.edit().putString("Secret", secret).apply();
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();

                    returnSecret();
                }
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().putString("Secret", "").apply();

                secret = "";
                inputSC.setText("");
                Toast.makeText(getApplicationContext(), "LogOut Success", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        secret = prefs.getString("Secret", "");

        if (!secret.matches("")) {

            inputSC.setText(secret);

        }else{

        }
    }

    private void returnSecret() {
        secret = prefs.getString("Secret", "");
        if (!secret.matches("")) {
            Intent data = new Intent();
            data.putExtra("Secret", secret);
            setResult(RESULT_OK, data);
            finish();
        }
    }

}
