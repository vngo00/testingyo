package handler;

import request.ParsedRequest;

public class HandlerFactory {
  // routes based on the path. Add your custom handlers here
  public static BaseHandler getHandler(ParsedRequest request) {
    // TODO fill this out
    switch (request.getPath()){
      case "createMessage": return new CreateMessage();
      case "createUser": return new CreateUsers();
      case "getMessages": return new GetMessages();
      case "getUsers": return new GetUsers();
    }
    return null;
  }

}
