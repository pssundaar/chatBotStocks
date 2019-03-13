package com.hcl.rest.common.RESTfulExample;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App
{
  public App() {}
  
  public static void main(String[] args)
  {
    try
    {
      Client client = Client.create();
      



      WebResource webResource = client.resource("http://localhost:8080/RESTfulExample/rest/json/chat/post");
      
      byte[] encoded = Files.readAllBytes(Paths.get("C:\\Users\\kotipalliv\\Documents\\20-04-2018\\apiaijson.txt", new String[0]));
      
      String input = new String(encoded, StandardCharsets.UTF_8);
      

      ClientResponse response = (ClientResponse)webResource.type("application/json").post(ClientResponse.class, input);
      





      System.out.println("Output from Server .... \n");
      String output = (String)response.getEntity(String.class);
      System.out.println(output);


    }
    catch (Exception e)
    {


      e.printStackTrace();
    }
  }
}