package book_chapter_assignment;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookTest {

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
        // arrange
        new Book("", "");
    }


    @Test
    public void addingNewChapterToTheBookShouldBeSuccessful() {
        // arrange
        Chapter chapter = mock(Chapter.class);
        Book book = new Book(BOOK_NAME, BOOK_AUTHOR);

        // act
        book.addChapter(chapter);

        // assert
        Assert.assertEquals(1, book.getNumberOfChapters());
    }

    @Test
    public void creatingAndAddingNewChapterWithParametersShouldBeSuccessful() {
        // arrange
        Chapter chapter = new Chapter(CHAPTER_NAME, CHAPTER_NUMBER);
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
        Chapter chapter = mock(Chapter.class);

        // act
        book.addChapter(chapter);
        book.addChapter(chapter);
    }

    @Test
    // chaptersShouldBeSorted
    public void tableOfContentsShouldReturnASetOfSortedChapter() {
        // arrange
        Book book = new Book(BOOK_NAME, BOOK_AUTHOR);

        Chapter c1 = new Chapter(CHAPTER_NAME, "2.2");
        Chapter c2 = new Chapter(CHAPTER_NAME, "2.1");
        Chapter c3 = new Chapter(CHAPTER_NAME, "3.4");
        Chapter c4 = new Chapter(CHAPTER_NAME, "5.2");

        book.addChapter(c1);
        book.addChapter(c2);
        book.addChapter(c3);
        book.addChapter(c4);

        // act
        Collections.sort(expectedList);

        book.getTableOfContents();

        // assert
        // make sure table of contents is sorted

    }


}
