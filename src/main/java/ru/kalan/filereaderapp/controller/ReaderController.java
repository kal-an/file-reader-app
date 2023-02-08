package ru.kalan.filereaderapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.kalan.filereaderapp.service.ReaderService;

@RestController
@Slf4j
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService service;

    @PostMapping(value = "/read", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> readBook(@RequestPart MultipartFile file) {
        return ResponseEntity.ok(service.createBook(file));
    }

}
