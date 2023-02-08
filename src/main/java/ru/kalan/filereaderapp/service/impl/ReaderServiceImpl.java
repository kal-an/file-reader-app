package ru.kalan.filereaderapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.kalan.filereaderapp.model.Book;
import ru.kalan.filereaderapp.service.ReaderService;
import ru.kalan.filereaderapp.util.MultiPartParser;

import java.io.IOException;

@Service
@Slf4j
public class ReaderServiceImpl implements ReaderService {
    @Override
    public Book createBook(MultipartFile file) {

        Book book = null;
        try {
            book = MultiPartParser.createBook(file.getInputStream());
            log.info("Created book {}", book.getTitle());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }
}
