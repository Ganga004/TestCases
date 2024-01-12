package org.example;

import org.example.VoidClasses.Book;
import org.example.VoidClasses.Pages;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class PagesTest {

//    @Mock
    Book book;

    @InjectMocks
    private Pages pages;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        book = new Book();
    }

    @Test
    public void numberOfPagesTest() throws Exception {
        pages.numberOfPages();
    }

    @Test(expected = RuntimeException.class)
    public void numberOfPagesThrowingExceptionTest() throws Exception {
        when(pages.numberOfPages()).thenThrow(new RuntimeException());
        pages.numberOfPages();
    }
}
