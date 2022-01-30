package ru.gb.course1.mynotes.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.mynotes.domain.NoteEntity;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
private List<NoteEntity> data;
private OnNoteDeleteListener onDeletClickListener;
private OnNoteDoubleListener onNoteDoubleListener;
private OnNoteSaveListener onNoteSaveListener;





public void setOnDeletClickListener(OnNoteDeleteListener onDeletClickListener) {
    this.onDeletClickListener = onDeletClickListener;
}

public void setOnNoteDoubleListener(OnNoteDoubleListener onNoteDoubleListener) {
    this.onNoteDoubleListener = onNoteDoubleListener;
}
public void setOnNoteSaveListener(OnNoteSaveListener onNoteSaveListener) {
    this.onNoteSaveListener = onNoteSaveListener;
}


    public void setData(List<NoteEntity> noteList) {
        data = noteList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       final LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       return new NoteViewHolder(inflater, parent, onDeletClickListener, onNoteDoubleListener, onNoteSaveListener);
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
