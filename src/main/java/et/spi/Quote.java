package et.spi;

import lombok.ToString;

import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * User: tishko
 * Date: 2/22/2023
 * Time: 4:12 PM
 * To change this template use File | Settings | File and Code Templates.
 */
@ToString
public class Quote
{
    private String currency;
    private LocalDate date;

    public Quote(String currency, LocalDate date)
    {
        this.currency = currency;
        this.date = date;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
}
