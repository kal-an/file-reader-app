package ru.kalan.filereaderapp.service;

import org.springframework.web.multipart.MultipartFile;
import ru.kalan.filereaderapp.model.Book;

public interface ReaderService {

    Book createBook(MultipartFile file);

}
