package com.unitedinternet.recruit.echo.integration;

import com.unitedinternet.recruit.echo.util.IOUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReverseEchoServletIT {

    private static final String URL = "http://localhost:8080/echo";

    @Test
    public void testDoPost() throws IOException {
        String TEST = "Hallo Welt";
        String EXPECTED = "tleW ollaH";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(URL);
        post.setEntity(new StringEntity(TEST, HTTP.PLAIN_TEXT_TYPE, HTTP.UTF_8));

        HttpResponse response = client.execute(post);
        String expected = IOUtil.read(new InputStreamReader(response.getEntity().getContent()), EXPECTED.length());
        assertThat(expected, equalTo(EXPECTED));
        EntityUtils.consume(response.getEntity());

    }

    @Test
    public void testDoPostEmpty() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(URL);
        HttpResponse response = client.execute(post);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(400));
    }


}
