package ru.ztech.restclient.wb.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.ztech.restclient.wb.jackson.FlexiblePriceDeserializer;

/**
 * Строка отчета о продажах по реализации
 *
 * @since 0.1 (11-01-2022)
 * @author Гончаров Никита
 * 
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDataDetailByPeriodDto {
    
    // ~ Статические поля/инициализации =====================================================================
    
    // ~ Переменные(свойства) класса ========================================================================
    @JsonProperty("realizationreport_id")
    /** Номер отчета */
    private Long realizationreportId;
    /** Договор */
    @JsonProperty("suppliercontract_code")
    private String suppliercontractCode;
    /** Дата операции */
    @JsonProperty("rr_dt")
    private LocalDate rrDt;
    /** Номер строки */
    @JsonProperty("rrd_id")
    private Long rrdId;
    /** номер поставки */
    @JsonProperty("gi_id")
    private Long giId;
    /** Предмет */
    @JsonProperty("subject_name")
    private String subjectName;
    /** Артикул */
    @JsonProperty("nm_id")
    private Long NMId;
    /** Бренд */
    @JsonProperty("brand_name")
    private String brandName;
    /** Артикул поставщика */
    @JsonProperty("sa_name")
    private String saName;
    /** Размер */
    @JsonProperty("ts_name")
    private String tsName;
    /** Баркод */
    @JsonProperty("barcode")
    private String barcode;
    /** Тип документа */
    @JsonProperty("doc_type_name")
    private String docTypeName;
    /** Количество */
    @JsonProperty("quantity")
    private Integer quantity;
    /** Цена розничная */
    @JsonProperty("retail_price")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double retailPrice;
    /** Сумма продаж(Возвратов) */
    @JsonProperty("retail_amount")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double retailAmount;
    /** Согласованная скидка */
    @JsonProperty("sale_percent")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double salePercent;
    /** Процент комиссии */
    @JsonProperty("commission_percent")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double commissionPercent;
    /** Склад */
    @JsonProperty("office_name")
    private String officeName;
    /** Обоснование для оплаты */
    @JsonProperty("supplier_oper_name")
    private String supplierOperName;
    /** Даты заказа */
    @JsonProperty("order_dt")
    private LocalDate orderDt;
    /** Дата продажи */
    @JsonProperty("sale_dt")
    private LocalDate saleDt;
    /** ШК */
    @JsonProperty("shk_id")
    private Long shkId;
    /** Цена розничная с учетом согласованной скидки */
    @JsonProperty("retail_price_withdisc_rub")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double retailPriceWithdiscRub;
    /** Кол-во доставок */
    @JsonProperty("delivery_amount")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double deliveryAmount;
    /** Кол-во возвратов */
    @JsonProperty("return_amount")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double returnAmount;
    /** Стоимость логистики */
    @JsonProperty("delivery_rub")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double deliveryRub;
    /** Тип коробов */
    @JsonProperty("gi_box_type_name")
    private String giBoxTypeName;
    /** Согласованный продуктовый дисконт */
    @JsonProperty("product_discount_for_report")
    private Integer productDiscountForReport;
    /** Промокод */
    @JsonProperty("supplier_promo")
    private Integer supplierPromo;
    /** уникальный идентификатор строки отчета */
    @JsonProperty("rid")
    private Long rid;
    /** ppvz_spp_prc = 0 */
    @JsonProperty("ppvz_spp_prc")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double ppvzSppPrice;
    /** ppvz_kvw_prc_base = 0.075 */
    @JsonProperty("ppvz_kvw_prc_base")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double ppvzKvwPriceBase;
    /** "ppvz_kvw_prc": 0.075 */
    @JsonProperty("ppvz_kvw_prc")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double ppvzKvwPrice;
    /** "ppvz_sales_commission": 51.63 */
    @JsonProperty("ppvz_sales_commission")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double ppvzSalesCommission;
    /** "ppvz_for_pay": 626.43 */
    @JsonProperty("ppvz_for_pay")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double ppvzForPay;
    /** "ppvz_reward": 0 */
    @JsonProperty("ppvz_reward")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double ppvzReward;
    /** "ppvz_vw": 51.63 */
    @JsonProperty("ppvz_vw")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double ppvzVW;
    /** "ppvz_vw_nds": 10.33 */
    @JsonProperty("ppvz_vw_nds")
    @JsonDeserialize(using = FlexiblePriceDeserializer.class)
    private Double ppvzVWNds;
    /** "ppvz_office_id": 0 */
    @JsonProperty("ppvz_office_id")
    private Long ppvzOfficeId;
    /** ppvz_office_name */
    @JsonProperty("ppvz_office_name")
    private String ppvzOfficeName;
    /** "ppvz_supplier_id": 0 */
    @JsonProperty("ppvz_supplier_id")
    private Long ppvzSupplierId;
    
    // ~ Конструктор ========================================================================================
    
    // ~ Методы =============================================================================================
    
    // ~ Доступ к свойствам =================================================================================
    
}
