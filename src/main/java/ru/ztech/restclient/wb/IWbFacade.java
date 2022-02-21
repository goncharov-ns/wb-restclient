package ru.ztech.restclient.wb;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import ru.ztech.restclient.wb.model.ReportDataDetailByPeriodDto;
import ru.ztech.restclient.wb.model.ReportDataOrdersDto;
import ru.ztech.restclient.wb.model.ReportDataSalesDto;
import ru.ztech.restclient.wb.model.ReportDataStocksDto;

/**
 * Фасад wildberries сервисов
 *
 * @version 0.3
 * @since 0.1 (11-01-2022)
 * @author Гончаров Никита 
 * 
 */
public interface IWbFacade {
    
    /**
     * Проверка что ключ валидный 
     * 
     * @param key - ключ, выдаваемый поставщику
     * @return true - ключ валидный
     * @throws WbApiException - Ошибки сети/сервера не связанные с авторизацией
     */
    boolean isValidApiKey(String key) throws WbApiException;
    
    /**
     * Отчет о продажах по реализации
     * 
     * @param key - ключ, выдаваемый поставщику
     * @param dateFrom - начальная дата периода. Например, если dateFrom = 2020-07-06, то в 
результате вызова API будет получен отчет за неделю от 06 по 12 июля 2020 года
     * @param dateTo – конечная дата периода
     * @param limit – максимальное количество строк отчета получаемых в результате вызова API. 
Рекомендуем загружать отчет небольшими частями, например, по 100 000 строк на один вызов
     * @param rrdid – уникальный идентификатор строки отчета. Необходим для получения отчета 
частями. Загрузку отчета нужно начинать с rrdid = 0, и при последующих вызовах API
передавать максимальное значение rrdid полученное в результате предыдущего 
вызова. Таким образом для загрузки одного отчета может понадобится вызывать API до 
тех пор, пока количество возвращаемых строк не станет равным нулю
     *
     * @return Список объектов отчета, список не <code>NULL</code>
     * @throws WbApiException - Ошибки сети/сервера/авторизации
     */
    List<ReportDataDetailByPeriodDto> reportDetailByPeriod(String key, LocalDate dateFrom, LocalDate dateTo, int limit, long rrdid) throws WbApiException;
    
    /**
     * Продажи
     * 
     * @param key - ключ, выдаваемый поставщику
     * @param dateFrom - начальная дата периода. Например, если dateFrom = 2020-07-06, то в 
результате вызова API будет получен отчет за неделю от 06 по 12 июля 2020 года
     * @param flag - Если 0 (или не указан в строке запроса), при вызове API возвращаются данные у которых значение поля lastChangeDate
     * 
     * @return Список объектов отчета, список не <code>NULL</code>
     * @throws WbApiException - Ошибки сети/сервера/авторизации
     */
    List<ReportDataSalesDto> reportDataSales(String key, LocalDateTime dateFrom, int flag) throws WbApiException;
    
    /**
     * Заказы
     * 
     * @param key - ключ, выдаваемый поставщику
     * @param dateFrom - начальная дата периода. Например, если dateFrom = 2020-07-06, то в 
результате вызова API будет получен отчет за неделю от 06 по 12 июля 2020 года
     * @param flag - Если 0 (или не указан в строке запроса), при вызове API возвращаются данные у которых значение поля lastChangeDate
     * 
     * @return Список объектов отчета, список не <code>NULL</code>
     * @throws WbApiException - Ошибки сети/сервера/авторизации
     */
    List<ReportDataOrdersDto> reportDataOrders(String key, LocalDateTime dateFrom, int flag) throws WbApiException;
    
    /**
     * Склад
     * 
     * @param key - ключ, выдаваемый поставщику
     * @param dateFrom - начальная дата периода. Например, если dateFrom = 2020-07-06, то в 
результате вызова API будет получен отчет за неделю от 06 по 12 июля 2020 года
     *
     * @return Список объектов отчета, список не <code>NULL</code>
     * @throws WbApiException - Ошибки сети/сервера/авторизации
     */
    List<ReportDataStocksDto> reportDataStocks(String key, LocalDateTime dateFrom) throws WbApiException;
}
