package ru.ztech.restclient.wb.impl;

/**
 * WbConfigUrl
 *
 * @since 0.1 (12-01-2022)
 * @author Гончаров Никита 
 * 
 */
public class WbConfigUrl {

    // ~ Статические поля/инициализации =====================================================================
    
    // ~ Переменные(свойства) класса ========================================================================
    
    // ~ Управляемые объекты(Beans) =========================================================================
    
    // ~ Конструктор ========================================================================================
    
    // ~ Методы =============================================================================================
    public String getReportStocks() {
        return getBaseWbUrl() + "stocks?dateFrom={dateFrom}&key={apiKey}";
    }
    
    public String getReportOrders() {
        return getBaseWbUrl() + "orders?dateFrom={dateFrom}&flag={flag}&key={apiKey}";
    }
    
    public String getReportSales() {
        return getBaseWbUrl() + "sales?dateFrom={dateFrom}&flag={flag}&key={apiKey}";
    }
    
    public String getReportDetailByPeriod() {
        return getBaseWbUrl() + "reportDetailByPeriod?dateFrom={dateFrom}&key={apiKey}&limit={limit}&rrdid={rrdid}&dateto={dateTo}";
    }
    
    private String getBaseWbUrl() {
        return "https://suppliers-stats.wildberries.ru/api/v1/supplier/";
    }
    
    // ~ Доступ к свойствам =================================================================================
    
}
