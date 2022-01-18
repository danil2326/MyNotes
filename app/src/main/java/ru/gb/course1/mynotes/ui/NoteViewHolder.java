package ru.gb.course1.mynotes.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.gb.course1.mynotes.domain.NoteEntity;
import ru.gb.course1.mynotes.R;


public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView = itemView.findViewById(R.id.title);
        EditText textEditView = itemView.findViewById(R.id.text);
        Button buttonDelete = itemView.findViewById(R.id.delete_button);

        private OnNoteDeleteListener onNoteDeleteListener;


        public NoteViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, OnNoteDeleteListener onNoteDeleteListener ) {
            super(inflater.inflate(R.layout.item_note, parent, false));
            this.onNoteDeleteListener = onNoteDeleteListener;

        }

        public void bind(NoteEntity noteEntity) {
            buttonDelete.setOnClickListener(view -> {
                onNoteDeleteListener.OnNoteDelete(noteEntity);
            });
            titleTextView.setText(noteEntity.getTitle());
            textEditView.setText(noteEntity.getText());


        }
    }

