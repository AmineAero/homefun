package fr.izicap.siret.izicap.model.etablissement;

import lombok.Getter;
import lombok.Setter;

import java.beans.Transient;
import java.io.Serializable;

@Getter
@Setter
public class EtablissementRoot implements Serializable {

    private Etablissement etablissement;

    @Transient
    public String[] getFieldsForCsv() {
        return new String[] {
                String.valueOf(etablissement.getId()),
                etablissement.getNic(),
                etablissement.getGeoAdresse(),
                etablissement.getDateCreation().toString(),
                etablissement.getUniteLegale().getDenomination(),
                etablissement.getUniteLegale().getNumeroTvaIntra()
        };
    }

}