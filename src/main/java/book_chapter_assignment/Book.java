package book_chapter_assignment;

import java.util.*;

public class Book {
    private List<Chapter> chapterList;
    private String author;
    private String name;

    public Book(String author, String name) {
        if (author.equals("") || author.isEmpty() || name.equals("") || name.isEmpty()) { throw new IllegalArgumentException(); }
        this.chapterList = new ArrayList<>();
        this.author = author;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void addChapter(String chapterName, String number) {
        Chapter c = new Chapter(chapterName, number);

        for (Chapter chapter: chapterList) {
            if (chapter.equals(c)) {
                throw new IllegalArgumentException("Chapter already exists");
            }
        }

        this.chapterList.add(c);
    }

    public int getNumberOfChapters() {
        return this.chapterList.size();
    }


    public List<Chapter> getChapterList() {
        return this.chapterList;
    }

    public Set<Chapter> getTableOfContents() {
        return new TreeSet<>(this.chapterList);
    }
}
