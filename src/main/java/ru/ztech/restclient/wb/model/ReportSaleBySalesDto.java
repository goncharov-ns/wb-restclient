package ru.ztech.restclient.wb.model;

import lombok.Getter;
import lombok.Setter;

/**
 * ReportSaleBySalesDto
 *
 * @since version(11-01-2022)
 * @author Гончаров Никита 
 * 
 */
@Getter
@Setter
public class ReportSaleBySalesDto {
    
    // ~ Статические поля/инициализации =====================================================================
    
    // ~ Переменные(свойства) класса ========================================================================
    /** Номер отчета */
    private String realizationreportId;
    /** Договор */
    private String suppliercontract_code;
    /** Дата операции */
    private String rr_dt;
    /** Номер строки */
    private String rrd_id;
    /** номер поставки */
    private String gi_id;
    /** Предмет */
    private String subject_name;
    /** Артикул */
    private String NM_id;
    /** Бренд */
    private String brand_name;
    /** Артикул поставщика */
    private String sa_name;
    /** Размер */
    private String ts_name;
    /** Баркод */
    private String barcode;
    /** Тип документа */
    private String doc_type_name;
    /** Количество */
    private String quantity;
    /** Ставка НДС */
    private String nds;
    /** Себестоимость Сумма */
    private String cost_amount;
    /** Цена розничная */
    private String retail_price;
    /** Сумма продаж(Возвратов) */
    private String retail_amount;
    /** Сумма комиссии продаж */
    private String retail_commission;
    /** Согласованная скидка */
    private String sale_percent;
    /** Процент комиссии */
    private String commission_percent;
    /** Вознаграждение покупателю */
    private String customer_reward;
    /** Вознаграждение поставщику */
    private String supplier_reward;
    /** Склад */
    private String office_name;
    /** Обоснование для оплаты */
    private String supplier_oper_name;
    /** Даты заказа */
    private String order_dt;
    /** Дата продажи */
    private String sale_dt;
    /** ШК */
    private String shk_id;
    /** Цена розничная с учетом согласованной скидки */
    private String retail_price_withdisc_rub;
    /** К перечислению поставщику */
    private String for_pay;
    /** К перечислению поставщику НДС */
    private String for_pay_nds;
    /** Кол-во доставок */
    private String delivery_amount;
    /** Кол-во возвратов */
    private String return_amount;
    /** Стоимость логистики */
    private String delivery_rub;
    /** Тип коробов */
    private String gi_box_type_name;
    /** Согласованный продуктовый дисконт */
    private String
    product_discount_for_report;
    /** Промокод */
    private String supplier_promo;
    /** Скидка постоянного покупателя */
    private String supplier_spp;
    
    // ~ Конструктор ========================================================================================
    
    // ~ Методы =============================================================================================
    
    // ~ Доступ к свойствам =================================================================================
    
}
