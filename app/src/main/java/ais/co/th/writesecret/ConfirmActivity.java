package ais.co.th.writesecret;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ConfirmActivity extends ActionBarActivity {
    SharedPreferences prefs;
    String secret;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

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
