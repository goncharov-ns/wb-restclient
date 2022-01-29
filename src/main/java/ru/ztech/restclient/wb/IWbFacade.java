package ru.ztech.restclient.wb;

import java.time.LocalDate;
import java.util.List;

import ru.ztech.restclient.wb.model.ReportDataDetailByPeriodDto;
import ru.ztech.restclient.wb.model.ReportDataOrdersDto;
import ru.ztech.restclient.wb.model.ReportDataSalesDto;
import ru.ztech.restclient.wb.model.ReportDataStocksDto;

/**
 * Фасад wildberries сервисов
 *
 * @since 0.1 (11-01-2022)
 * @author Гончаров Никита 
 * 
 */
public interface IWbFacade {
    
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
     */
    List<ReportDataDetailByPeriodDto> reportDetailByPeriod(String key, LocalDate dateFrom, LocalDate dateTo, int limit, long rrdid);
    
    /**
     * Продажи
     * 
     * @param key - ключ, выдаваемый поставщику
     * @param dateFrom - начальная дата периода. Например, если dateFrom = 2020-07-06, то в 
результате вызова API будет получен отчет за неделю от 06 по 12 июля 2020 года
     * @param flag - Если 0 (или не указан в строке запроса), при вызове API возвращаются данные у которых значение поля lastChangeDate
     * 
     * @return Список объектов отчета, список не <code>NULL</code>
     */
    List<ReportDataSalesDto> reportDataSales(String key, LocalDate dateFrom, int flag);
    
    /**
     * Заказы
     * 
     * @param key - ключ, выдаваемый поставщику
     * @param dateFrom - начальная дата периода. Например, если dateFrom = 2020-07-06, то в 
результате вызова API будет получен отчет за неделю от 06 по 12 июля 2020 года
     * @param flag - Если 0 (или не указан в строке запроса), при вызове API возвращаются данные у которых значение поля lastChangeDate
     * 
     * @return Список объектов отчета, список не <code>NULL</code>
     */
    List<ReportDataOrdersDto> reportDataOrders(String key, LocalDate dateFrom, int flag);
    
    /**
     * Склад
     * 
     * @param key - ключ, выдаваемый поставщику
     * @param dateFrom - начальная дата периода. Например, если dateFrom = 2020-07-06, то в 
результате вызова API будет получен отчет за неделю от 06 по 12 июля 2020 года
     *
     * @return Список объектов отчета, список не <code>NULL</code>
     */
    List<ReportDataStocksDto> reportDataStocks(String key, LocalDate dateFrom);
}
