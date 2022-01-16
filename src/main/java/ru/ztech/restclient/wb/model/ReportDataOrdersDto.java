package ru.ztech.restclient.wb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private String number;
    /** дата заказа */
    @JsonProperty("date")
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
    /** цена до согласованной скидки/промо/спп */
    @JsonProperty("totalPrice")
    private String totalPrice;
    /** согласованный итоговый дисконт. */
    @JsonProperty("discountPercent")
    private String discountPercent;
    /** склад отгрузки */
    @JsonProperty("warehouseName")
    private String warehouseName;
    /** область */
    @JsonProperty("oblast")
    private String oblast;
    /** номер поставки */
    @JsonProperty("incomeID")
    private String incomeID;
    /** уникальный идентификатор позиции заказа */
    @JsonProperty("odid")
    private String odid;
    /** Код WB */
    @JsonProperty("nmid")
    private String nmid;
    /** предмет */
    @JsonProperty("subject")
    private String subject;
    /** категория */
    @JsonProperty("category")
    private String category;
    /** бренд */
    @JsonProperty("brand")
    private String brand;
    /** признак отмены заказа (0 – отмены не было, 1 – отмена была */
    @JsonProperty("is_cancel")
    private String isCancel;
    /** дата отмены заказа */
    @JsonProperty("cancel_dt")
    private String cancelDt;
    
    // ~ Управляемые объекты(Beans) =========================================================================
    
    // ~ Конструктор ========================================================================================
    
    // ~ Методы =============================================================================================
    
    // ~ Доступ к свойствам =================================================================================
    
}
