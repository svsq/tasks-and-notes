package tk.svsq.tasksandnotes.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tk.svsq.tasksandnotes.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DoneTaskFragment extends Fragment {

    RecyclerView recyclerViewDoneTasks;
    RecyclerView.LayoutManager layoutManager;


    public DoneTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_done_task, container, false);

        recyclerViewDoneTasks = (RecyclerView) rootView.findViewById(R.id.recyclerViewDoneTask);

        layoutManager = new LinearLayoutManager(getActivity());

        recyclerViewDoneTasks.setLayoutManager(layoutManager);

        return rootView;
    }

}
