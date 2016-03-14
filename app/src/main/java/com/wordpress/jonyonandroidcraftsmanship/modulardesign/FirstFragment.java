package com.wordpress.jonyonandroidcraftsmanship.modulardesign;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FirstFragment extends Fragment {

    private ListView lvTitles;
    private ArrayAdapter titleAdapter;
    private ItemClickListener itemClickListener = new ItemClickListener();
    private Communicator communicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        lvTitles = (ListView) view.findViewById(R.id.lvTitles);
        titleAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.titles, android.R.layout.simple_list_item_1);
        lvTitles.setAdapter(titleAdapter);
        lvTitles.setOnItemClickListener(itemClickListener);
        return view;
    }

    private class ItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            communicator.respond(position);
        }
    }

    public interface Communicator {
        public void respond(int index);
    }

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

}
