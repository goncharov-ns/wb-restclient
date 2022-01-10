package ru.ztech.restclient.wb;

import org.junit.jupiter.api.Test;

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
    void loadReportSaleBySalesSuccess() {
        IWbFacade s = null;
        ReportSaleBySalesDto data = new ReportSaleBySalesDto();
        data.getRealizationreportId();
    }
}
