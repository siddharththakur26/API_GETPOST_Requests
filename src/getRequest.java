//package API_GET_POST_Requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class getRequest {
    public static void main(String[] args) throws IOException {
        //get the URL of the API to be connected
        URL getURL =  new URL("URL");
        //Store the response output from API
        String readOutput = "";
        // Open the Connection between the local and web server
        HttpURLConnection connection = (HttpURLConnection) getURL.openConnection();
        // Supply the Token to be used
        connection.setRequestMethod("GET");
        // get the ids that are mattered
        connection.setRequestProperty("key","expires");
        // store the code whether connection is established or not
        int responseCode = connection.getResponseCode();

        // return the output from the api

        if (responseCode == HttpURLConnection.HTTP_CREATED){
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer response = new StringBuffer();

            while((readOutput = input.readLine())!= null){
                response.append(readOutput);
            }
            input.close();
            System.out.println(response.toString());
        }
        else
            System.out.println(responseCode);

    }
}
