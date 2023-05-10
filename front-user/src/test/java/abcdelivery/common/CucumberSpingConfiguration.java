package abcdelivery.common;

import abcdelivery.FrontUserApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { FrontUserApplication.class })
public class CucumberSpingConfiguration {}
