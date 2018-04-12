package tech.cycjimmy.androidbeginning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 将布局XML文件引入到activity当中
        setContentView(R.layout.activity_main);

        // 测试点击事件
        Button myButton = findViewById(R.id.button);
        ImageButton myImageButton = findViewById(R.id.image_button);
        ImageView myImage = findViewById(R.id.image);

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

        myImage.setOnClickListener(this);

        // 测试 AutoCompleteTextView
        AutoCompleteTextView myAutoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        String[] res = {"beijing", "tianjin", "nanjing", "shanghai", "shanghai2"};    // 数据源
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(    // 适配器
                this,
                android.R.layout.simple_list_item_1,
                res
        );
        myAutoCompleteTextView.setAdapter(arrayAdapter);                 // 绑定适配器

        // 测试 MultiAutoCompleteTextView
        MultiAutoCompleteTextView multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        multiAutoCompleteTextView.setAdapter(arrayAdapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer()); // 设置分隔符: 逗号
    }

    @Override
    public void onClick(View v) {
        Log.i("tag", "Implements onClick function");
    }
}
