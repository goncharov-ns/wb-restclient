package ru.ztech.restclient.wb;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ru.ztech.restclient.wb.impl.WbConfigUrl;
import ru.ztech.restclient.wb.impl.WbFacadeImpl;
import ru.ztech.restclient.wb.model.ReportDataDetailByPeriodDto;
import ru.ztech.restclient.wb.model.ReportDataOrdersDto;
import ru.ztech.restclient.wb.model.ReportDataSalesDto;
import ru.ztech.restclient.wb.model.ReportDataStocksDto;

/**
 * Тест для реального вызова АПИ
 *
 * @since 0.1 (11-01-2022)
 * @author Гончаров Никита 
 * 
 */
@Disabled("Disabled until Run with Real ApiKey! Set as wb.api.key in System")
public class WbFacadeRealTest {
    
    private static final String KEY = System.getProperty("wb.api.key");
    private static final IWbFacade facade = new WbFacadeImpl(new WbConfigUrl());
    
    @Test
    void loadReportDetailByPeriodSuccessReal() throws WbApiException {
        List<ReportDataDetailByPeriodDto> list = facade.reportDetailByPeriod(KEY, LocalDate.parse("2021-12-01"), LocalDate.now(), 0, 0);
        System.out.println("Result:\n");
        for (ReportDataDetailByPeriodDto reportSaleBySalesDto : list) {
            System.out.println("\t" + reportSaleBySalesDto);
        }
    }
    
    @Test
    void loadReportDataSalesSuccessReal() throws WbApiException {
        List<ReportDataSalesDto> list = facade.reportDataSales(KEY, LocalDate.parse("2021-12-01"), 0);
        System.out.println("Result:\n");
        for (ReportDataSalesDto reportSaleBySalesDto : list) {
            System.out.println("\t" + reportSaleBySalesDto);
        }
    }
    
    @Test
    void loadReportDataOrdersSuccessReal() throws WbApiException {
        List<ReportDataOrdersDto> list = facade.reportDataOrders(KEY, LocalDate.parse("2021-12-01"), 0);
        System.out.println("Result:\n");
        for (ReportDataOrdersDto reportSaleBySalesDto : list) {
            System.out.println("\t" + reportSaleBySalesDto);
        }
    }
    
    @Test
    void loadReportDataStocksSuccessReal() throws WbApiException {
        List<ReportDataStocksDto> list = facade.reportDataStocks(KEY, LocalDate.parse("2021-12-01"));
        System.out.println("Result:\n");
        for (ReportDataStocksDto reportSaleBySalesDto : list) {
            System.out.println("\t" + reportSaleBySalesDto);
        }
    }
}
