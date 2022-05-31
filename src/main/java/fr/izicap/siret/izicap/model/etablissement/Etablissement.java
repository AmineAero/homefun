package fr.izicap.siret.izicap.model.etablissement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Etablissement {

    private int id;
    private String nic;
    @JsonProperty("geo_adresse")
    private String geoAdresse;
    @JsonProperty("date_creation")
    private Date dateCreation;
    @JsonProperty("unite_legale")
    private UniteLegale uniteLegale;

}