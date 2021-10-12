package InvestorToolsGUI;

import javax.swing.*;

public class StockQuoteGUI {

    JFrame masterFrame;
    JButton getQuote;

    public StockQuoteGUI(){
        masterFrame = new JFrame("Investor Tools");
        getQuote = new JButton("Get Quote");

        createMasterFrame();
    }

    public void createMasterFrame(){
        masterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        masterFrame.setSize(600,600);
        masterFrame.getContentPane().add(getQuote);
        masterFrame.setLocationRelativeTo(null);
        masterFrame.setVisible(true);
    }
}
