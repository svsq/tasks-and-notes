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
public class CurrentTaskFragment extends Fragment {

    private RecyclerView recyclerViewCurrentTasks;
    private RecyclerView.LayoutManager layoutManager;


    public CurrentTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_current_task, container,false);

        recyclerViewCurrentTasks = (RecyclerView) rootView.findViewById(R.id.recyclerViewCurrentTask);

        layoutManager = new LinearLayoutManager(getActivity());

        recyclerViewCurrentTasks.setLayoutManager(layoutManager);

        return rootView;
    }

}
