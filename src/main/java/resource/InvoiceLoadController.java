package resource;

import model.Metrics;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.InvoiceLoadService;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("InvoiceLoad")
public class InvoiceLoadController {

    private InvoiceLoadService invoiceLoadService;

    public InvoiceLoadController() {

        this.invoiceLoadService = new InvoiceLoadService();
    }

    @RequestMapping(value = "/insert")
    public String insert() {

        Metrics metrics = new Metrics();
        String date_1;
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {

            date_1 = simpleDateFormat.format(new Date());
            metrics.setFileName("Invoice");
            metrics.setBillingDate(date_1);
            metrics.setExpectedRowCount(100);
            metrics.setRowCount(100);
            metrics.setStartingRowCount(0);

            System.err.println(date_1);

        } catch (Exception ex) {

            System.err.println(ex.getMessage());
        }

        return invoiceLoadService.Insert("metrics", "csvload", metrics);
    }
}
