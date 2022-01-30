package ru.gb.course1.mynotes.domain;

import java.util.List;

public interface NotesRepository {
    List<NoteEntity> getNotes();

    void deleteNotes(NoteEntity noteEntity);

    void addNotes();

    void saveNotes(NoteEntity noteEntity);


}
