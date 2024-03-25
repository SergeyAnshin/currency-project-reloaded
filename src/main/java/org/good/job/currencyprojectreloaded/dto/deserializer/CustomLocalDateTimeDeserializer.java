package org.good.job.currencyprojectreloaded.dto.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.good.job.currencyprojectreloaded.service.EndpointDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Objects;

@JsonComponent
public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    @Autowired
    private EndpointDataService endpointDataService;

    // TODO  datePatterns
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        String dateString = jsonParser.getText();
        List<String> datePatterns = List.of("dd.MM.yyyy");
        LocalDateTime localDateTime = null;
        for (String datePattern : datePatterns) {
            try {
                DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern(
                                datePattern + "[ [HH][:mm][:ss][.SSS]]")
                        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0).toFormatter();
                localDateTime = LocalDateTime.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                // Пробуем следующий формат
            }
        }
        if (Objects.nonNull(localDateTime)) {
            return localDateTime;
        } else {
            throw new IllegalArgumentException("Неверный формат даты: " + dateString);
        }
    }

}
