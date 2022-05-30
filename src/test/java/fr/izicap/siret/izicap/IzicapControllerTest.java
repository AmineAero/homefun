package fr.izicap.siret.izicap;

import fr.izicap.siret.izicap.utils.IzicapConstants;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IzicapControllerTest {

    private static String absentSiret;
    private static String unparsableSiret;

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void init(){
        absentSiret = "1111";
        unparsableSiret = "1111ABCD";
    }

    @Test
    void retrieveCompanyByAbsentSiretTest() throws Exception {
        this.mockMvc.perform(get(IzicapConstants.SIRET_ENDPOINT_URL + "/" +this.absentSiret))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("No company found with a Siret")));
    }

    @Test
    void retrieveCompanyByUnparsableSiretTest() throws Exception {
        this.mockMvc.perform(get(IzicapConstants.SIRET_ENDPOINT_URL + "/" +this.unparsableSiret))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("The siret in parameter is not valid")));
    }

    void updateCompanyStoreWithExistingSiretTest(){}

    void updateCompanyStoreWithNoExistingSiretTest(){}

    void verifyCompanyInformationResultTest(){}
}
