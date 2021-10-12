package StockQuote;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

public class FinnhubStockQuote extends StockQuote{

    public FinnhubStockQuote(String symbol) throws InterruptedException, IOException {
        super(symbol.toUpperCase(Locale.ROOT));

        oldKey = new String[] {"s", "c", "o", "h", "l", "v", "pc", "d", "dp"};

        originalJsonBody = new JSONObject(response.body());
        appendOriginalJSON(symbol);

        updatedJsonBody = new JSONObject();

        createGenericQuoteFile(symbol);
    }

    //Creates REST call for a quote for Finnhub based on passed ticker symbol
    @Override
    public String buildURL(String symbol){
        return prop.getProperty("FHendpoint") + "?"
                + prop.getProperty("FHsymbol")
                + symbol + "&" + prop.getProperty("FHapiKey");
    }

    //Appends symbols to the Finhub JSON Object to make is uniform for generic quotes
    public void appendOriginalJSON(String symbol){
        originalJsonBody.put("v", 0);
        originalJsonBody.put("s", symbol);
    }
}
