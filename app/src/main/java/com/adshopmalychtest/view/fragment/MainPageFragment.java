package com.adshopmalychtest.view.fragment;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adshopmalychtest.App;
import com.adshopmalychtest.R;
import com.adshopmalychtest.databinding.FragmentMainPageBinding;
import com.adshopmalychtest.viewmodel.MainPageVO;

import javax.inject.Inject;

public class MainPageFragment extends Fragment {

    @Inject
    protected MainPageVO mainPageVO;


    public MainPageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
        mainPageVO.onCreate();
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPageVO.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainPageBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_page, container, false);
        binding.setMainVO(mainPageVO);
        return binding.getRoot();
    }

    public static MainPageFragment newInstance() {
        MainPageFragment fragment = new MainPageFragment();
        return fragment;
    }

    public static String tag() {
        return MainPageFragment.class.getName();
    }
}
