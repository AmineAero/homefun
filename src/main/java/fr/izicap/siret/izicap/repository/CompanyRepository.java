package fr.izicap.siret.izicap.repository;

import fr.izicap.siret.izicap.exception.IzicapTechnicalException;
import fr.izicap.siret.izicap.model.etablissement.EtablissementRoot;
import fr.izicap.siret.izicap.utils.IzicapCsvUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class CompanyRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyRepository.class);

    @Value("${izicap.store.csv.path}")
    private String csvStorePath;

    public void updateStore(EtablissementRoot company) throws IzicapTechnicalException {
        try {
            LOGGER.info("Read the existing store file from {}", csvStorePath);
            List<String[]> csvBody = IzicapCsvUtils.readAllLines(csvStorePath);

            // get CSV row and replace it by the last Etablisement information
            int index = checkIfTheEtablissementExist(company.getEtablissement().getId(), csvBody);

            if(index == 0) {
                // Add a new line with the etablissement to the csv store
                IzicapCsvUtils.addOneLine(company.getFieldsForCsv(), csvStorePath);
                LOGGER.info("The company with id={} is added to the store", company.getEtablissement().getId());
            } else {
                // Update the existing csv store with the last informations of Etablissment
                csvBody.set(index, company.getFieldsForCsv());
                IzicapCsvUtils.writeAll(csvBody, csvStorePath);
                LOGGER.info("The CSV Store is updated with the last informations of company with id={}",
                        company.getEtablissement().getId());
            }
        } catch (IOException e) {
            LOGGER.error("Error when processing the CSV Store.", e);
            throw new IzicapTechnicalException(e.getMessage());
        }
    }

    /**
     * Check if the company existe by his ID in the CSV store and return the line's index if true
     * Otherwie return 0.
     * @param etablissementId
     * @param csvBody
     * @return int
     */
    private int checkIfTheEtablissementExist(int etablissementId, List<String[]> csvBody) {
        int index = 0;
        String strEtabId = String.valueOf(etablissementId);
        for(String[] line : csvBody){
            if(line[0].equals(strEtabId)){
                return index;
            }
            index++;
        }
        return 0;
    }

}
