package StockQuote;

import org.json.JSONObject;
import java.io.IOException;


public class AlphaAdvantageStockQuote extends StockQuote{

    public AlphaAdvantageStockQuote(String symbol) throws InterruptedException, IOException {
        super(symbol);

        oldKey = new String[] {"01. symbol", "05. price", "02. open", "03. high",
                "04. low", "06. volume", "08. previous close", "09. change", "10. change percent"};

        originalJsonBody = new JSONObject(response.body());
        originalJsonBody = originalJsonBody.getJSONObject("Global Quote");

        updatedJsonBody = new JSONObject();

        createGenericQuoteFile(symbol);
    }

    //Creates REST call for a quote for Alpha Advantage based on passed ticker symbol
    @Override
    public String buildURL(String symbol){
        return prop.getProperty("AAendpoint") + "?"
                + prop.getProperty("AAfunction") + "&"
                + prop.getProperty("AAsymbol")
                + symbol + "&" + prop.getProperty("AAapiKey");
    }
}
