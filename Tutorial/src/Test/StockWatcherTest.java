package Test;

import com.mySampleApplication.client.StockPrice;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class StockWatcherTest {

    /**
     * Verify that the instance fields in the StockPrice class are set correctly.
     */
    @Test
    public void testStockPriceCtor() {
        String symbol = "XYZ";
        double price = 70.0;
        double change = 2.0;
        double changePercent = 100.0 * change / price;

        StockPrice sp = new StockPrice(symbol, price, change);
        assertNotNull(sp);
        assertEquals(symbol, sp.getSymbol());
        assertEquals(price, sp.getPrice(), 0.001);
        assertEquals(change, sp.getChange(), 0.001);
        assertEquals(changePercent, sp.getChangePercent(), 0.001);
    }
}
