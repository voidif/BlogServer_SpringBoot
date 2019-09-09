package com.voidif.blogserver.service;

import com.voidif.blogserver.model.BlogDescription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class BlogDescriptionServiceTest {
    private static final int EMPTY_LIST_SIZE = 0;

    @Test
    public void retrieveBlogSucceed() {
        List<BlogDescription> blogDescriptions = BlogService.retrieveBlogDescriptions();
        assertNotEquals(EMPTY_LIST_SIZE, blogDescriptions.size());
    }
}
