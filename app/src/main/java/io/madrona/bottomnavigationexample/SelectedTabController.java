package io.madrona.bottomnavigationexample;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

import io.madrona.bottomnavigationexample.circle.CircleActivity;
import io.madrona.bottomnavigationexample.square.SquareActivity;
import io.madrona.bottomnavigationexample.triangle.TriangleActivity;

class SelectedTabController {

    private static SelectedTab selectedTab = SelectedTab.CIRCLE;

    enum SelectedTab {
        NONE(null, 0),
        CIRCLE(CircleActivity.class, R.id.action_circle_activity),
        TRIANGLE(TriangleActivity.class, R.id.action_triangle_activity),
        SQUARE(SquareActivity.class, R.id.action_square_activity);

        @Nullable
        private Class<? extends Activity> activityClass;

        @IdRes
        private int menuId;

        SelectedTab(@Nullable Class<? extends Activity> activityClass, int menuId) {
            this.activityClass = activityClass;
            this.menuId = menuId;
        }

    }

    static SelectedTab tabWithMenuId(int menuId) {
        for (SelectedTab tab : SelectedTab.values()) {
            if (tab.menuId == menuId) {
                return tab;
            }
        }
        return SelectedTab.NONE;
    }

    static void selectTab(Activity activity, SelectedTab tab) {
        if (tab.activityClass != null) {
            Intent intent = new Intent(activity, tab.activityClass);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            activity.startActivity(intent);
            selectedTab = tab;
        }
    }

    static SelectedTab getSelectedTab() {
        return selectedTab;
    }

    @IdRes
    static int getSelectedTabMenuId() {
        return selectedTab.menuId;
    }

}
