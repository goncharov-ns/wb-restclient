package ru.ztech.restclient.wb.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.ztech.restclient.wb.jackson.FlexiblePriceDeserializer;

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
    @JsonProperty("number")
    private String number;
    /** дата продажи */
    @JsonProperty("date")
    private LocalDateTime date;
    /** дата время обновления информации в сервисе */
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
    /** кол-во */
    @JsonProperty("quantity")
    private Integer quantity;
    /** начальная розничная цена товара */
    @JsonProperty("totalPrice")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double totalPrice;
    /** согласованная скидка на товар */
    @JsonProperty("discountPercent")
    private Integer discountPercent;
    /** договор поставки */
    @JsonProperty("isSupply")
    private Boolean isSupply;
    /** договор реализации */
    @JsonProperty("isRealization")
    private Boolean isRealization;
    /** номер исходного заказа ("Номер заказа" из сервиса "Заказы") */
    @JsonProperty("orderId")
    private String orderId;
    /** согласованный промокод */
    @JsonProperty("promoCodeDiscount")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double promoCodeDiscount;
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
    private Long incomeID;
    /** уникальный идентификатор продажи/возврата (SXXXXXXXXXX — продажа, RXXXXXXXXXX - возврат, DXXXXXXXXXXX — доплата) */
    @JsonProperty("saleID")
    private String saleID;
    /** уникальный идентификатор позиции заказа */
    @JsonProperty("odid")
    private Long odid;
    /** согласованная скидка постоянного покупателя (СПП) */
    @JsonProperty("spp")
    private Integer spp;
    /** к перечислению поставщику */
    @JsonProperty("forPay")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double forPay;
    /** фактическая цена из заказа (с учетом всех скидок, включая и от ВБ) */
    @JsonProperty("finishedPrice")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double finishedPrice;
    /** цена, от которой считается вознаграждение поставщика forpay */
    @JsonProperty("priceWithDisc")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double priceWithDisc;
    /** код WB */
    @JsonProperty("nmId")
    private Long nmId;
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
    @JsonFormat(shape = Shape.NUMBER)
    private Boolean isStorno;
    
    // ~ Управляемые объекты(Beans) =========================================================================
    
    // ~ Конструктор ========================================================================================
    
    // ~ Методы =============================================================================================
    
    // ~ Доступ к свойствам =================================================================================
    
}
