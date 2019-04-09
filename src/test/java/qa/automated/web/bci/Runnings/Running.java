package qa.automated.web.bci.Runnings;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/qa/automated/web/bci/Feature", 
glue = "qa/automated/web/bci/Definitions", 
plugin = { "pretty", "html:target/cucumber" , 
		   "json:target/cucumber.json",
		   "com.cucumber.listener.ExtentCucumberFormatter:"})

public class Running { 
	public static SimpleDateFormat sdf;
    
    @AfterClass
    public static void setup() {
    	//Carga la config del xml
        System.out.println("CARGA CONFIGURACIÓN DEL XML");
        Reporter.loadXMLConfig(new File("./src/test/java/qa/automated/web/bci/Config/extent-config.xml"));

        // Detalle características     
        Reporter.setSystemInfo("Nombre Proyecto","BCI Automation");
        Reporter.setSystemInfo("Zona Horaria", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Ubicacion Usuario", System.getProperty("user.country"));
        Reporter.setSystemInfo("Version OS", System.getProperty("os.version"));
 
    }
    
    @BeforeClass
    public static void setupPath() {
		sdf = new SimpleDateFormat("dd-MM-YYYY_hh-mm-ss");
    	ExtentProperties extentProperties = ExtentProperties.INSTANCE;
    	extentProperties.setReportPath(System.getProperty("user.dir") + sdf.format(new Date())
		+ "/Reporte_Automatizacion_" + sdf.format(new Date()) + ".html");
    }
}