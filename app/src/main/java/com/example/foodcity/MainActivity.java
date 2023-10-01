package com.example.foodcity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup_city;
    private RadioButton radioBtn_Taipei, radioBtn_NewTaipei, radioBtn_Taoyan;
    private Button btn_Select, btn_Cancel;
    private CheckBox checkBox_food1, checkBox_food2, checkBox_food3, checkBox_food4;
    private TextView txtReselt;

    private int mainFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup_city = findViewById(R.id.RedioGroup_city);

        btn_Select = findViewById(R.id.btn_select);
        btn_Cancel = findViewById(R.id.btn_Cancel);

        checkBox_food1 = findViewById(R.id.check_Button_food1);
        checkBox_food2 = findViewById(R.id.check_Button_food2);
        checkBox_food3 = findViewById(R.id.check_Button_food3);
        checkBox_food4 = findViewById(R.id.check_Button_food4);

        txtReselt = findViewById(R.id.ShowResult);
        mainFlag = 1;

        radioGroup_city.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                checkBox_food1.setChecked(false);
                checkBox_food2.setChecked(false);
                checkBox_food3.setChecked(false);
                checkBox_food4.setChecked(false);

                switch (checkedId) {
                    case R.id.radiobtn_NewTaipei:
                        mainFlag = 1;
                        checkBox_food1.setVisibility(View.VISIBLE);
                        checkBox_food1.setText("芋頭冰");
                        checkBox_food1.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.af1, 0);
                        checkBox_food2.setVisibility(View.VISIBLE);
                        checkBox_food2.setText("烤玉米");
                        checkBox_food2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.af2, 0);
                        checkBox_food3.setVisibility(View.VISIBLE);
                        checkBox_food3.setText("淡水鐵蛋");
                        checkBox_food3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.af3, 0);
                        checkBox_food4.setVisibility(View.VISIBLE);
                        checkBox_food4.setText("小籠湯包");
                        checkBox_food4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.af4, 0);


                        break;

                    case R.id.radioBtn_Taipei:
                        mainFlag = 2;
                        checkBox_food1.setVisibility(View.VISIBLE);
                        checkBox_food2.setVisibility(View.VISIBLE);
                        checkBox_food3.setVisibility(View.VISIBLE);
                        checkBox_food4.setVisibility(View.VISIBLE);
                        checkBox_food1.setText("臭豆腐");
                        checkBox_food1.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.bf1, 0);
                        checkBox_food2.setText("滷肉飯");
                        checkBox_food2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.bf2, 0);
                        checkBox_food3.setText("涼麵");
                        checkBox_food3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.bf3, 0);
                        checkBox_food4.setText("烏龍茶");
                        checkBox_food4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.bf4, 0);


                        break;

                    case R.id.radiobtn_Taoyan:
                        mainFlag = 3;
                        checkBox_food1.setVisibility(View.VISIBLE);
                        checkBox_food2.setVisibility(View.VISIBLE);
                        checkBox_food3.setVisibility(View.VISIBLE);
                        checkBox_food4.setVisibility(View.VISIBLE);
                        checkBox_food1.setText("蛋黃酥");
                        checkBox_food1.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.cf1, 0);
                        checkBox_food2.setText("客家菜包");
                        checkBox_food2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.cf2, 0);
                        checkBox_food3.setText("養生饅頭");
                        checkBox_food3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.cf3, 0);
                        checkBox_food4.setText("斜坡粉漿蛋餅");
                        checkBox_food4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.cf4, 0);


                        break;

                }
            }
        });

        btn_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb_result = new StringBuilder();
                if (mainFlag == 1) {
                    sb_result.append("城市名稱: 新北市\n");
                    Log.v("lee", "mainFlag: " + mainFlag);

                } else if (mainFlag == 2) {
                    sb_result.append("城市名稱: 台北市\n");
                    Log.v("lee", "mainFlag: " + mainFlag);
                } else if (mainFlag == 3) {
                    sb_result.append("城市名稱: 桃園市\n");
                    Log.v("lee", "mainFlag: " + mainFlag);
                }

                sb_result.append("美食名稱: ");
                if (checkBox_food1.isChecked()) {
                    sb_result.append(checkBox_food1.getText().toString() + ",");
                }
                if (checkBox_food2.isChecked()) {
                    sb_result.append(checkBox_food2.getText().toString() + ",");
                }
                if (checkBox_food3.isChecked()) {
                    sb_result.append(checkBox_food3.getText().toString() + ",");
                }
                if (checkBox_food4.isChecked()) {
                    sb_result.append(checkBox_food4.getText().toString() + ",");
                }

                if (sb_result.length() > 0 && sb_result.charAt(sb_result.length() - 1) == ',') {
                    sb_result.deleteCharAt(sb_result.length() - 1); // 删除最后一个逗号
                }
                Log.v("lee", "sb_result: " + sb_result);
                txtReselt.setText(sb_result.toString());

            }

        });

        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup_city.clearCheck();
                checkBox_food1.setVisibility(View.INVISIBLE);
                checkBox_food2.setVisibility(View.INVISIBLE);
                checkBox_food3.setVisibility(View.INVISIBLE);
                checkBox_food4.setVisibility(View.INVISIBLE);

                txtReselt.setText("");

            }
        });
    }
}