package ru.ztech.restclient.wb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private String realizationreportId;
    /** Договор */
    @JsonProperty("suppliercontract_code")
    private String suppliercontractCode;
    /** Дата операции */
    @JsonProperty("rr_dt")
    private String rrDt;
    /** Номер строки */
    @JsonProperty("rrd_id")
    private String rrdId;
    /** номер поставки */
    @JsonProperty("gi_id")
    private String giId;
    /** Предмет */
    @JsonProperty("subject_name")
    private String subjectName;
    /** Артикул */
    @JsonProperty("NM_id")
    private String NMId;
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
    private String quantity;
    /** Ставка НДС */
    @JsonProperty("nds")
    private String nds;
    /** Себестоимость Сумма */
    @JsonProperty("cost_amount")
    private String costAmount;
    /** Цена розничная */
    @JsonProperty("retail_price")
    private String retailPrice;
    /** Сумма продаж(Возвратов) */
    @JsonProperty("retail_amount")
    private String retailAmount;
    /** Сумма комиссии продаж */
    @JsonProperty("retail_commission")
    private String retailCommission;
    /** Согласованная скидка */
    @JsonProperty("sale_percent")
    private String salePercent;
    /** Процент комиссии */
    @JsonProperty("commission_percent")
    private String commissionPercent;
    /** Вознаграждение покупателю */
    @JsonProperty("customer_reward")
    private String customerReward;
    /** Вознаграждение поставщику */
    @JsonProperty("supplier_reward")
    private String supplierReward;
    /** Склад */
    @JsonProperty("office_name")
    private String officeName;
    /** Обоснование для оплаты */
    @JsonProperty("supplier_oper_name")
    private String supplierOperName;
    /** Даты заказа */
    @JsonProperty("order_dt")
    private String orderDt;
    /** Дата продажи */
    @JsonProperty("sale_dt")
    private String saleDt;
    /** ШК */
    @JsonProperty("shk_id")
    private String shkId;
    /** Цена розничная с учетом согласованной скидки */
    @JsonProperty("retail_price_withdisc_rub")
    private String retailPriceWithdiscRub;
    /** К перечислению поставщику */
    @JsonProperty("for_pay")
    private String forPay;
    /** К перечислению поставщику НДС */
    @JsonProperty("for_pay_nds")
    private String forPayNds;
    /** Кол-во доставок */
    @JsonProperty("delivery_amount")
    private String deliveryAmount;
    /** Кол-во возвратов */
    @JsonProperty("return_amount")
    private String returnAmount;
    /** Стоимость логистики */
    @JsonProperty("delivery_rub")
    private String deliveryRub;
    /** Тип коробов */
    @JsonProperty("gi_box_type_name")
    private String giBoxTypeName;
    /** Согласованный продуктовый дисконт */
    @JsonProperty("product_discount_for_report")
    private String productDiscountForReport;
    /** Промокод */
    @JsonProperty("supplier_promo")
    private String supplierPromo;
    /** Скидка постоянного покупателя */
    @JsonProperty("supplier_spp")
    private String supplierSpp;
    
    // ~ Конструктор ========================================================================================
    
    // ~ Методы =============================================================================================
    
    // ~ Доступ к свойствам =================================================================================
    
}
