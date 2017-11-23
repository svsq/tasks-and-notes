package tk.svsq.tasksandnotes.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import tk.svsq.tasksandnotes.model.ModelTask;

/**
 * Created by svsq on 21.11.2017.
 */

public class DBUpdateManager {

    SQLiteDatabase database;

    public DBUpdateManager(SQLiteDatabase database) {
        this.database = database;
    }

    public void title(long timeStamp, String title) {
        update(DBHelper.TASK_TITLE_COLUMN, timeStamp, title);
    }

    public void date(long timeStamp, long date) {
        update(DBHelper.TASK_DATE_COLUMN, timeStamp, date);
    }

    public void priority(long timeSTamp, int priority) {
        update(DBHelper.TASK_PRIORITY_COLUMN, timeSTamp, priority);
    }

    public void status(long timeSTamp, int status) {
        update(DBHelper.TASK_STATUS_COLUMN, timeSTamp, status);
    }

    public void task(ModelTask task) {
        long current = task.getTimeStamp();
        title(current, task.getTitle());
        date(current, task.getDate());
        priority(current, task.getPriority());
        status(current, task.getStatus());
    }

    private void update(String column, long key, String value) {
        ContentValues cv = new ContentValues();
        cv.put(column, value);
        database.update(DBHelper.TASKS_TABLE, cv, DBHelper.TASK_TIME_STAMP_COLUMN + " = " + key, null);
    }

    private void update(String column, long key, long value) {
        ContentValues cv = new ContentValues();
        cv.put(column, value);
        database.update(DBHelper.TASKS_TABLE, cv, DBHelper.TASK_TIME_STAMP_COLUMN + " = " + key, null);
    }
}
