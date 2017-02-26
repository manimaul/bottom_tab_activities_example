package io.madrona.bottomnavigationexample.circle;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.madrona.bottomnavigationexample.R;
import io.madrona.bottomnavigationexample.databinding.SomeFragmentBinding;

public class SomeFragment extends Fragment {

    private static final String KEY_NUMBER = "KEY_NUMBER";

    private int number = 0;

    static SomeFragment create(int number) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NUMBER, number);
        SomeFragment fragment = new SomeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        number = getArguments().getInt(KEY_NUMBER);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SomeFragmentBinding viewBinding = SomeFragmentBinding.inflate(inflater, container, false);
        viewBinding.text.setText(getString(R.string.some_fragment, number));
        viewBinding.next.setOnClickListener(this::onNextClick);
        return viewBinding.getRoot();
    }

    private void onNextClick(View view) {
        getActivity()
                .getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, SomeFragment.create(number + 1))
                .addToBackStack(null)
                .commit();
    }

}
