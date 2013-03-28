package com.unitedinternet.recruit.echo.processor;

/**
 * This interface should be implemented by any string processor class
 */
public interface StringProcessor {

    /**
     * Process a string
     * @param text cannot be null
     * @return the processed string
     */
    String process(String text);

}
