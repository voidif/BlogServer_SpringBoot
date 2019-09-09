package com.voidif.blogserver.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class BlogDescription {
    private String title;
    private String url;

    @JsonAlias("abstract")
    private String articleAbstract;

    @JsonAlias("file")
    private String fileName;

}

