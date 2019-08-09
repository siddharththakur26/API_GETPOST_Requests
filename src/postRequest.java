//package API_GET_POST_Requests;


import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class postRequest {
    public static void main(String[] args) throws IOException {
        // Run the getResponse to obtain the API key for the get method
        String getResponse = "{\"key\": \"API-GET-RESPONSE-KEY\", \"expires\": \"2019-08-07 23:49:05.599157\"}";

        // Post request body
        final String postParameters = "{\n \"name\": \"Siddharth Thakur\", \n \"email\": \"something@gmail.com\"\n}";
        //arrange in a way of JSON object
        System.out.println(postParameters);
        //set the post URL
        String basePostURL ="BASE URL";
        // set the API response key
        String apiKey = "API-GET-RESPONSE-KEY";
        // shakehand with post url
        URL postURL = new URL(basePostURL+apiKey);
        // Open the post URL connection
        HttpURLConnection postConnection = (HttpURLConnection) postURL.openConnection();
        //initiate post request
        postConnection.setRequestMethod("POST");
        //open up the channel
        postConnection.setDoOutput(true);
        // set the data to be pushed in the form of bytes
        OutputStream os = postConnection.getOutputStream();
        os.write(postParameters.getBytes());
        os.flush();
        os.close();

        // check the post response
        int responseCode = postConnection.getResponseCode();
        String responseMsg = postConnection.getResponseMessage();

        System.out.println("Response Code: "+ responseCode);
        System.out.println("Response Code: "+ responseMsg);




    }
}
