package ru.gb.course1.mynotes.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.gb.course1.mynotes.domain.NoteEntity;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
private ArrayList<NoteEntity> data;
private OnNoteDeleteListener onDeletClickListener;





public void setOnDeletClickListener(OnNoteDeleteListener onDeletClickListener) {
    this.onDeletClickListener = onDeletClickListener;
}



    public void setData(ArrayList<NoteEntity> noteList) {
        data = noteList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       final LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       return new NoteViewHolder(inflater, parent, onDeletClickListener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(data.get(position));
    }


}
