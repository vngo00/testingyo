package request;

public class CustomParser {

  // extract java useable values from a raw http request string
  // https://developer.mozilla.org/en-US/docs/Web/HTTP/Messages
  // TODO fill this out
  public static ParsedRequest parse(String request){

      ParsedRequest parsedRequest = new ParsedRequest();

        // contains method, path, and params

        // contain body content
      //System.out.println("CustomParser line 14: \n\n " + request);


      String body = getBody(request);
       // System.out.println("line 15: " + head);
     // System.out.println("CustomParser: line 14 : " + body);
      processHead(parsedRequest, request);
      parsedRequest.setBody(body);


     // System.out.println(body);
   return parsedRequest;
  }


  private static void processHead(ParsedRequest parsedRequest, String request) {
      String head = getHead(request);
      int start = 0;

      for (int i = 0; i < head.length(); i++) {
          // find the method in the head string
          if (head.charAt(i) == ' ') {
              parsedRequest.setMethod(head.substring(start, i));
              start = i + 1;
              break;
          }
      }
      for (int i = start; i < head.length(); i++) {
          // get the path
          if (head.charAt(i) == ' ' || head.charAt(i) == '?') {
              parsedRequest.setPath(head.substring(start, i));

              start = i + 1;
              break;
          }
      }


      for(int i = start; i < head.length(); i++){

          if (head.charAt(i) == ' '){
              handleParams(parsedRequest, head.substring(start, i+1));
              break;
          }
      }
  }


    private static void handleParams(ParsedRequest parsedRequest, String params){
            String key = "";
            String value = "";
            int start = 0;
            for (int i = 0; i < params.length(); i++){
                if (params.charAt(i) == '='){
                    key = params.substring(start, i);
                    start = i +1;
                }

                if (params.charAt(i) == '&' || i == params.length() -1){
                    value = params.substring(start, i);
                    start = i + 1;
                    parsedRequest.setQueryParam(key, value);
                }

            }

    }

  private static String getHead(String request){
      for(int i = 0 ; i < request.length(); i++){
          if (request.charAt(i) == '\n'){
              return request.substring(0,i-1);
          }
      }
      return "";
  }

  private static String getBody(String request){
      System.out.println("length of request: " + request.length());
      System.out.println("here the body:\n\n");


      for(int i =0; i < request.length(); i++){
//          if(request.charAt(i) == '{'){
          if(request.charAt(i) == '\n' && request.charAt(i-1) == '\n'){
              System.out.println("length of the body: " + (request.length() - i));
              return request.substring(i+1, request.length());
          }
      }
      return "";
  }
}
