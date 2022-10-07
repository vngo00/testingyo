package handler;

import request.ParsedRequest;
import response.CustomHttpResponse;
import response.ResponseBuilder;

public class BadRequest implements BaseHandler {
    @Override
    public CustomHttpResponse handleRequest(ParsedRequest request) {
        ResponseBuilder responseBuilder = new ResponseBuilder();
        responseBuilder.setStatus("404 Not Found");
        return responseBuilder.build();
    }
}
