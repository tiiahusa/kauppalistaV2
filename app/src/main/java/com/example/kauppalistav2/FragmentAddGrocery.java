package com.example.kauppalistav2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentAddGrocery extends Fragment {

    private View v;
    private Grocery grocery;
    private GroceryList list;
    private EditText tbGrocery;
    private EditText tbRem;
    private Button btnAdd;
    private CheckBox cbImportant;

    public FragmentAddGrocery() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
    }
        list = GroceryList.getInstance();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_addgrocery, container, false);

        // Linkkaa layoutin komponentit koodiin, huomaa käyttää v-muuttujaa metodin edessä, jotta saat poimittua komponentit
        tbGrocery = v.findViewById(R.id.tbGrocery);
        tbRem = v.findViewById(R.id.tbRem);
        btnAdd = v.findViewById(R.id.btnAddGrocery);
        cbImportant = v.findViewById(R.id.cbImportant);

        btnAdd.setOnClickListener(v -> {
            grocery = new Grocery(tbGrocery.getText().toString(), tbRem.getText().toString(), cbImportant.isChecked());
            list.addGroceryToList(grocery);
            tbGrocery.setText("");
            tbRem.setText("");
            cbImportant.setChecked(false);
        });



        return v;
    }

}
