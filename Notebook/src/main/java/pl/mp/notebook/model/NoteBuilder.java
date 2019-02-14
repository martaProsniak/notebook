package pl.mp.notebook.model;


import java.time.LocalDateTime;

public class NoteBuilder {

    private String title;

    private String authorName;

    private String authorSurname;

    private String text;

    private LocalDateTime date;

    public NoteBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public NoteBuilder withAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public NoteBuilder withAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
        return this;
    }

    public NoteBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public NoteBuilder withDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Note build() {
        Note note = new Note();
        note.setTitle(title);
        Author author = new Author();
        author.setName(authorName);
        author.setSurname(authorSurname);
        note.setText(text);
        note.setDate(LocalDateTime.now());
        return note;
    }

}
