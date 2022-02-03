package ru.ztech.restclient.wb;

import org.springframework.web.client.RestClientResponseException;

import lombok.Getter;

/**
 * Ошибка вызова сервиса WB
 *
 * @since 0.3 (04-02-2022)
 * @author Гончаров Никита 
 * 
 */
public class WbApiException extends Exception {

    // ~ Статические поля/инициализации =====================================================================
    private static final long serialVersionUID = 1L;
    
    // ~ Переменные(свойства) класса ========================================================================
    @Getter
    private final RestClientResponseException responseException;
    
    // ~ Конструктор ========================================================================================
    public WbApiException(RestClientResponseException re, Exception e) {
        super("Ошибка вызова сервиса WB", e);
        this.responseException = re;
    }
    
    // ~ Методы =============================================================================================
    public boolean isBadKey() {
        return responseException.getRawStatusCode() == 400 || responseException.getRawStatusCode() == 401;
    }
    
    public boolean isManyCall() {
        return responseException.getRawStatusCode() == 429;
    }
    
    // ~ Доступ к свойствам =================================================================================
    
}
