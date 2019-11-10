package com.fedcrypt.addone.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fedcrypt.addone.R;
import com.fedcrypt.addone.elements.ReminderItem;

import java.util.List;

public class ReminderItemAdapter extends RecyclerView.Adapter<ReminderItemAdapter.RIViewHolder> {
    private List<ReminderItem> itemsList;

    @NonNull
    @Override
    public RIViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reminder_item, parent, false);

        return new RIViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RIViewHolder holder, int position) {
        holder.itemTitle.setText(itemsList.get(position).getTitle());
        holder.taskDetails.setText(itemsList.get(position).getDetails());
        holder.dueAt.setText(itemsList.get(position).getDueAt());
        holder.priority.setText(itemsList.get(position).getPriority());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class RIViewHolder extends RecyclerView.ViewHolder {
        public TextView itemTitle, taskDetails, priority, dueAt;

        public RIViewHolder(View view) {
            super(view);
            itemTitle = view.findViewById(R.id.itemTitle);
            taskDetails = view.findViewById(R.id.taskDetails);
            priority = view.findViewById(R.id.priority);
            dueAt = view.findViewById(R.id.dueAt);
        }
    }

    public ReminderItemAdapter(List<ReminderItem> items){
        this.itemsList = items;
    }
}
