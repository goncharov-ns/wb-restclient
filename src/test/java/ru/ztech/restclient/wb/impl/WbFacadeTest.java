package ru.ztech.restclient.wb.impl;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestToUriTemplate;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;

import ru.ztech.restclient.wb.IWbFacade;
import ru.ztech.restclient.wb.model.ReportDataDetailByPeriodDto;
import ru.ztech.restclient.wb.model.ReportDataOrdersDto;
import ru.ztech.restclient.wb.model.ReportDataSalesDto;
import ru.ztech.restclient.wb.model.ReportDataStocksDto;

/**
 * WbFacadeTest
 *
 * @since 0.2 (11-01-2022)
 * @author Гончаров Никита 
 * 
 */
public class WbFacadeTest {
    
    private static final IWbFacade facade = new WbFacadeImpl(new WbConfigUrl());
    private static final String P_KEY = "api-key";
    private static final LocalDate P_DATE_FROM = LocalDate.parse("2021-12-01");
    private static final LocalDateTime P_DATETIME_FROM = LocalDateTime.parse("2021-12-01T00:00:00");
    private static MockRestServiceServer mockServer;
    
    @BeforeAll
    public static void init() throws Exception {
        mockServer = MockRestServiceServer.createServer(((WbFacadeImpl) facade).getRestTemplate());
    }
    
    private void mockRest(String stub, String url, Object... params) throws Exception {
        final String wbBaseUrl = "https://suppliers-stats.wildberries.ru/api/v1/supplier/";
        mockServer.reset();
        mockServer.expect(ExpectedCount.once(), requestToUriTemplate(wbBaseUrl + url, params))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(IOUtils.toString(WbFacadeTest.class.getResourceAsStream("/data/" + stub + ".json"), Charset.forName("UTF-8")))
              );
    }
    
    private void checkRest(List<?> list) {
        mockServer.verify();
        org.junit.jupiter.api.Assertions.assertTrue(!list.isEmpty(), "Ошибка парсинка список пустой");
        for (Object object : list) {
            org.assertj.core.api.Assertions.assertThat(object).hasNoNullFieldsOrProperties();
        }
    }
    
    @Test
    void loadReportDetailByPeriodSuccessReal() throws Exception {
        LocalDate dateTo = LocalDate.now();
        mockRest("salebysales", "/reportDetailByPeriod?dateFrom={dateFrom}&key={apiKey}&limit={limit}&rrdid={rrdid}&dateto={dateTo}", P_DATE_FROM, P_KEY, 100000, 0, dateTo);
        List<ReportDataDetailByPeriodDto> list = facade.reportDetailByPeriod(P_KEY, P_DATE_FROM, dateTo, 0, 0);
        System.out.println("Result:\n");
        for (ReportDataDetailByPeriodDto reportSaleBySalesDto : list) {
            System.out.println("\t" + reportSaleBySalesDto);
        }
        checkRest(list);
    }

    @Test
    void loadReportDataSalesSuccessReal() throws Exception {
        mockRest("sales", "/sales?dateFrom={dateFrom}&flag={flag}&key={apiKey}", P_DATETIME_FROM, 0, P_KEY);
        List<ReportDataSalesDto> list = facade.reportDataSales(P_KEY, P_DATETIME_FROM, 0);
        System.out.println("Result:\n");
        for (ReportDataSalesDto reportSaleBySalesDto : list) {
            System.out.println("\t" + reportSaleBySalesDto);
        }
        checkRest(list);
    }
    
    @Test
    void loadReportDataOrdersSuccessReal() throws Exception {
        mockRest("orders", "/orders?dateFrom={dateFrom}&flag={flag}&key={apiKey}", P_DATETIME_FROM, 0, P_KEY);
        List<ReportDataOrdersDto> list = facade.reportDataOrders(P_KEY, P_DATETIME_FROM, 0);
        System.out.println("Result:\n");
        for (ReportDataOrdersDto reportSaleBySalesDto : list) {
            System.out.println("\t" + reportSaleBySalesDto);
        }
        checkRest(list);
    }
    
    @Test
    void loadReportDataStocksSuccessReal() throws Exception {
        mockRest("stocks", "/stocks?dateFrom={dateFrom}&key={apiKey}", P_DATETIME_FROM, P_KEY);
        List<ReportDataStocksDto> list = facade.reportDataStocks(P_KEY, P_DATETIME_FROM);
        System.out.println("Result:\n");
        for (ReportDataStocksDto reportSaleBySalesDto : list) {
            System.out.println("\t" + reportSaleBySalesDto);
        }
        checkRest(list);
    }
}
