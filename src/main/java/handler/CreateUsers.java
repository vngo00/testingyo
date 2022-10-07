package handler;

import dao.UserDao;
import dto.UserDto;
import request.ParsedRequest;
import response.CustomHttpResponse;
import response.ResponseBuilder;
import response.RestApiAppResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateUsers implements BaseHandler{
    public static void main(String[] args) {
        String json = "{'userName' : 'vinh'}";
        UserDto newUser = GsonTool.gson.fromJson(json,UserDto.class);
        System.out.println(newUser != null);
    }

    @Override
    public CustomHttpResponse handleRequest(ParsedRequest request) {
        System.out.println("here is how the body looks like:  " + request.getBody());

        UserDao userDao = UserDao.getInstance();
        UserDto newUser = GsonTool.gson.fromJson(request.getBody(),UserDto.class);
        newUser.setUniqueId(String.valueOf(Math.random()));

        ResponseBuilder builder = new ResponseBuilder();
        builder  = builder.setStatus("200 OK");
        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.add(newUser);
        userDao.put(newUser);
        RestApiAppResponse restApiAppResponse = new RestApiAppResponse(true,userDtoList,"");
        builder.setBody(restApiAppResponse);

        return builder.build();
    }
}
