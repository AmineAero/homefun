package fr.izicap.siret.izicap.model.etablissement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.Transient;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
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