package com.example.aaron.myappp5smellslikebakin;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ViewPagerFragment extends Fragment{

    public static final String KEY_RECIPE_INDEX = "recipe_index";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);
        Toast.makeText(getActivity(),Recipes.names[index], Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_viewpager,container,false);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}