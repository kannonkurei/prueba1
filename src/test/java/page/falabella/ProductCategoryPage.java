package page.falabella;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ClaseBase;

public class ProductCategoryPage extends ClaseBase {
    //Definir atributos (Localizadores)

    By filtroSony = By.xpath("//h3[contains(text(),'Sony')]");
    By btnPagina2 = By.xpath("//button[@id='testId-pagination-top-button2']");
    By audifonosBuscados = By.xpath("//b[@id='testId-pod-displaySubTitle-16355684']");


    public ProductCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void filtrarAudifonosSony(){
        click(esperaExplicita(filtroSony));
        esperarXSegundos(2000);
    }

    public void irAPag2() {
        click(esperaExplicita(btnPagina2));
        esperarXSegundos(2000);
    }

    public void seleccionarAudifonos(){
        scrolling(esperaExplicita(audifonosBuscados));
        click(esperaExplicita(audifonosBuscados));
        esperarXSegundos(2000);
    }
}
