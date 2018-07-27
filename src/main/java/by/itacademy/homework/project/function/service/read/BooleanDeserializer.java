package by.itacademy.homework.project.function.service.read;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class BooleanDeserializer extends StdDeserializer<Boolean> {
    public BooleanDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext ) throws IOException, JsonProcessingException {
        return "available".equals(jsonParser.getText());
    }

}
