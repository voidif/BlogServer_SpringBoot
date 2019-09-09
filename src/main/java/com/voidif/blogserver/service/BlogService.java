package com.voidif.blogserver.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.voidif.blogserver.model.BlogDescription;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class BlogService {
    private static final String BLOG_STORAGE_DIR_PATH = "static/blogs";
    private static final String[] BLOG_DESC_FILE_EXTENSIONS = {"json"};

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<BlogDescription> retrieveBlogDescriptions() {
        File blogStorageDir = FileUtils.getFile(BLOG_STORAGE_DIR_PATH);
        Collection<File> blogDescriptionFiles = FileUtils.listFiles(blogStorageDir, BLOG_DESC_FILE_EXTENSIONS, false);
        List<BlogDescription> blogDescriptions = new LinkedList<>();
        for (File blogDescriptionFile: blogDescriptionFiles) {
            try {
                BlogDescription blogDescription = deserializeBlogDescriptionFromFile(blogDescriptionFile);
                blogDescriptions.add(blogDescription);
            } catch (IOException e) {
                log.error("Can not read blog description file: {}", blogDescriptionFile.getName());
            }
        }
        return blogDescriptions;
    }

    /**
     * Blog description file contains text data as following format.
     * {
     *    "file":"20190107151538NIO_BUG.md",
     *    "abstract":"Java nio bug in ubuntu",
     *    "title":"NIO_BUG"
     * }
     * @param blogDescriptionFile a file to stroage blog description info
     * @return a deserialized BlogDescription Object
     * @throws IOException
     */
    private static BlogDescription deserializeBlogDescriptionFromFile(File blogDescriptionFile) throws IOException {
        BlogDescription blogDescription = objectMapper.readValue(blogDescriptionFile, BlogDescription.class);
        blogDescription.setUrl(BLOG_STORAGE_DIR_PATH);
        return blogDescription;
    }
}
