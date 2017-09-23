package tk.svsq.tasksandnotes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tk.svsq.tasksandnotes.fragments.TaskFragment;
import tk.svsq.tasksandnotes.model.Item;

/**
 * Created by svsq on 23.09.2017.
 */

public abstract class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Item> items;
    TaskFragment taskFragment;

    public TaskAdapter(TaskFragment taskFragment) {
        this.taskFragment = taskFragment;
        items = new ArrayList<>();
    }

    public Item getItem(int position)  {
        return items.get(position);
    }

    public void addItem(Item item)  {
        items.add(item);
        notifyItemInserted(getItemCount() - 1);
    }

    public void addItem(int location, Item item)  {
        items.add(location, item);
        notifyItemInserted(location);
    }

    public void removeItem(int location) {
        if(location >= 0 && location <= getItemCount() -1) {
            notifyItemRemoved(location);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected class TaskViewHolder extends RecyclerView.ViewHolder  {

        protected TextView title;
        protected TextView date;

        public TaskViewHolder(View itemView, TextView title, TextView date) {
            super(itemView);
            this.title = title;
            this.date = date;
        }
    }

    public TaskFragment getTaskFragment() {
        return taskFragment;
    }
}
