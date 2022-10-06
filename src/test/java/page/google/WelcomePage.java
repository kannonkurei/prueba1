package page.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ClaseBase;

public class WelcomePage extends ClaseBase {
    //Definir atributos (Localizadores)

    By txtNombreEmpresa = By.xpath("//input[@id='c2']");
    By radioBtnNroEmpleados = By.xpath("//input[@type='radio']");
    By btnSiguiente = By.xpath("//div[contains(text(),'Siguiente')]");


    public WelcomePage(WebDriver driver) {
        super(driver);
    }


    public void Paso1_Empecemos(String nombreEmpresa){
        esperarXSegundos(4000);
        agregarTexto(esperaExplicita(txtNombreEmpresa),nombreEmpresa);
        esperarXSegundos(4000);
        click(buscarElementosWeb(radioBtnNroEmpleados).get(0));
        click(esperaExplicita(btnSiguiente));
    }
}

