package page.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ClaseBase;

public class DomainPage extends ClaseBase {
    //Definir atributos (Localizadores)


    By btnNoTengoDominio = By.xpath("//span[contains(text(),'No, necesito un dominio')]");


    public DomainPage(WebDriver driver) {
        super(driver);
    }


    public void Paso3_Dominio(){
        esperarXSegundos(2000);
        click(esperaExplicita(btnNoTengoDominio));
    }
}

