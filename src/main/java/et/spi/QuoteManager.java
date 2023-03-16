package et.spi;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tishko
 * Date: 2/22/2023
 * Time: 4:13 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public interface QuoteManager {
    List<Quote> getQuotes(String baseCurrency, LocalDate date);
}
