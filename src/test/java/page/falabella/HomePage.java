package page.falabella;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ClaseBase;

public class HomePage extends ClaseBase {
    //Definir atributos (Localizadores)

    By btnMenu = By.xpath("//button[@id='testId-HamburgerBtn-toggle']");
    By lblTecnologia = By.xpath("//div[contains(text(),'Tecnología')]");
    By lblAudio = By.xpath("//a[(text() ='Audio')]");
    By lblAudifonos = By.xpath("//h3[contains(text(),'Audífonos')]");
    By btnAceptarCookies = By.xpath("//button[@id='testId-accept-cookies-btn']");

    //popUp Cyber
    By btnCerrarPopUpCyber = By.xpath("//div[@class='dy-lb-close']");

    //Aceptar Ofertas
    By btnAceptarOfertas = By.xpath("//button[(text() ='Sí, amo las ofertas')]");


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void SeleccionAudifonos() {
        if (estaDesplegado(esperaExplicita(btnCerrarPopUpCyber))) {
            click(esperaExplicita(btnCerrarPopUpCyber));
        }

        if (estaDesplegado(esperaExplicita(btnAceptarCookies))) {
            click(esperaExplicita(btnAceptarCookies));
        }


        /*if (estaDesplegado(btnAceptarOfertas)) {
            click(esperaExplicita(btnAceptarOfertas));
        }*/
        this.driver.navigate().refresh();

        click(esperaExplicita(btnMenu));
        esperarXSegundos(2000);
        click(esperaExplicita(lblTecnologia));
        esperarXSegundos(2000);
        esperarXSegundos(2000);
        click(esperaExplicita(lblAudio));
        click(esperaExplicita(lblAudifonos));
        esperarXSegundos(2000);

    }
}

