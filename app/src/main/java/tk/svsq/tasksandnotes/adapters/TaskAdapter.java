package tk.svsq.tasksandnotes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import tk.svsq.tasksandnotes.fragments.TaskFragment;
import tk.svsq.tasksandnotes.model.Item;

public abstract class TaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Item> items;
    private TaskFragment taskFragment;

    TaskAdapter(TaskFragment taskFragment) {
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
            items.remove(location);
            notifyItemRemoved(location);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder  {

        TextView title;
        TextView date;
        CircleImageView priority;

        TaskViewHolder(View itemView, TextView title, TextView date, CircleImageView priority) {
            super(itemView);
            this.title = title;
            this.date = date;
            this.priority = priority;
        }
    }

    TaskFragment getTaskFragment() {
        return taskFragment;
    }
}
