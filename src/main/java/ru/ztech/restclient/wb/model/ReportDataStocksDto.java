package ru.ztech.restclient.wb.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.ztech.restclient.wb.jackson.FlexiblePriceDeserializer;

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
    private LocalDateTime lastChangeDate;
    /** ваш артикул */
    @JsonProperty("supplierArticle")
    private String supplierArticle;
    /** размер */
    @JsonProperty("techSize")
    private String techSize;
    /** штрих-код */
    @JsonProperty("barcode")
    private String barcode;
    /** кол-во, доступное для продажи */
    @JsonProperty("quantity")
    private Integer quantity;
    /** договор поставки */
    @JsonProperty("isSupply")
    private Boolean isSupply;
    /** договор реализации */
    @JsonProperty("isRealization")
    private Boolean isRealization;
    /** кол-во полное */
    @JsonProperty("quantityFull")
    private Integer quantityFull;
    /** кол-во не в заказе */
    @JsonProperty("quantityNotInOrders")
    private Integer quantityNotInOrders;
    /** название склада */
    @JsonProperty("warehouseName")
    private String warehouseName;
    /** в пути к клиенту (штук) */
    @JsonProperty("inWayToClient")
    private Integer inWayToClient;
    /** в пути от клиента (штук) */
    @JsonProperty("inWayFromClient")
    private Integer inWayFromClient;
    /** код WB */
    @JsonProperty("nmId")
    private Long nmId;
    /** предмет */
    @JsonProperty("subject")
    private String subject;
    /** категория */
    @JsonProperty("category")
    private String category;
    /** кол-во дней на сайте */
    @JsonProperty("daysOnSite")
    private Integer daysOnSite;
    /** бренд */
    @JsonProperty("brand")
    private String brand;
    /** код контракта */
    @JsonProperty("SCCode")
    private String scCode;
    /** цена */
    @JsonProperty("Price")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double price;
    /** Скидка */
    @JsonProperty("Discount")
    private Integer discount;
    
    // ~ Управляемые объекты(Beans) =========================================================================
    
    // ~ Конструктор ========================================================================================
    
    // ~ Методы =============================================================================================
    
    // ~ Доступ к свойствам =================================================================================
    
}
