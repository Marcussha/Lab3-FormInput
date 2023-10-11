package com.example.forminputexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem i = menu.findItem(R.id.itemNext);
        i .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent i = new Intent(getApplicationContext(),HelloListActivity.class);
                startActivity(i);
                return false;
            }
        });
        return super .onCreateOptionsMenu(menu);
    }

    public void handleButtonClick(View v){
        CheckBox cb = (CheckBox)findViewById(R.id.Box);
        if (!cb.isChecked()){
            Toast t = Toast.makeText(this,"You must agree to the term", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        else {
            displayAlert();
            Intent i = new Intent(this,MainActivity2.class);
            startActivity(i);
        }
    }
    public void displayAlert(){
        EditText eName = (EditText) findViewById(R.id.TextText1);
        String name = eName.getText().toString();
        EditText eEMail = (EditText) findViewById(R.id.TextText3);
        String email = eEMail.getText().toString();
        EditText ePhone = (EditText) findViewById(R.id.TextText2);
        String phone = ePhone.getText().toString();
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup3);
        RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
        String workStatus = rb.getText().toString();
        new AlertDialog.Builder(this)
                .setTitle("Details entered")
                .setMessage("Details entered: \n"
                    + name + "\n"
                    + email + "\n"
                    + phone + "\n"
                    +workStatus + "\n"
                ).setNeutralButton("Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick (DialogInterface dialogInterface, int i){

                        }
                }).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lab3 part2", "onStart event call");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lab3 part2", "onReStart event call");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lab3 part2", "onResume event call");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lab3 part2", "onPause event call");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lab3 part2", "onStop event call");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lab3 part2", "onDestroy event call");
    }
}