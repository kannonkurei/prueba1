package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.google.ContactPage;
import page.google.DomainPage;
import page.google.DomainSearchPage;
import page.google.WelcomePage;
import util.DataDriven;
import util.PropertiesDriven;

import java.util.ArrayList;

public class CasosDePruebaGoogle {
    //definir atributos
    private WebDriver driver;
    private WelcomePage welcomePage;
    private ContactPage contactPagePage;
    private DomainPage domainPage;
    private DomainSearchPage domainSearchPage;
    private String url = PropertiesDriven.obtenerProperty("urlGoogle"); //esto esta en duro;
    private String rutaDriver = PropertiesDriven.obtenerProperty("rutaDriver"); //esto esta en duro
    private String propertyDriver = PropertiesDriven.obtenerProperty("propertyDriver"); //esto esta en duro
    private String browser = PropertiesDriven.obtenerProperty("browser"); //esto esta en duro
    private ArrayList<String> datosCP;


    @BeforeMethod
    public void preparacionTests(){
        datosCP = new ArrayList<String>();
        welcomePage = new WelcomePage(driver);
        welcomePage.conexionDriver(browser,rutaDriver,propertyDriver);
        contactPagePage = new ContactPage(welcomePage.getDriver());
        domainPage = new DomainPage(contactPagePage.getDriver());
        domainSearchPage = new DomainSearchPage(domainPage.getDriver());
        welcomePage.cargarURL(url);
        welcomePage.maximizarBrowser();
    }


    @AfterMethod
    public void after(){
        domainSearchPage.cerrarBrowser();
    }
    @Test
    public void CP001_ObtenerPlanEnLinea_RetomarSolicitud_codigoErroneo() throws InterruptedException {
        datosCP = DataDriven.getData("CP001_ObtenerPlanEnLinea_RetomarSolicitud_codigoErroneo");
        welcomePage.Paso1_Empecemos("Pobre Domingo SA");
        contactPagePage.Paso2_Contacto("Domingo","Saavedra","domingo.algo@gmail.com");
        domainPage.Paso3_Dominio();
        domainSearchPage.Paso4_BuscarDominio("BCI");
        Thread.sleep(20000);
        String resultado = domainSearchPage.contarDominios();

        System.out.println(resultado);
        Thread.sleep(20000);
       // Assert.assertEquals(resultadoActual,datosCP.get(2));
    }





}
