package com.lsukev.journeychurch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class CGSActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgs);
    }
    protected boolean useDrawerToggle(){
        return false;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.action_give)
            return true;
        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }
}
