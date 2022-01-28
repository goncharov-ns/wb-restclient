package ru.ztech.restclient.wb;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.ztech.restclient.wb.model.ReportDataDetailByPeriodDto;

/**
 * JsonDataTest
 *
 * @since 0.1 (11-01-2022)
 * @author Гончаров Никита 
 * 
 */
public class JsonDataTest {
  
    @Test
    void readDataSaleBySales() throws IOException {
        String data = IOUtils.toString(getClass().getResourceAsStream("/data/salebysales.json"), Charset.forName("UTF-8"));
        ReportDataDetailByPeriodDto[] myObjects = (new ObjectMapper()).readValue(data, ReportDataDetailByPeriodDto[].class);
        for (ReportDataDetailByPeriodDto reportSaleBySalesDto : myObjects) {
            System.out.println(reportSaleBySalesDto.getRrdId() + " = " + reportSaleBySalesDto.getBarcode() + " " + reportSaleBySalesDto.getSaleDt());
            Assertions.assertNotNull(reportSaleBySalesDto.getRrdId());
            Assertions.assertNotNull(reportSaleBySalesDto.getBarcode());
        }
    }
}
