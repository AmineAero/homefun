package fr.izicap.siret.izicap.service;

import fr.izicap.siret.izicap.exception.CompanyNotFoundException;
import fr.izicap.siret.izicap.exception.IzicapTechnicalException;
import fr.izicap.siret.izicap.model.etablissement.EtablissementRoot;
import fr.izicap.siret.izicap.repository.CompanyRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations="classpath:application-integrationtest.properties")
class CompanyServiceTest {

    @InjectMocks
    CompanyService companyService;

    @Mock
    CompanyRepository repository;
    @Mock
    RestTemplate restTemplate;

    private static final String SIRET = "31302979500017";

    @Test
    void retrieveCampanyBySiret() throws CompanyNotFoundException, IzicapTechnicalException {
        // Given
        Mockito.when(restTemplate.getForObject(SIRET, EtablissementRoot.class))
                        .thenReturn(new EtablissementRoot());

        // When
        companyService.retrieveCampanyBySiret(SIRET);

        // Then
        // Check that the CompanyRepository to update the CVS Store
        Mockito.verify(repository, Mockito.times(1));
    }
}