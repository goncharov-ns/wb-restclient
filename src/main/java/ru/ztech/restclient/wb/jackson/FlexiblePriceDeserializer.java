package ru.ztech.restclient.wb.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Конвертер сумм
 *
 * @since 0.2 (29-01-2022)
 * @author Гончаров Никита 
 * 
 */
public class FlexiblePriceDeserializer extends JsonDeserializer<Double> {
    
    @Override
    public Double deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String floatString = parser.getText();
        if (floatString.contains(",")) {
            floatString = floatString.replace(",", ".");
        }
        return Double.valueOf(floatString);
    }
}
