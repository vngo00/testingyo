package response;

import handler.GsonTool;

import java.util.Map;
import java.util.SplittableRandom;

public class CustomHttpResponse {
  public final Map<String,String> headers;
  public final String status;
  public final String version;
  public final RestApiAppResponse body;

  public CustomHttpResponse(Map<String, String> headers, String status, String version,
      RestApiAppResponse body) {
    this.headers = headers;
    this.status = status;
    this.version = version;
    this.body = body;
  }

  // TODO fill this out
  public String toString(){

    StringBuilder stringBuilder = new StringBuilder();

    stringBuilder.append(version + " " + status + "\n");
    if (status.compareTo("404 Not Found") == 0){
      return stringBuilder.toString();
    }

    if(!headers.isEmpty()) {
      for (Map.Entry<String, String> entry : headers.entrySet()) {
        stringBuilder.append(entry.getKey() + ": " + entry.getValue() + "\n\n");
      }
    }
    else
      stringBuilder.append('\n');
//    stringBuilder.append("\n" + GsonTool.gson.toJson(body, RestApiAppResponse.class));
    stringBuilder.append(GsonTool.gson.toJson(body, RestApiAppResponse.class));

    return stringBuilder.toString();

  }
}
