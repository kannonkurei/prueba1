package page.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ClaseBase;

import java.util.List;

public class DomainSearchPage extends ClaseBase {
    //Definir atributos (Localizadores)


    By inputDomainSearch = By.xpath("//input[@type='text']");
    By lupaBusqueda = By.xpath("//i[contains(text(),'search')]");
    By listaDominios = By.xpath("//tr");

    public DomainSearchPage(WebDriver driver) {
        super(driver);
    }


    public void Paso4_BuscarDominio(String domain){
        esperarXSegundos(2000);
        agregarTexto(esperaExplicita(inputDomainSearch),domain);
        click(esperaExplicita(lupaBusqueda));
        esperarXSegundos(2000);
    }

    public String contarDominios(){
        esperarXSegundos(3000);
        String mensaje = "";
        int contar= 0;
        List<WebElement> dominios = buscarElementosWeb(listaDominios);
        for(WebElement dominio: dominios){
            mensaje = mensaje + "\n"+dominio.getText();
            contar++;
        }
        mensaje = mensaje + "\nEn total hay "+contar + " dominios asociados al dominio buscado";
        return mensaje;
    }
}

