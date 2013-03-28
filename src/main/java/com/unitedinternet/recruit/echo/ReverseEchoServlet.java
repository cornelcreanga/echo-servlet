package com.unitedinternet.recruit.echo;

import com.unitedinternet.recruit.echo.processor.ReverseStringProcessor;
import com.unitedinternet.recruit.echo.processor.StringProcessor;
import com.unitedinternet.recruit.echo.util.IOUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Revert echo simple servlet. It accepts only post requests containing a text entity. it will return
 * the reversed entity, 400 error code if no entity is provided, 500 if an internal server occured. The entity length is not constrained, for the moment.
 */

public class ReverseEchoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //todo - for future, inject the processor
            StringProcessor processor = new ReverseStringProcessor();
            //todo - no content validation for the moment, assume that the input is ok/well formed.
            String entity = IOUtil.read(req.getReader(), req.getContentLength());
            if (entity.length() == 0) {
                resp.sendError(400);
                return;
            }
            String reversedEntity = processor.process(entity);
            resp.getWriter().write(reversedEntity);

        } catch (Exception e) {//todo - we should have a generic exception handler per servlets
            //todo - use log4j to log the errors
            resp.sendError(500);
        }
    }
}
