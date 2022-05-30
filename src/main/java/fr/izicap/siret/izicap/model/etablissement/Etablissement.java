package fr.izicap.siret.izicap.model.etablissement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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