import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServletTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:6000/webapplication/hello");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            System.out.println("Response Code: " + connection.getResponseCode());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            System.out.println("Response:\n" + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
