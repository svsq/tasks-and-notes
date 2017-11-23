package tk.svsq.tasksandnotes.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import tk.svsq.tasksandnotes.MainActivity;
import tk.svsq.tasksandnotes.adapters.TaskAdapter;
import tk.svsq.tasksandnotes.model.ModelTask;


public abstract class TaskFragment extends Fragment{
    protected RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;

    protected TaskAdapter adapter;

    public MainActivity activity;

    public void addTask(ModelTask newTask, boolean saveToDB)  {
        int position = -1;

        for(int i = 0; i < adapter.getItemCount(); i++)  {
            if(adapter.getItem(i).isTask())  {
                ModelTask task = (ModelTask) adapter.getItem(i);
                if (newTask.getDate() < task.getDate())  {
                    position = i;
                    break;
                }
            }
        }

        if (position != -1)  {
            adapter.addItem(position, newTask);
        } else {
            adapter.addItem(newTask);
        }

        if(saveToDB) {
            activity.dbHelper.saveTask(newTask);
        }
    }

    public abstract void addTaskFromDB();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getActivity() != null) {
            activity = (MainActivity) getActivity();
        }

        addTaskFromDB();
    }

    public abstract void moveTask(ModelTask task);
}
