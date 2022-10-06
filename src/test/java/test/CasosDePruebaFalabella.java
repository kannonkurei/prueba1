package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.falabella.HomePage;
import page.falabella.ProductCategoryPage;
import page.falabella.ProductDetailPage;
import page.google.ContactPage;
import page.google.DomainPage;
import page.google.DomainSearchPage;
import page.google.WelcomePage;
import util.DataDriven;
import util.PropertiesDriven;

import java.util.ArrayList;

public class CasosDePruebaFalabella {
    //definir atributos
    private WebDriver driver;
    private HomePage homePage;
    private ProductCategoryPage productPage;
    private ProductDetailPage productDetails;
    //private DomainSearchPage domainSearchPage;
    private String url = PropertiesDriven.obtenerProperty("urlFalabella"); //esto esta en duro;
    private String rutaDriver = PropertiesDriven.obtenerProperty("rutaDriver"); //esto esta en duro
    private String propertyDriver = PropertiesDriven.obtenerProperty("propertyDriver"); //esto esta en duro
    private String browser = PropertiesDriven.obtenerProperty("browser"); //esto esta en duro
    private ArrayList<String> datosCP;


    @BeforeMethod
    public void preparacionTests(){
        datosCP = new ArrayList<String>();
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser,rutaDriver,propertyDriver);
        productPage = new ProductCategoryPage(homePage.getDriver());
        productDetails = new ProductDetailPage(productPage.getDriver());
        //domainSearchPage = new DomainSearchPage(domainPage.getDriver());
        homePage.cargarURL(url);
        homePage.maximizarBrowser();
    }


    @AfterMethod
    public void after(){
        homePage.cerrarBrowser();
    }
    @Test
    public void CP001_Agregar_Carrito_Compra_audifonos() throws InterruptedException {
        homePage.SeleccionAudifonos();
        productPage.filtrarAudifonosSony();
        productPage.irAPag2();
        productPage.seleccionarAudifonos();
        productDetails.agregarAlCarro();
        productDetails.IrAlCarro();
        System.out.println(productDetails.obtenerNombreProducto());
        System.out.println(productDetails.obtenerProductosEnCarrito());

    }





}
