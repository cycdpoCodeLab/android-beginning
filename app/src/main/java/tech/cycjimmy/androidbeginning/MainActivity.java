package tech.cycjimmy.androidbeginning;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private CheckBox checkBox;
    private static final String TAG = "tag";
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: MainActivity");

        // 将布局XML文件引入到activity当中
        setContentView(R.layout.activity_main);

        // 测试点击事件
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        ImageButton imageButton = findViewById(R.id.image_button);
        imageView = findViewById(R.id.image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked Button!");
                // 无返回结果的页面跳转
                Intent intent = new Intent(context, SecondActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 有返回结果的页面跳转
                Intent intent = new Intent(context, ThirdActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        imageButton.setOnClickListener(new MyOnClickListener() {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Toast.makeText(MainActivity.this, "imageButtonClick", Toast.LENGTH_SHORT).show();
            }
        });

        imageView.setOnClickListener(this);

        // toggleButton
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
        });

        // CheckBox
        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i(TAG, isChecked + "");

                if (isChecked) {
                    String text = checkBox.getText().toString();
                    Log.i(TAG, "onCheckedChanged: " + text);
                }
            }
        });

        // RadioGroup & RadioButton
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:
                        Log.i(TAG, "Radio1");
                        break;

                    case R.id.radio2:
                        Log.i(TAG, "Radio2");
                        break;
                }
            }
        });


        // AutoCompleteTextView
        AutoCompleteTextView myAutoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        String[] res = {"beijing", "tianjin", "nanjing", "shanghai", "shanghai2"};    // 数据源
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(    // 适配器
                this,
                android.R.layout.simple_list_item_1,
                res
        );
        myAutoCompleteTextView.setAdapter(arrayAdapter);                 // 绑定适配器

        // MultiAutoCompleteTextView
        MultiAutoCompleteTextView multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        multiAutoCompleteTextView.setAdapter(arrayAdapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer()); // 设置分隔符: 逗号
    }

    /**
     * 通过startActivityForResult跳转，接收返回数据的方法
     *
     * @param requestCode 请求的标识
     * @param resultCode  跳转页面返回的标识
     * @param data        跳转页面回传的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == 2) {
            String content = data.getStringExtra("data");

            TextView textView = findViewById(R.id.textView);
            textView.setText(content);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: MainActivity");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i(TAG, "onPostResume: MainActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: MainActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: MainActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: MainActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: MainActivity");
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG, "Implements onClick function");
    }
}
