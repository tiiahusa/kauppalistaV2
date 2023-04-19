package com.example.kauppalistav2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentBottom#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBottom extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Grocery> list = new ArrayList<>();
    TextView lblImportantThings;
    View v;

    public FragmentBottom() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBottom.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBottom newInstance(String param1, String param2) {
        FragmentBottom fragment = new FragmentBottom();
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
        v = inflater.inflate(R.layout.fragment_bottom, container, false);

        lblImportantThings = v.findViewById(R.id.lblImportantThings);

        list = GroceryList.getInstance().getGroceries();
        String things = "";
        for (Grocery gro: list) {
            if (things.length() > 0) { // Lisätään pilkku tuotteiden väliin
                things += ", ";
            }
            if (gro.getStar()) { // Lisätään tähdelliset listaan
                things += gro.getGrocery();
            }
        }

        lblImportantThings.setText(things);
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        list = GroceryList.getInstance().getGroceries();
        String things = "";
        for (Grocery gro: list) {
            if (gro.getStar()) { // Lisätään tähdelliset listaan
                if (things.length() > 0) { // Lisätään pilkku tuotteiden väliin
                    things += ", ";
                }
                things += gro.getGrocery();
            }
        }
        lblImportantThings.setText(things);
    }
}