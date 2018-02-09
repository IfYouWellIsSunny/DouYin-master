package com.liqy.douyin.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liqy.douyin.R;
import com.liqy.douyin.search.SearchActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.xn)
    ImageView xn;
    Unbinder unbinder;

    private String mParam1;
    private String mParam2;


    @BindView(R.id.tv_recommend)
    TextView tv_recommend;

    @BindView(R.id.tv_nearby)
    TextView tv_nearby;

    @BindView(R.id.view_pager)
    VerticalViewPager viewPager;

    PagerAdapter pagerAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void initView(View view) {
        ButterKnife.bind(this, view);
        //TODO
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        pagerAdapter = new PagerAdapter(list);
        viewPager.setAdapter(pagerAdapter);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_recommend) {

        } else if (v.getId() == R.id.tv_nearby) {

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.xn)
    public void onViewClicked() {

        startActivity(new Intent(getContext(), SearchActivity.class));

    }


}
