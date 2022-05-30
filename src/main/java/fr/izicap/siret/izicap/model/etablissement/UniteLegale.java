package fr.izicap.siret.izicap.model.etablissement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UniteLegale {

    private String denomination;

    @JsonProperty("numero_tva_intra")
    private String numeroTvaIntra;

}