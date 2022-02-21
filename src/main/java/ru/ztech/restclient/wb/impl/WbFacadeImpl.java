package ru.ztech.restclient.wb.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.TooManyRequests;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import ru.ztech.restclient.wb.IWbFacade;
import ru.ztech.restclient.wb.WbApiException;
import ru.ztech.restclient.wb.model.ReportDataDetailByPeriodDto;
import ru.ztech.restclient.wb.model.ReportDataOrdersDto;
import ru.ztech.restclient.wb.model.ReportDataSalesDto;
import ru.ztech.restclient.wb.model.ReportDataStocksDto;

/**
 * Реализация получения данных из WB
 *
 * @since 0.1 (12-01-2022)
 * @author Гончаров Никита 
 * 
 */
@Slf4j
public class WbFacadeImpl implements IWbFacade {
    
    // ~ Статические поля/инициализации =====================================================================
    
    /** Рекомендуем загружать отчет небольшими частями */
    private static final int DEFAULT_LOAD_LIMIT_100000 = 100000;
    private static final int DEFAULT_FLAG_LOAD_ACTUAL = 0;

    // ~ Переменные(свойства) класса ========================================================================
    private final RestOperations restOperations;
    private final WbConfigUrl configUrl;
    
    // ~ Конструктор ========================================================================================
    public WbFacadeImpl(WbConfigUrl configUrl) {
        this.configUrl = configUrl;
        final List<HttpMessageConverter<?>> messageConverters = new ArrayList<>(1);
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        this.restOperations = new RestTemplate(messageConverters);
    }
    
    // ~ Методы =============================================================================================
    RestTemplate getRestTemplate() {
        return (RestTemplate) this.restOperations;
    }
    
    @Override
    public List<ReportDataDetailByPeriodDto> reportDetailByPeriod(String key, LocalDate dateFrom, LocalDate dateTo, int limit, long rrdid) throws WbApiException {
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("apiKey", key);
        uriVariables.put("dateFrom", dateFrom);
        uriVariables.put("dateTo", dateTo);
        uriVariables.put("limit", limit > 0 ? limit : DEFAULT_LOAD_LIMIT_100000);
        uriVariables.put("rrdid", rrdid);
        final ResponseEntity<ReportDataDetailByPeriodDto[]> entity;
        try {
            entity = this.restOperations.getForEntity(this.configUrl.getReportDetailByPeriod(), ReportDataDetailByPeriodDto[].class, uriVariables);
        } catch (Exception e) {
            throw handlerException(e);
        }
        if (!entity.hasBody()) {
            return Collections.emptyList();
        }
        return Arrays.asList(entity.getBody());
    }

    @Override
    public List<ReportDataSalesDto> reportDataSales(String key, LocalDateTime dateFrom, int flag) throws WbApiException {
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("apiKey", key);
        uriVariables.put("dateFrom", dateFrom);
        uriVariables.put("flag", flag > 0 ? flag : DEFAULT_FLAG_LOAD_ACTUAL);
        final ResponseEntity<ReportDataSalesDto[]> entity;
        try {
            entity = this.restOperations.getForEntity(this.configUrl.getReportSales(), ReportDataSalesDto[].class, uriVariables);
        } catch (Exception e) {
            throw handlerException(e);
        }
        if (!entity.hasBody()) {
            return Collections.emptyList();
        }
        return Arrays.asList(entity.getBody());
    }

    @Override
    public List<ReportDataOrdersDto> reportDataOrders(String key, LocalDateTime dateFrom, int flag) throws WbApiException {
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("apiKey", key);
        uriVariables.put("dateFrom", dateFrom);
        uriVariables.put("flag", flag > 0 ? flag : DEFAULT_FLAG_LOAD_ACTUAL);
        final ResponseEntity<ReportDataOrdersDto[]> entity;
        try {
            entity = this.restOperations.getForEntity(this.configUrl.getReportOrders(), ReportDataOrdersDto[].class, uriVariables);
        } catch (Exception e) {
            throw handlerException(e);
        }
        if (!entity.hasBody()) {
            return Collections.emptyList();
        }
        return Arrays.asList(entity.getBody());
    }

    @Override
    public List<ReportDataStocksDto> reportDataStocks(String key, LocalDateTime dateFrom) throws WbApiException {
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("apiKey", key);
        uriVariables.put("dateFrom", dateFrom);
        final ResponseEntity<ReportDataStocksDto[]> entity;
        try {
            entity = this.restOperations.getForEntity(this.configUrl.getReportStocks(), ReportDataStocksDto[].class, uriVariables);
        } catch (Exception e) {
            throw handlerException(e);
        }
        if (!entity.hasBody()) {
            return Collections.emptyList();
        }
        return Arrays.asList(entity.getBody());
    }
    
    @Override
    public boolean isValidApiKey(String key) throws WbApiException {
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("apiKey", key);
        uriVariables.put("dateFrom", LocalDateTime.now());
        uriVariables.put("flag", 1);
        try {
            log.trace("Ссылка для проверка ключа " + this.configUrl.getReportOrders());
            final ResponseEntity<String> entity = this.restOperations.getForEntity(this.configUrl.getReportOrders(), String.class, uriVariables);
            log.trace("Ответ от WB " + entity);
        } catch (TooManyRequests e) {
            log.trace("return true потому что получили TooManyRequests", e);
            return true;
        } catch (BadRequest | Unauthorized e) {
            log.trace("return false потому что получили BadRequest | Unauthorized", e);
            return false;
        } catch (Exception e) {
            throw handlerException(e);
        }
        return true;
    }
    
    private WbApiException handlerException(Exception e) {
        RestClientResponseException re = null;
        if (e instanceof HttpStatusCodeException) {
            re = (RestClientResponseException) e;
        } else {
            re = new RestClientResponseException(e.getMessage(), 999, null, null, null, null);
        }
        return new WbApiException(re, e);
    }

}
