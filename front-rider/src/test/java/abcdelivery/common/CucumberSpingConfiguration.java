package abcdelivery.common;

import abcdelivery.FrontRiderApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { FrontRiderApplication.class })
public class CucumberSpingConfiguration {}
