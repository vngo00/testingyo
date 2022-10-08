package handler;

import dao.MessageDao;
import dto.MessageDto;
import request.ParsedRequest;
import response.CustomHttpResponse;
import response.ResponseBuilder;
import response.RestApiAppResponse;

import java.util.ArrayList;
import java.util.List;

public class CreateMessage implements BaseHandler{


    @Override
    public CustomHttpResponse handleRequest(ParsedRequest request) {

        MessageDao messageDao = MessageDao.getInstance();

        MessageDto newMessage = GsonTool.gson.fromJson(request.getBody(), MessageDto.class);
        newMessage.setUniqueId(String.valueOf(Math.random()));
        List<MessageDto> messageDtoList = new ArrayList<>();
        messageDtoList.add(newMessage);

        messageDao.put(newMessage);

        System.out.println("content of messageDto from requets: " + newMessage);


        ResponseBuilder builder = new ResponseBuilder();
        builder.setStatus("200 OK");
        RestApiAppResponse body = new RestApiAppResponse(true,messageDtoList,"");
        builder.setBody(body);

        return builder.build();
    }
}
