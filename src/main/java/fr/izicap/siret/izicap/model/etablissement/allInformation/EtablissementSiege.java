package fr.izicap.siret.izicap.model.etablissement.allInformation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EtablissementSiege {

    private int id;
    private String siren;
    private String nic;
    private String siret;
    @JsonProperty("statut_diffusion")
    private String statutDiffusion;
    @JsonProperty("date_creation")
    private Date dateCreation;
    @JsonProperty("tranche_effectifs")
    private String trancheEffectifs;
    @JsonProperty("annee_effectifs")
    private String anneeEffectifs;
    @JsonProperty("activite_principale_registre_metiers")
    private String activitePrincipaleRegistreMetiers;
    @JsonProperty("date_dernier_traitement")
    private Date dateDernierTraitement;
    @JsonProperty("etablissement_siege")
    private String etablissementSiege;
    @JsonProperty("nombre_periodes")
    private String nombrePeriodes;
    @JsonProperty("complement_adresse")
    private String complementAdresse;
    @JsonProperty("numero_voie")
    private String numeroVoie;
    @JsonProperty("indice_repetition")
    private String indiceRepetition;
    @JsonProperty("type_voie")
    private String typeVoie;
    @JsonProperty("libelle_voie")
    private String libelleVoie;
    @JsonProperty("code_postal")
    private String codePostal;
    @JsonProperty("libelle_commune")
    private String libelleCommune;
    @JsonProperty("libelle_commune_etranger")
    private String libelleCommuneEtranger;
    @JsonProperty("distribution_speciale")
    private String distributionSpeciale;
    @JsonProperty("code_commune")
    private String codeCommune;
    @JsonProperty("code_cedex")
    private String codeCedex;
    @JsonProperty("libelle_cedex")
    private String libelleCedex;
    @JsonProperty("code_pays_etranger")
    private String codePaysEtranger;
    @JsonProperty("libelle_pays_etranger")
    private String libellePaysEtranger;
    @JsonProperty("complement_adresse_2")
    private String complementAdresse2;
    @JsonProperty("numero_voie_2")
    private String numeroVoie2;
    @JsonProperty("indice_repetition_2")
    private String indiceRepetition2;
    @JsonProperty("type_voie_2")
    private String typeVoie2;
    @JsonProperty("libelle_voie_2")
    private String libelleVoie2;
    @JsonProperty("code_postal_2")
    private String codePostal2;
    @JsonProperty("libelle_commune_2")
    private String libelleCommune2;
    @JsonProperty("libelle_commune_etranger_2")
    private String libelleCommuneEtranger2;
    @JsonProperty("distribution_speciale_2")
    private String distributionSpeciale2;
    @JsonProperty("code_commune_2")
    private String codeCommune2;
    @JsonProperty("code_cedex_2")
    private String codeCedex2;
    @JsonProperty("libelle_cedex_2")
    private String libelleCedex2;
    @JsonProperty("code_pays_etranger_2")
    private String codePaysEtranger2;
    @JsonProperty("libelle_pays_etranger_2")
    private String libellePaysEtranger2;
    @JsonProperty("date_debut")
    private Date dateDebut;
    @JsonProperty("etat_administratif")
    private String etatAdministratif;
    @JsonProperty("enseigne_1")
    private String enseigne1;
    @JsonProperty("enseigne_2")
    private String enseigne2;
    @JsonProperty("enseigne_3")
    private String enseigne3;
    @JsonProperty("denomination_usuelle")
    private String denominationUsuelle;
    @JsonProperty("activite_principale")
    private String activitePrincipale;
    @JsonProperty("nomenclature_activite_principale")
    private String nomenclatureActivitePrincipale;
    @JsonProperty("caractere_employeur")
    private String caractereEmployeur;
    private String longitude;
    private String latitude;
    @JsonProperty("geo_score")
    private String geoScore;
    @JsonProperty("geo_type")
    private String geoType;
    @JsonProperty("geo_adresse")
    private String geoAdresse;
    @JsonProperty("geo_id")
    private String geoId;
    @JsonProperty("geo_ligne")
    private String geoLigne;
    @JsonProperty("geo_l4")
    private String geoL4;
    @JsonProperty("geo_l5")
    private String geoL5;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("unite_legale_id")
    private int uniteLegaleId;

}