package ru.ztech.restclient.wb;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import ru.ztech.restclient.wb.impl.WbConfigUrl;
import ru.ztech.restclient.wb.impl.WbFacadeImpl;
import ru.ztech.restclient.wb.model.ReportSaleBySalesDto;

/**
 * WbFacadeTest
 *
 * @since 0.1 (11-01-2022)
 * @author Гончаров Никита 
 * 
 */
public class WbFacadeTest {

    @Test
    void loadReportSaleBySalesSuccessReal() {
        WbConfigUrl configUrl = new WbConfigUrl();
        IWbFacade facade = new WbFacadeImpl(configUrl);
        String key = System.getProperty("wb.api.key");
        
        List<ReportSaleBySalesDto> list = facade.reportSaleBySales(key, LocalDate.parse("2021-12-01"), LocalDate.now(), 0, 0);
        System.out.println("Result:\n");
        for (ReportSaleBySalesDto reportSaleBySalesDto : list) {
            System.out.println("\t" + reportSaleBySalesDto);
        }
    }
}
