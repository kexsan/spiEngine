package et.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by IntelliJ IDEA.
 * User: tishko
 * Date: 2/22/2023
 * Time: 5:15 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class ExchangeRate
{

    static ServiceLoader<ExchangeRateProvider> loader = ServiceLoader
            .load(ExchangeRateProvider.class);

    public static Iterator<ExchangeRateProvider> providers(boolean refresh) {
        if (refresh) {
            loader.reload();
        }
        return loader.iterator();
    }
}
