package ru.kalan.filereaderapp.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter
public class Book {

    private String title;
    private List<Chapter> chapters;

    public Book(String title) {
        this.title = title;
        this.chapters = new ArrayList<>();
    }
}