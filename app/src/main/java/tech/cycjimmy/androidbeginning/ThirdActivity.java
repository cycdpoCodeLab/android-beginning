package tech.cycjimmy.androidbeginning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // 给mainActivity回传数据
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ThirdActivity button");
                Intent data = new Intent();
                data.putExtra("data", "Hello!");
                setResult(2, data);

                // 结束当前页面
                finish();
            }
        });
    }
}
