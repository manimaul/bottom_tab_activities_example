package io.madrona.bottomnavigationexample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import io.madrona.bottomnavigationexample.databinding.BottomTabsFragmentBinding;

public class BottomTabsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BottomTabsFragmentBinding viewBinding = BottomTabsFragmentBinding.inflate(inflater, container, false);
        viewBinding.navigation.findViewById(SelectedTabController.getSelectedTabMenuId()).callOnClick();
        viewBinding.navigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        return viewBinding.getRoot();
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        SelectedTabController.SelectedTab tabToSelect = SelectedTabController.tabWithMenuId(item.getItemId());
        SelectedTabController.selectTab(getActivity(), tabToSelect);
        // don't update the selection since each tab activity has it's own instance of this
        return false;
    }
}
