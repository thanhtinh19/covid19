package com.example.covid19;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.example.covid19.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar ac = getSupportActionBar();
        ac.hide();
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        getFragment(Fragment1.newInstance());
    }
    public void getFragment(Fragment fragment){
        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.layout_fragment,fragment).commit();
        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG,"getFragment"+e.getMessage());
        }
    }
}