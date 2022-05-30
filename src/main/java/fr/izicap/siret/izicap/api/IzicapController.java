package fr.izicap.siret.izicap.api;

import fr.izicap.siret.izicap.exception.CompanyNotFoundException;
import fr.izicap.siret.izicap.exception.IzicapTechnicalException;
import fr.izicap.siret.izicap.service.CompanyService;
import fr.izicap.siret.izicap.utils.IzicapConstants;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(IzicapConstants.SIRET_ENDPOINT_URL)
public class IzicapController {

    private static final Logger LOGGER= LoggerFactory.getLogger(IzicapController.class);
    private final CompanyService companyService;

    public IzicapController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping("/{siret}")
    public @ResponseBody ResponseEntity retrieveCompany(@PathVariable String siret) {

        LOGGER.info("Retrive company by siret : {}",siret);
        if(!NumberUtils.isParsable(siret)) {
            return new ResponseEntity<>("The siret in parameter is not valid", HttpStatus.BAD_REQUEST);
        }

        try {
            return  ResponseEntity.ok(companyService.retrieveCampanyBySiret(siret));
        } catch (CompanyNotFoundException e) {
            LOGGER.error("No company found with siret={}", siret);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IzicapTechnicalException e) {
            LOGGER.error("Technical exception is occured", e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }

}

