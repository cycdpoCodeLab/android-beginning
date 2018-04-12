package tech.cycjimmy.androidbeginning;

import android.util.Log;
import android.view.View;

class MyOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Log.i("tag", "Parent onClick function");
    }
}
