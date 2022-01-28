package ru.ztech.restclient.wb.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import ru.ztech.restclient.wb.IWbFacade;
import ru.ztech.restclient.wb.model.ReportDataDetailByPeriodDto;
import ru.ztech.restclient.wb.model.ReportDataOrdersDto;
import ru.ztech.restclient.wb.model.ReportDataSalesDto;
import ru.ztech.restclient.wb.model.ReportDataStocksDto;

/**
 * WbFacadeImpl
 *
 * @since 0.1 (12-01-2022)
 * @author Гончаров Никита 
 * 
 */
public class WbFacadeImpl implements IWbFacade {
    
    // ~ Статические поля/инициализации =====================================================================
    
    /** Рекомендуем загружать отчет небольшими частями */
    private static final int DEFAULT_LOAD_LIMIT_100000 = 100000;
    private static final int DEFAULT_FLAG_LOAD_ACTUAL = 0;

    // ~ Переменные(свойства) класса ========================================================================
    private RestOperations restOperations;
    
    // ~ Управляемые объекты(Beans) =========================================================================
    private final WbConfigUrl configUrl;
    
    // ~ Конструктор ========================================================================================
    public WbFacadeImpl(WbConfigUrl configUrl) {
        this.configUrl = configUrl;
        final List<HttpMessageConverter<?>> messageConverters = new ArrayList<>(1);
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        this.restOperations = new RestTemplate(messageConverters);
    }
    
    // ~ Методы =============================================================================================
    RestOperations getRestOperations() {
        return this.restOperations;
    }
    
    @Override
    public List<ReportDataDetailByPeriodDto> reportDetailByPeriod(String key, LocalDate dateFrom, LocalDate dateTo, int limit, long rrdid) {
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("apiKey", key);
        uriVariables.put("dateFrom", dateFrom);
        uriVariables.put("dateTo", dateTo);
        uriVariables.put("limit", limit > 0 ? limit : DEFAULT_LOAD_LIMIT_100000);
        uriVariables.put("rrdid", rrdid);
        final ResponseEntity<ReportDataDetailByPeriodDto[]> entity = this.restOperations.getForEntity(this.configUrl.getReportDetailByPeriod(), ReportDataDetailByPeriodDto[].class, uriVariables);
        if (entity.getStatusCodeValue() != 200) {
            throw new IllegalStateException("Ошибка запроса " + entity.getStatusCode());
        } else if (!entity.hasBody()) {
            return null;
        }
        return Arrays.asList(entity.getBody());
    }

    @Override
    public List<ReportDataSalesDto> reportDataSales(String key, LocalDate dateFrom, int flag) {
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("apiKey", key);
        uriVariables.put("dateFrom", dateFrom);
        uriVariables.put("flag", flag > 0 ? flag : DEFAULT_FLAG_LOAD_ACTUAL);
        final ResponseEntity<ReportDataSalesDto[]> entity = this.restOperations.getForEntity(this.configUrl.getReportSales(), ReportDataSalesDto[].class, uriVariables);
        if (entity.getStatusCodeValue() != 200) {
            throw new IllegalStateException("Ошибка запроса " + entity.getStatusCode());
        } else if (!entity.hasBody()) {
            return null;
        }
        return Arrays.asList(entity.getBody());
    }

    @Override
    public List<ReportDataOrdersDto> reportDataOrders(String key, LocalDate dateFrom, int flag) {
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("apiKey", key);
        uriVariables.put("dateFrom", dateFrom);
        uriVariables.put("flag", flag > 0 ? flag : DEFAULT_FLAG_LOAD_ACTUAL);
        final ResponseEntity<ReportDataOrdersDto[]> entity = this.restOperations.getForEntity(this.configUrl.getReportOrders(), ReportDataOrdersDto[].class, uriVariables);
        if (entity.getStatusCodeValue() != 200) {
            throw new IllegalStateException("Ошибка запроса " + entity.getStatusCode());
        } else if (!entity.hasBody()) {
            return null;
        }
        return Arrays.asList(entity.getBody());
    }

    @Override
    public List<ReportDataStocksDto> reportDataStocks(String key, LocalDate dateFrom) {
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("apiKey", key);
        uriVariables.put("dateFrom", dateFrom);
        final ResponseEntity<ReportDataStocksDto[]> entity = this.restOperations.getForEntity(this.configUrl.getReportStocks(), ReportDataStocksDto[].class, uriVariables);
        if (entity.getStatusCodeValue() != 200) {
            throw new IllegalStateException("Ошибка запроса " + entity.getStatusCode());
        } else if (!entity.hasBody()) {
            return null;
        }
        return Arrays.asList(entity.getBody());
    }
    
}
