package handler;

import dao.UserDao;
import request.ParsedRequest;
import response.CustomHttpResponse;
import response.ResponseBuilder;
import response.RestApiAppResponse;

public class GetUsers implements BaseHandler{

    @Override
    public CustomHttpResponse handleRequest(ParsedRequest request) {

        UserDao userDao = UserDao.getInstance();

        ResponseBuilder builder = new ResponseBuilder();
        builder.setStatus("200 OK");

        RestApiAppResponse restApiAppResponse = new RestApiAppResponse(true,userDao.getAll(),"");
        builder.setBody(restApiAppResponse);
        return builder.build();
    }
}
