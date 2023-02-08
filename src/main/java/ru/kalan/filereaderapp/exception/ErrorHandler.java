package ru.kalan.filereaderapp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kalan.filereaderapp.controller.ReaderController;

@Slf4j
@RestControllerAdvice(assignableTypes = {ReaderController.class})
public class ErrorHandler {

    @ExceptionHandler({IncorrectFile.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(final IncorrectFile e) {
        log.error("Error {}", e.getMessage());
        return new ErrorResponse(e.getMessage());
    }
}
