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
 * Строка отчета Заказы
 *
 * @since 0.2(17-01-2022)
 * @author Гончаров Никита 
 * 
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDataOrdersDto {
    
    // ~ Статические поля/инициализации =====================================================================
    
    // ~ Переменные(свойства) класса ========================================================================
    /** номер заказа */
    @JsonProperty("number")
    private Long number;
    /** дата заказа */
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
    /** цена до согласованной скидки/промо/спп */
    @JsonProperty("totalPrice")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double totalPrice;
    /** согласованный итоговый дисконт. */
    @JsonProperty("discountPercent")
    private Integer discountPercent;
    /** склад отгрузки */
    @JsonProperty("warehouseName")
    private String warehouseName;
    /** область */
    @JsonProperty("oblast")
    private String oblast;
    /** номер поставки */
    @JsonProperty("incomeID")
    private Long incomeID;
    /** уникальный идентификатор позиции заказа */
    @JsonProperty("odid")
    private Long odid;
    /** Код WB */
    @JsonProperty("nmId")
    private Long nmid;
    /** предмет */
    @JsonProperty("subject")
    private String subject;
    /** категория */
    @JsonProperty("category")
    private String category;
    /** бренд */
    @JsonProperty("brand")
    private String brand;
    /** признак отмены заказа */
    @JsonProperty("isCancel")
    private Boolean isCancel;
    /** дата отмены заказа */
    @JsonProperty("cancel_dt")
    private LocalDateTime cancelDt;
    
    // ~ Управляемые объекты(Beans) =========================================================================
    
    // ~ Конструктор ========================================================================================
    
    // ~ Методы =============================================================================================
    
    // ~ Доступ к свойствам =================================================================================
    
}
