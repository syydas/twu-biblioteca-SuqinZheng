package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private ByteArrayOutputStream testOut = new ByteArrayOutputStream();

    @Before
    public void setUpOutput() {
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreSystemInputOutput() {
        System.setOut(System.out);
    }

    @Test
    public void give_welcome_message_when_start_the_application() {
        BibliotecaApp.printWelcomeMessage();
        assertEquals(testOut.toString(), "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
    }

    @Test
    public void give_booklist_after_the_welcome_message_appears() {
        BibliotecaApp.displayBookList();
        assertEquals(testOut.toString(), "book1\nbook2\nbook3\n");
    }

}
