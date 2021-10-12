package StockQuote;

import org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Creates a JSON stock quote file named after the stock symbol
 * ex:  sofi == "sofiQutoe.json"
 **/
public class StockQuote implements IStockQuote{

    protected Properties prop;
    protected HttpClient client;
    protected HttpRequest request;
    protected HttpResponse<String> response;
    protected JSONObject updatedJsonBody, originalJsonBody;
    protected String[] newKey, oldKey;

    public StockQuote(String symbol) throws InterruptedException, IOException {
        //String array with all symbols needed for a quote
        newKey = new String[] {"symbol", "price", "open", "high",
                "low", "volume", "previous close", "change", "change percent"};

        //Load property file
        loadProperties();
        String url = buildURL(symbol);
        httpConnector(url, symbol);
    }

    //Loads property file which contains different API information
    public void loadProperties() throws IOException {
        prop = new Properties();
        FileInputStream ip= new FileInputStream(String.valueOf(Paths.get("InvestorTools/src/config.properties")));
        prop.load(ip);
    }

    public String buildURL(String symbol) {
        return null;
    }

    public void httpConnector(String url, String symbol) throws IOException, InterruptedException {
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder(
                        URI.create(url))
                .header("accept", "application/json")
                .build();
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void createGenericQuoteFile(String symbol) throws IOException {

        for(int x=0; x<newKey.length; x++)
            updatedJsonBody.put(newKey[x], originalJsonBody.get(oldKey[x]));

        try {
            File myObj = new File("InvestorTools/output",  symbol + "Quote.json");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter quoteFile = new FileWriter("InvestorTools/output/" + symbol +"Quote.json");
        quoteFile.write(updatedJsonBody.toString());
        quoteFile.close();
    }
}
