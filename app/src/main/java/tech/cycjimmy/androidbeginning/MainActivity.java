package tech.cycjimmy.androidbeginning;

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
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 将布局XML文件引入到activity当中
        setContentView(R.layout.activity_main);

        // 测试点击事件
        Button myButton = findViewById(R.id.button);
        ImageButton myImageButton = findViewById(R.id.image_button);
        imageView = findViewById(R.id.image);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicked Button!");
            }
        });

        myImageButton.setOnClickListener(new MyOnClickListener() {
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
                Log.i("tag", isChecked + "");

                if (isChecked) {
                    String text = checkBox.getText().toString();
                    Log.i("tag", "onCheckedChanged: " + text);
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
                        Log.i("tag", "Radio1");
                        break;

                    case R.id.radio2:
                        Log.i("tag", "Radio2");
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

    @Override
    public void onClick(View v) {
        Log.i("tag", "Implements onClick function");
    }
}
