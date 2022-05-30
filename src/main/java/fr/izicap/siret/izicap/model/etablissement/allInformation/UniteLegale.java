package fr.izicap.siret.izicap.model.etablissement.allInformation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UniteLegale {

    private int id;
    private String siren;
    @JsonProperty("statut_diffusion")
    private String statutDiffusion;
    @JsonProperty("unite_purgee")
    private String unitePurgee;
    @JsonProperty("date_creation")
    private Date dateCreation;
    private String sigle;
    private String sexe;
    @JsonProperty("prenom_1")
    private String prenom1;
    @JsonProperty("prenom_2")
    private String prenom2;
    @JsonProperty("prenom_3")
    private String prenom3;
    @JsonProperty("prenom_4")
    private String prenom4;
    @JsonProperty("prenom_usuel")
    private String prenomUsuel;
    private String pseudonyme;
    @JsonProperty("identifiant_association")
    private String identifiantAssociation;
    @JsonProperty("tranche_effectifs")
    private String trancheEffectifs;
    @JsonProperty("annee_effectifs")
    private String anneeEffectifs;
    @JsonProperty("date_dernier_traitement")
    private Date dateDernierTraitement;
    @JsonProperty("nombre_periodes")
    private String nombrePeriodes;
    @JsonProperty("categorie_entreprise")
    private String categorieEntreprise;
    @JsonProperty("annee_categorie_entreprise")
    private String anneeCategorieEntreprise;
    @JsonProperty("date_fin")
    private String dateFin;
    @JsonProperty("date_debut")
    private Date dateDebut;
    @JsonProperty("etat_administratif")
    private String etatAdministratif;
    private String nom;
    @JsonProperty("nom_usage")
    private String nomUsage;
    private String denomination;
    @JsonProperty("denomination_usuelle_1")
    private String denominationUsuelle1;
    @JsonProperty("denomination_usuelle_2")
    private String denominationUsuelle2;
    @JsonProperty("denomination_usuelle_3")
    private String denominationUsuelle3;
    @JsonProperty("categorie_juridique")
    private String categorieJuridique;
    @JsonProperty("activite_principale")
    private String activitePrincipale;
    @JsonProperty("nomenclature_activite_principale")
    private String nomenclatureActivitePrincipale;
    @JsonProperty("nic_siege")
    private String nicSiege;
    @JsonProperty("economie_sociale_solidaire")
    private String economieSocialeSolidaire;
    @JsonProperty("caractere_employeur")
    private String caractereEmployeur;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;
    @JsonProperty("etablissement_siege")
    private EtablissementSiege etablissementSiege;
    @JsonProperty("numero_tva_intra")
    private String numeroTvaIntra;

}