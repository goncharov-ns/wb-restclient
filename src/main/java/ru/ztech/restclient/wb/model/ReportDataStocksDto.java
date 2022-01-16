package ru.ztech.restclient.wb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Строка отчета Склад
 *
 * @since 0.2(17-01-2022)
 * @author Гончаров Никита 
 * 
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDataStocksDto {
    
    // ~ Статические поля/инициализации =====================================================================
    
    // ~ Переменные(свойства) класса ========================================================================
    /** дата и время обновления информации в сервисе */
    @JsonProperty("lastChangeDate")
    private String lastChangeDate;
    /** ваш артикул */
    @JsonProperty("supplierArticle")
    private String supplierArticle;
    /** размер */
    @JsonProperty("techSize")
    private String techSize;
    /** штрих-код */
    @JsonProperty("Barcode")
    private String Barcode;
    /** кол-во, доступное для продажи */
    @JsonProperty("Quantity")
    private String quantity;
    /** договор поставки */
    @JsonProperty("isSupply")
    private String isSupply;
    /** договор реализации */
    @JsonProperty("isRealization")
    private String isRealization;
    /** кол-во полное */
    @JsonProperty("quantityFull")
    private String quantityFull;
    /** кол-во не в заказе */
    @JsonProperty("quantityNotInOrders")
    private String quantityNotInOrders;
    /** название склада */
    @JsonProperty("warehouseName")
    private String warehouseName;
    /** в пути к клиенту (штук) */
    @JsonProperty("inWayToClient")
    private String inWayToClient;
    /** в пути от клиента (штук) */
    @JsonProperty("inWayFromClient")
    private String inWayFromClient;
    /** код WB */
    @JsonProperty("nmid")
    private String nmid;
    /** предмет */
    @JsonProperty("subject")
    private String subject;
    /** категория */
    @JsonProperty("category")
    private String category;
    /** кол-во дней на сайте */
    @JsonProperty("DaysOnSite")
    private String daysOnSite;
    /** бренд */
    @JsonProperty("brand")
    private String brand;
    /** код контракта */
    @JsonProperty("SCCode")
    private String scCode;
    
    // ~ Управляемые объекты(Beans) =========================================================================
    
    // ~ Конструктор ========================================================================================
    
    // ~ Методы =============================================================================================
    
    // ~ Доступ к свойствам =================================================================================
    
}
