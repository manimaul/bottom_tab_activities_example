package io.madrona.bottomnavigationexample.triangle;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.madrona.bottomnavigationexample.R;
import io.madrona.bottomnavigationexample.databinding.BottomTabbedActivityBinding;

public class TriangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BottomTabbedActivityBinding viewBinding =  DataBindingUtil.setContentView(this,
                R.layout.bottom_tabbed_activity);
    }
}
