package fr.izicap.siret.izicap.model.etablissement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UniteLegale {

    private String denomination;

    @JsonProperty("numero_tva_intra")
    private String numeroTvaIntra;

}