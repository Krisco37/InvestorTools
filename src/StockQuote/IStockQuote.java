package StockQuote;

import java.io.IOException;

public interface IStockQuote {
    public void loadProperties() throws IOException;
    public String buildURL(String symbol);
    public void httpConnector(String url, String symbol) throws IOException, InterruptedException;
}
