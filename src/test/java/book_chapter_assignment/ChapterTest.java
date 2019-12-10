package book_chapter_assignment;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ChapterTest {
    @Test
    public void newChapterShouldBeDescribedByNameAndNumber() {
        // arrange
        Chapter chapter = new Chapter(CHAPTER_NAME, CHAPTER_NUMBER);

        // assert
        Assert.assertEquals(CHAPTER_NAME, chapter.getName());
        Assert.assertEquals(CHAPTER_NUMBER, chapter.getNumber());
    }

    @Test
    public void chapterNameWithTwoLevelFormatShouldSucceed() {
        Chapter c = new Chapter(CHAPTER_NAME, "2.2");
        Assert.assertEquals("2.2", c.getNumber());
    }

    @Test (expected = IllegalArgumentException.class)
    public void chapterNameWithThreeLevelFormatShouldThrowAnException() {
        // arrange
        new Chapter(CHAPTER_NAME, "2.2.3");
    }

    @Test
    public void chapterWithLowerNumberShouldGoFirst() {
        // arrange
        Chapter c1 = new Chapter(CHAPTER_NAME, "2.1");
        Chapter c2 = new Chapter(CHAPTER_NAME, "2.2");

        // assert
        Assert.assertTrue(c1.compareTo(c2) > 0);
    }

    @Test
    public void comparingHigherChapterNumberToLowerShouldFail() {
        // arrange
        Chapter c1 = new Chapter(CHAPTER_NAME, "2.2");
        Chapter c2 = new Chapter(CHAPTER_NAME, "2.1");

        // assert
        Assert.assertFalse(c1.compareTo(c2) > 0);
    }
}
