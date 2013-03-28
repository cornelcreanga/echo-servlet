package com.unitedinternet.recruit.echo.util;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class IOUtilTest {
    @Test
    public void testRead() throws Exception {
        StringReader reader = new StringReader("test");
        String s = IOUtil.read(reader, 4);
        assertThat("test", equalTo(s));
    }

    @Test(expected=IOException.class)
    public void testReadException() throws Exception {
        StringReader reader = new StringReader("test");
        IOUtil.read(reader, 5);
    }



}
