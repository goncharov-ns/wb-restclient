package ru.ztech.restclient.wb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Строка отчета Продажи
 *
 * @since 0.2(17-01-2022)
 * @author Гончаров Никита 
 * 
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDataSalesDto {
    
    // ~ Статические поля/инициализации =====================================================================
    
    // ~ Переменные(свойства) класса ========================================================================
    /** номер документа */
    @JsonProperty("Number")
    private String number;
    /** дата продажи */
    @JsonProperty("Date")
    private String date;
    /** дата время обновления информации в сервисе */
    @JsonProperty("lastChangeDate")
    private String lastChangeDate;
    /** ваш артикул */
    @JsonProperty("supplierArticle")
    private String supplierArticle;
    /** размер */
    @JsonProperty("techSize")
    private String techSize;
    /** штрих-код */
    @JsonProperty("barcode")
    private String barcode;
    /** кол-во */
    @JsonProperty("quantity")
    private String quantity;
    /** начальная розничная цена товара */
    @JsonProperty("totalPrice")
    private String totalPrice;
    /** согласованная скидка на товар */
    @JsonProperty("discountPercent")
    private String discountPercent;
    /** договор поставки */
    @JsonProperty("isSupply")
    private String isSupply;
    /** договор реализации */
    @JsonProperty("isRealization")
    private String isRealization;
    /** номер исходного заказа ("Номер заказа" из сервиса "Заказы") */
    @JsonProperty("orderId")
    private String orderId;
    /** согласованный промокод */
    @JsonProperty("promoCodeDiscount")
    private String promoCodeDiscount;
    /** склад отгрузки */
    @JsonProperty("warehouseName")
    private String warehouseName;
    /** страна */
    @JsonProperty("countryName")
    private String countryName;
    /** округ */
    @JsonProperty("oblastOkrugName")
    private String oblastOkrugName;
    /** регион */
    @JsonProperty("regionName")
    private String regionName;
    /** номер поставки */
    @JsonProperty("incomeID")
    private String incomeID;
    /** уникальный идентификатор продажи/возврата (SXXXXXXXXXX — продажа, RXXXXXXXXXX - возврат, DXXXXXXXXXXX — доплата) */
    @JsonProperty("saleID")
    private String saleID;
    /** уникальный идентификатор позиции заказа */
    @JsonProperty("odid")
    private String odid;
    /** согласованная скидка постоянного покупателя (СПП) */
    @JsonProperty("spp")
    private String spp;
    /** к перечислению поставщику */
    @JsonProperty("forpay")
    private String forpay;
    /** фактическая цена из заказа (с учетом всех скидок, включая и от ВБ) */
    @JsonProperty("finished_price")
    private String finishedPrice;
    /** цена, от которой считается вознаграждение поставщика forpay */
    @JsonProperty("pricewithdisc")
    private String pricewithdisc;
    /** код WB */
    @JsonProperty("nmId")
    private String nmId;
    /** предмет */
    @JsonProperty("subject")
    private String subject;
    /** категория */
    @JsonProperty("category")
    private String category;
    /** бренд */
    @JsonProperty("brand")
    private String brand;
    /** 1-продажа сторнирована, 0 – не сторнирована */
    @JsonProperty("IsStorno")
    private String isStorno;
    
    // ~ Управляемые объекты(Beans) =========================================================================
    
    // ~ Конструктор ========================================================================================
    
    // ~ Методы =============================================================================================
    
    // ~ Доступ к свойствам =================================================================================
    
}
