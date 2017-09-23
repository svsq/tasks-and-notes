package tk.svsq.tasksandnotes.fragments;

import android.app.Fragment;
import android.support.v7.widget.RecyclerView;

import tk.svsq.tasksandnotes.adapters.CurrentTaskAdapter;
import tk.svsq.tasksandnotes.model.ModelTask;

/**
 * Created by svsq on 23.09.2017.
 */

public abstract class TaskFragment extends Fragment{
    protected RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;

    protected CurrentTaskAdapter adapter;

    public void addTask(ModelTask newTask)  {
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
    }
}
