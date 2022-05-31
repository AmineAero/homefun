package fr.izicap.siret.izicap.service;

import fr.izicap.siret.izicap.exception.CompanyNotFoundException;
import fr.izicap.siret.izicap.exception.IzicapTechnicalException;
import fr.izicap.siret.izicap.model.etablissement.EtablissementRoot;
import fr.izicap.siret.izicap.repository.CompanyRepository;
import fr.izicap.siret.izicap.utils.IzicapConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);
    CompanyRepository repository;
    RestTemplate restTemplate;

    public CompanyService(CompanyRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public EtablissementRoot retrieveCampanyBySiret(String siret) throws CompanyNotFoundException, IzicapTechnicalException {
        EtablissementRoot company = restTemplate.getForObject(
                IzicapConstants.PUBLIC_SIRENE_API + siret,
                    EtablissementRoot.class);

        // Add or Update the csv store with the last result
        repository.updateStore(company);

        return company;
    }

}
