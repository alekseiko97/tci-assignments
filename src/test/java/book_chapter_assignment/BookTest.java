package book_chapter_assignment;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookTest {

    private static final String BOOK_NAME = "Harry Potter";
    private static final String BOOK_AUTHOR = "J.K. Rowling";
    private static final String CHAPTER_NAME = "Chapter 5";
    private static final String CHAPTER_NUMBER = "5";

    @Test
    public void newBookShouldBeDescribedWithAuthorAndName() {
        // arrange
        Book book = new Book(BOOK_AUTHOR, BOOK_NAME);

        // assert
        Assert.assertEquals(BOOK_AUTHOR, book.getAuthor());
        Assert.assertEquals(BOOK_NAME, book.getName());
    }



    @Test (expected = IllegalArgumentException.class)
    public void creatingNewBookWithEmptyAuthorAndNameShouldThrowAnException() {
        // arrange and act
        new Book("", "");
    }


    @Test
    public void addingNewChapterToTheBookShouldBeSuccessful() {
        // arrange
        Book book = new Book(BOOK_NAME, BOOK_AUTHOR);

        // act
        book.addChapter(CHAPTER_NAME, CHAPTER_NUMBER);

        // assert
        Assert.assertEquals(1, book.getNumberOfChapters());
    }

    @Test
    public void creatingAndAddingNewChapterWithParametersShouldBeSuccessful() {
        // arrange
        Book book = new Book(BOOK_NAME, BOOK_AUTHOR);

        // act
        book.addChapter(CHAPTER_NAME, CHAPTER_NUMBER);

        // assert
        Assert.assertEquals(1, book.getNumberOfChapters());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addingDuplicateChapterToTheBookShouldThrowAnException() {
        // arrange
        Book book = new Book(BOOK_NAME, BOOK_AUTHOR);

        // act
        book.addChapter(CHAPTER_NAME, CHAPTER_NUMBER);
        book.addChapter(CHAPTER_NAME, CHAPTER_NUMBER);
    }

    @Test
    public void tableOfContentsShouldReturnASetOfSortedChapter() {
        // arrange
        Book book = new Book(BOOK_NAME, BOOK_AUTHOR);

        book.addChapter(CHAPTER_NAME, "2.2");
        book.addChapter(CHAPTER_NAME, "2.1");
        book.addChapter(CHAPTER_NAME, "3.4");
        book.addChapter(CHAPTER_NAME, "5.2");

        Set<Chapter> chapterSet = book.getTableOfContents();

        // assert
    }


}
