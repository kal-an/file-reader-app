package ru.kalan.filereaderapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chapter {

    private String title;
    private String description;
    private SubChapter subChapter;

}