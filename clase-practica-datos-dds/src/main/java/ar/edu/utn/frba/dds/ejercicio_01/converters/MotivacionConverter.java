package ar.edu.utn.frba.dds.ejercicio_01.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.BajarDePeso;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Mantener;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Motivacion;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Tonificar;

@Converter(autoApply=true)
public class MotivacionConverter implements AttributeConverter<Motivacion, String>{

    @Override
    public String convertToDatabaseColumn(Motivacion attribute) {
        if (attribute instanceof BajarDePeso) {
            return "BAJAR_PESO";
        } else if (attribute instanceof Mantener) {
            return "MANTENER";
        } else if (attribute instanceof Tonificar) {
            return "TONIFICAR";
        } else {
            throw new Error("motivacion desconocida");
        }
    }
        

    @Override
    public Motivacion convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "BAJAR_PESO":
                return new BajarDePeso();
            case "MANTENER":
                return new Mantener();
            case "TONIFICAR":
                return new Tonificar();
            default:
                throw new Error("Tipo de motivacion desconocido");
        }
    }
    
}
