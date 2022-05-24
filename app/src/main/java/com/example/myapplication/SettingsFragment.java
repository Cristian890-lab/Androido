package com.example.myapplication;

import android.content.ClipData;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import java.sql.Array;
import java.util.Locale;
import java.util.Objects;

public class SettingsFragment extends Fragment {

    String[] names = {"About Phone", "System apps updater", "Security Status", "SIM cards & mobile networks", "Wi-Fi", "Bluetooth", "Portable Hotspot", "Connection & Sharing", "Lock Screen", "Display", "Sound & Vibration", "Notifications", "Home Screen", "Wallpaper", "Passwords & Security", "Privacy Protection", "Battery", "Apps", "Google", "Accounts", "Privacy", "Location", "Services & Feedback"};

    private SearchView searchView;
    private ListAdapter itemAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_settings,container,false);


        searchView = view.findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        itemAdapter = new ListAdapter(names);
        recyclerView.setAdapter(itemAdapter);

        return view;
    }

    private void filterList(String text) {
        String[] filteredList = new String[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        int i = 0;
        for (String item : names){
            if(item.toLowerCase().contains(text.toLowerCase())) {
                filteredList[i] = item;
                i++;
            }
            itemAdapter.setFilteredList(filteredList);
        }
    }


}