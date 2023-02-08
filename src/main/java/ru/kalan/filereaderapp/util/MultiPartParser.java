package ru.kalan.filereaderapp.util;

import ru.kalan.filereaderapp.model.Book;
import ru.kalan.filereaderapp.model.Chapter;
import ru.kalan.filereaderapp.model.SubChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiPartParser {

    private final static int LEVEL_1 = 1;
    private final static int LEVEL_2 = 2;
    private final static int LEVEL_3 = 3;
    private final static String TAG = "#";
    private final static String COLON = ":";

    public static Book createBook(InputStream stream) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (!line.isBlank()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String title = lines.remove(0);
        Book book = new Book(title);
        Chapter chapter = null;
        SubChapter subChapter = null;

        for (String line : lines) {
            String curTag = line.substring(0, line.lastIndexOf(TAG) + 1);
            // заполняем раздел
            if (curTag.length() == LEVEL_1) {
                chapter = new Chapter();
                title = line.substring(LEVEL_1);
                chapter.setTitle(title);
                book.getChapters().add(chapter);
            }

            // заполняем подраздел
            if (curTag.length() == LEVEL_2) {
                if (chapter != null) {
                    subChapter = new SubChapter();
                    title = line.substring(LEVEL_2);
                    subChapter.setTitle(title);
                    chapter.setSubChapter(subChapter);
                }
            }

            // заполняем пары у подаздела
            if (curTag.length() == LEVEL_3 && line.contains(COLON)) {
                if (subChapter != null) {
                    Map<String, String> property = (Map<String, String>) (subChapter).getProperty();
                    if (property == null) {
                        property = new HashMap<>();
                    }
                    String[] arr = line.split(COLON);
                    String key = arr[0].substring(LEVEL_3);
                    String value = arr[1].strip();
                    property.put(key, value);
                    subChapter.setProperty(property);
                }
            }

            // заполняем список подраздела
            if (curTag.length() == LEVEL_3 && !line.contains(COLON)) {
                if (subChapter != null) {
                    List<String> property = (List<String>) (subChapter).getProperty();
                    if (property == null) {
                        property = new ArrayList<>();
                    }
                    property.add(line.substring(LEVEL_3));
                    subChapter.setProperty(property);
                }
            }
            // заполняем описание раздела
            if (!line.contains(TAG)) {
                if (chapter != null) {
                    if (chapter.getDescription() != null) {
                        line = chapter.getDescription() + " " + line;
                    }
                    chapter.setDescription(line);
                }
            }
        }
        return book;
    }
}
