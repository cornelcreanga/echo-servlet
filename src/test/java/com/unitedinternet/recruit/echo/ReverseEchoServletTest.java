package com.unitedinternet.recruit.echo;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;


public class ReverseEchoServletTest {

    private HttpServletRequest req = mock(HttpServletRequest.class);
    private HttpServletResponse resp = mock(HttpServletResponse.class);
    private ReverseEchoServlet reverseEchoServlet = new ReverseEchoServlet();
    private StringWriter responseText = new StringWriter();

    @Before
    public void setupServlet() throws IOException {
        when(resp.getWriter()).thenReturn(new PrintWriter(responseText));
    }

    @Test
    public void testDoPost() throws Exception {
        String TEST = "Hallo Welt";
        String EXPECTED = "tleW ollaH";

        mockHttpRequest("POST", "/echo");
        when(req.getReader()).thenReturn(new BufferedReader(new StringReader(TEST)));
        when(req.getContentLength()).thenReturn(TEST.length());

        reverseEchoServlet.doPost(req, resp);
        assertThat(responseText.toString(), equalTo(EXPECTED));
    }

    @Test
    public void testDoEmptyPost() throws Exception {
        String TEST = "";
        mockHttpRequest("POST", "/echo");

        when(req.getReader()).thenReturn(new BufferedReader(new StringReader(TEST)));
        when(req.getContentLength()).thenReturn(TEST.length());
        reverseEchoServlet.doPost(req, resp);
        verify(resp, times(1)).sendError(400);
    }


    //todo - test also for status code c

    private void mockHttpRequest(String method, String pathInfo) {
        when(req.getMethod()).thenReturn(method);
        when(req.getPathInfo()).thenReturn(pathInfo);
    }
}
