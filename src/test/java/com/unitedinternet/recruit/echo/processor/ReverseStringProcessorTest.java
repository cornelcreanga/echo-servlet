package com.unitedinternet.recruit.echo.processor;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReverseStringProcessorTest {
    @Test
    public void testProcess() throws Exception {
        ReverseStringProcessor stringProcessor = new ReverseStringProcessor();

        assertThat(stringProcessor.process("123"), equalTo("321"));
        assertThat(stringProcessor.process(""), equalTo(""));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testProcessFailed() throws Exception {
        ReverseStringProcessor stringProcessor = new ReverseStringProcessor();
        stringProcessor.process(null);
    }
}