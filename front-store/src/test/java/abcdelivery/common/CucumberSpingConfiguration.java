package abcdelivery.common;

import abcdelivery.FrontStoreApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { FrontStoreApplication.class })
public class CucumberSpingConfiguration {}
