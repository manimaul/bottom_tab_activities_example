package io.madrona.bottomnavigationexample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NavigationControllerActivity extends Activity {

    @Override
    protected void onStart() {
        super.onStart();
        SelectedTabController.selectTab(this, SelectedTabController.getSelectedTab());
        finish();
    }
}
