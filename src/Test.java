import InvestorToolsGUI.StockQuoteGUI;
import StockQuote.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        //StockQuote sq = new StockQuote();
        StockQuote aaSQ = new AlphaAdvantageStockQuote("sofi");
        StockQuote fhSQ = new FinnhubStockQuote("bac");

        //StockQuoteGUI sGUI = new StockQuoteGUI();
    }
}
