package ru.kalan.filereaderapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.kalan.filereaderapp.exception.IncorrectFile;
import ru.kalan.filereaderapp.util.MultiPartParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MultiPartParserTest {

    @Test
    @DisplayName("Создание книги")
    public void createBook_ok() {
        String fileName = "src/test/resources/example1.txt";
        File file = new File(fileName);
        try {
            InputStream stream = new FileInputStream(file);
            MultiPartParser.createBook(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test

    @DisplayName("Создание книги, если книга без названия")
    public void createBook_empty_file() {
        String fileName = "src/test/resources/example2.txt";
        File file = new File(fileName);
        try {
            InputStream stream = new FileInputStream(file);

            IncorrectFile ex = Assertions.assertThrows(
                    IncorrectFile.class,
                    () -> MultiPartParser.createBook(stream)
            );
            Assertions.assertEquals("File is incorrect", ex.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Создание книги, если файл пустой")
    public void createBook_without_title() {
        String fileName = "src/test/resources/example3.txt";
        File file = new File(fileName);
        try {
            InputStream stream = new FileInputStream(file);

            IncorrectFile ex = Assertions.assertThrows(
                    IncorrectFile.class,
                    () -> MultiPartParser.createBook(stream)
            );
            Assertions.assertEquals("File is empty", ex.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
