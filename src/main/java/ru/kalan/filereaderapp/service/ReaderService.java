package ru.kalan.filereaderapp.service;

import org.springframework.web.multipart.MultipartFile;
import ru.kalan.filereaderapp.model.Book;

/**
 * Сервис чтения файлов получения книги
 */
public interface ReaderService {

    /**
     * Создание книги
     * @param file {@link MultipartFile}
     * @return книга {@link Book}
     */
    Book createBook(MultipartFile file);

}
