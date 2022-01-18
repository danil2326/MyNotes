package ru.gb.course1.mynotes.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class NoteEntity implements Parcelable {
    public static final Creator<NoteEntity> CREATOR = new Creator<NoteEntity>() {
        @Override
        public NoteEntity createFromParcel(Parcel in) {
            return new NoteEntity(in);
        }

        @Override
        public NoteEntity[] newArray(int size) {
            return new NoteEntity[size];
        }
    };
    private String title;
    private String text;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NoteEntity() {
    }

    public NoteEntity(String title, String text, String id) {
        this.title = title;
        this.text = text;
        this.id = id;
    }

    protected NoteEntity(Parcel in) {
        title = in.readString();
        text = in.readString();
        id = in.readString();
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(text);
        parcel.writeString(id);
    }
}
