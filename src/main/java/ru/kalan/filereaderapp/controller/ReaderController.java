package ru.kalan.filereaderapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.kalan.filereaderapp.model.Book;
import ru.kalan.filereaderapp.service.ReaderService;

@RestController
@Slf4j
@RequestMapping(path = "/api")
@RequiredArgsConstructor
@Tag(name = "Читатель", description = "Чтение текстовых файлов")
public class ReaderController {

    private final ReaderService service;

    @PostMapping(value = "/read", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Чтение книги",
            description = "Позволяет прочитать книгу из файла")
    public ResponseEntity<Book> readBook(
            @RequestPart @Parameter(description = "Текстовый файл", required = true) MultipartFile file) {
        return ResponseEntity.ok(service.createBook(file));
    }

}
