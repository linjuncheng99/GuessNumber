package com.linjuncheng.android_guess_number;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game();
    }

    private void game() {
        final EditText editText = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textView);
        editText.setText("");
        textView.setText("数字未输入！");
        Random random = new Random();
        // 生成1-100的随机数
        final int number = random.nextInt(100) + 1;
        // 获取输入的数字
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int guessNumber = Integer.parseInt(editText.getText().toString());
                // 两者进行判断
                if (guessNumber < number) {
                    textView.setText("Smaller！");
                } else if (guessNumber > number){
                    textView.setText("Bigger！");
                } else {
                    textView.setText("You got it ！");
                    confirm();
                }
            }
        });
    }

    private void confirm() {
        new AlertDialog.Builder(this).setTitle("You got it! Continue Game?")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("CONTINUE GAME", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“继续游戏”后的操作,继续游戏
                        game();
                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“确认”后的操作
                        MainActivity.this.finish();
                    }
                }).show();
    }
}
