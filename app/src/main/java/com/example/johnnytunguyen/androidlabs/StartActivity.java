package com.example.johnnytunguyen.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.johnnytunguyen.androidlabs.LoginActivity.ACTIVITY_NAME;

public class StartActivity extends Activity {
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);


                int REQUEST_CODE = 50;
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }// end in on create



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 50) {
            String messagePassed = data.getStringExtra("Response")+" ListItemsActivity passed: My information to share";
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
            Toast.makeText(this,messagePassed,
                        Toast.LENGTH_LONG).show();
        }
    }

}
