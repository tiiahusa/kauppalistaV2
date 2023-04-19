package com.example.kauppalistav2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class FragmentGroceryList extends Fragment {

    View v;
    ArrayList<Grocery> list;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    public FragmentGroceryList() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_grocerylist, container, false);

        recyclerView = v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); // set it linearlayoutmanager

        list = GroceryList.getInstance().getGroceries(); // Create list or get created one
        adapter = new ListAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshAdapter();
    }

    public void refreshAdapter(){
        adapter.notifyDataSetChanged();
    }
}
