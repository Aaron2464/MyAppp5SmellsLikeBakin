package com.example.aaron.myappp5smellslikebakin;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ViewPagerFragment extends Fragment{

    public static final String KEY_RECIPE_INDEX = "recipe_index";
    public static final String KEY_IS_INGREDIENTS = "key_is_indredients";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);
        Toast.makeText(getActivity(),Recipes.names[index], Toast.LENGTH_SHORT).show();
        View view = inflater.inflate(R.layout.fragment_viewpager,container,false);

        final CheckBoxesFragment ingredientsFragment = new CheckBoxesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX,index);
        bundle.putBoolean(KEY_IS_INGREDIENTS,true);
        ingredientsFragment.setArguments(bundle);
        final CheckBoxesFragment directionsFragment = new CheckBoxesFragment();
        bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX,index);
        bundle.putBoolean(KEY_IS_INGREDIENTS,false);
        directionsFragment.setArguments(bundle);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? ingredientsFragment : directionsFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Ingrediemts" : "Directions";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}