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
import ru.ztech.restclient.wb.model.ReportSaleBySalesDto;

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
    @Override
    public List<ReportSaleBySalesDto> reportSaleBySales(String key, LocalDate dateFrom, LocalDate dateTo, int limit, int rrdid) {
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("key", key);
        uriVariables.put("dateFrom", dateFrom);
        uriVariables.put("dateTo", dateTo);
        uriVariables.put("limit", limit > 0 ? limit : DEFAULT_LOAD_LIMIT_100000);
        uriVariables.put("rrdid", rrdid);
        final ResponseEntity<ReportSaleBySalesDto[]> entity = this.restOperations.getForEntity(this.configUrl.getReportSaleBySales(), ReportSaleBySalesDto[].class, uriVariables);
        if (entity.getStatusCodeValue() != 200) {
            throw new IllegalStateException("Ошибка запроса " + entity.getStatusCode());
        } else if (!entity.hasBody()) {
            return null;
        }
        return Arrays.asList(entity.getBody());
    }
    
}
