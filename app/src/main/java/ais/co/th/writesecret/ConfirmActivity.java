package ais.co.th.writesecret;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ConfirmActivity extends ActionBarActivity {
    SharedPreferences prefs;
    String secret;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        btnOK = (Button) findViewById(R.id.btn_ok);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        secret = prefs.getString("Secret", "");
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnSecret();
            }
        });

        if(secret.matches("")) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivityForResult(intent, 100);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (100 == requestCode) {
            if (resultCode == RESULT_OK) {
                returnSecret();
            }
        }
    }
}
