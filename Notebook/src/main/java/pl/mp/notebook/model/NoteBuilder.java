package pl.mp.notebook.model;

public class NoteBuilder {

    private String title;

    private String author;

    private String text;

    private String date;

    public NoteBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public NoteBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public NoteBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public NoteBuilder withDate(String date) {
        this.date = date;
        return this;
    }

    public Note build() {
        Note note = new Note();
        note.setTitle(title);
        note.setAuthor(author);
        note.setText(text);
        note.setDate(date);
        return note;
    }

}
