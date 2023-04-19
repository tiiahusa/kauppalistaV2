package com.example.kauppalistav2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FragmentMain extends Fragment {

    View v;
    TextView lblTitle;
    ArrayList<Grocery> groceries = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_mainpage, container, false);

        lblTitle = v.findViewById(R.id.lblMain);
        lblTitle.setText("Listan ostosten määrä: " + GroceryList.getInstance().getGroceries().size());
        return v;

    }

    @Override
    public void onResume() {
        super.onResume();
        refreshCount();
    }

    public void refreshCount() {
        groceries = GroceryList.getInstance().getGroceries();
        lblTitle.setText("Listan ostosten määrä: " + groceries.size());
    }



}
