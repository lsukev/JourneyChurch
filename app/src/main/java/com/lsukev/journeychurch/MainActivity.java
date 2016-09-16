package com.lsukev.journeychurch;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private ImageButton btnFacebook;
    private ImageButton btnMail;
    private ImageButton btnTwitter;
    private ImageButton btnConnect;
    private ImageButton btnGrow;
    private ImageButton btnServe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFacebook = (ImageButton) findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(this);
        btnMail = (ImageButton) findViewById(R.id.btnMail);
        btnMail.setOnClickListener(this);
        btnTwitter = (ImageButton) findViewById(R.id.btnTwitter);
        btnTwitter.setOnClickListener(this);
        btnConnect = (ImageButton) findViewById(R.id.btnConnect);
        btnConnect.setOnClickListener(this);
        btnGrow = (ImageButton)findViewById(R.id.btnGrow);
        btnGrow.setOnClickListener(this);
        btnServe = (ImageButton)findViewById(R.id.btnServe);
        btnServe.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnFacebook:
//                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
//                String facebookUrl = getFacebookPageURL(this);
//                facebookIntent.setData(Uri.parse(facebookUrl));
//                startActivity(facebookIntent);
                openSocialMedia("com.facebook.katana","fb://facewebmodal/f?href=https://www.facebook.com/takethejourney","https://www.facebook.com/takethejourney");
                break;
            case R.id.btnMail:
                openSocialMedia("com.instagram.android", "http://instagram.com/_u/takethejourney/", "http://instagram.com/_u/takethejourney/");
                break;
            case R.id.btnTwitter:
                openSocialMedia("com.twitter.android","twitter://user?user_id=142753063","https://twitter.com/JourneyChurchLA");
                break;
            case R.id.btnConnect:
                startActivity(new Intent(MainActivity.this, CGSActivity.class));
                break;
            case R.id.btnGrow:
                startActivity(new Intent(MainActivity.this, CGSActivity.class));
                break;
            case R.id.btnServe:
                startActivity(new Intent(MainActivity.this, CGSActivity.class));
                break;
        }
    }

    public void openSocialMedia(String packageName, String smUrl, String smWebUrl){
        Intent intent = null;
        try{
            this.getPackageManager().getPackageInfo(packageName, 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(smUrl));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }catch (Exception e){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(smWebUrl));
        }
        this.startActivity(intent);
    }

//public static String FACEBOOK_URL = "https://www.facebook.com/takethejourney";
//    public static String FACEBOOK_PAGE_ID = "takethejourney";
//
//    //method to get the right URL to use in the intent
//    public String getFacebookPageURL(Context context) {
//        PackageManager packageManager = context.getPackageManager();
//        try {
//            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
//            if (versionCode >= 3002850) { //newer versions of fb app
//                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
//            } else { //older versions of fb app
//                return "fb://page/" + FACEBOOK_PAGE_ID;
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//            return FACEBOOK_URL; //normal web url
//        }
//    }
}
