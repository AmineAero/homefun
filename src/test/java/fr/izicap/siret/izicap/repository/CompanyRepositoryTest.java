package fr.izicap.siret.izicap.repository;

import fr.izicap.siret.izicap.TestUtils;
import fr.izicap.siret.izicap.exception.IzicapTechnicalException;
import fr.izicap.siret.izicap.model.etablissement.Etablissement;
import fr.izicap.siret.izicap.model.etablissement.EtablissementRoot;
import fr.izicap.siret.izicap.model.etablissement.UniteLegale;
import fr.izicap.siret.izicap.utils.IzicapCsvUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations="classpath:application-integrationtest.properties")
class CompanyRepositoryTest {

    @Autowired
    CompanyRepository companyRepository;

    private static EtablissementRoot companyToSave;

    private static final String CSV_FILE_NAME = "companies.csv";
    private static final String HEADER = "id,nic,full_adresse,creation_date,full_name,tva_number";
    private static final String COMPANY1 = "449321770,00017,261 Chemin des Colles 06140 Vence,Sun Jan 01 01:00:00 CET 1978,SOC EXPL PEPINIERES GAUDISSART,FR96313029795";
    private static final String COMPANY2 = "449566023,00013,7 Rue Raoul Bosio 06300 Nice,Tue Feb 17 01:00:00 CET 1998,OPERA VINS,FR56417763042";
    private static List<String[]> store_full_companies;
    private static List<String[]> store_partial_companies;
    private static final String OLD_ADRESS = "261 Chemin des Colles 06140 Vence";
    private static final String NEW_ADRESS = "20350 Casablanca";


    @BeforeAll
    static void setUp() {
        // New company to add for Test
        UniteLegale unitLegale = new UniteLegale("UNIVERSAL TRAINING", "FR59434381471");
        companyToSave = new EtablissementRoot(
                new Etablissement(449321770, "00017", NEW_ADRESS,
                new Date(), unitLegale)
        );

        store_full_companies = Arrays.asList(HEADER.split(","), COMPANY1.split(","), COMPANY2.split(","));
        store_partial_companies = Arrays.asList(HEADER.split(","), COMPANY2.split(","));
    }

    @AfterEach
    void tearDown() {
        TestUtils.deleteTestFile(CSV_FILE_NAME);
    }

    @Test
    void updateStoreWithNewCompany() throws IzicapTechnicalException, IOException {
        // Given a Company that is not present in Store
        // Create CSV for Test
        IzicapCsvUtils.writeAll(store_partial_companies, CSV_FILE_NAME);
        List<String[]> csvBody = TestUtils.readAllLinesFromCsvFile(CSV_FILE_NAME);
        // The actual size before adding the new Company is 2
        assertEquals(2, csvBody.size());

        // When
        companyRepository.updateStore(companyToSave);

        // Then
        csvBody = TestUtils.readAllLinesFromCsvFile(CSV_FILE_NAME);
        // The new Company is added to Store and the new size is 3
        assertEquals(3, csvBody.size());
        assertEquals(3, csvBody.size());
        System.out.println(csvBody.get(2)[1]);
    }

    @Test
    void updateStoreWithExistingCompany() throws IzicapTechnicalException, IOException {
        // Given a Company that is already present in Store
        IzicapCsvUtils.writeAll(store_full_companies, CSV_FILE_NAME);
        List<String[]> csvBody = TestUtils.readAllLinesFromCsvFile(CSV_FILE_NAME);
        // The actual size before updating store with the "companyToSave"
        assertEquals(3, csvBody.size());
        assertEquals(OLD_ADRESS, csvBody.get(1)[2]);

        // When
        companyRepository.updateStore(companyToSave);

        // Then
        csvBody = TestUtils.readAllLinesFromCsvFile(CSV_FILE_NAME);
        // The companyToSave is updated and no new line was added to CSV Store
        assertEquals(3, csvBody.size());
        assertEquals(NEW_ADRESS, csvBody.get(1)[2]);
    }
}