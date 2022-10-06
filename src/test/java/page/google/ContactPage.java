package page.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ClaseBase;

public class ContactPage extends ClaseBase {
    //Definir atributos (Localizadores)

    By txtNombre = By.xpath("//section[1]/div[2]/div[1]/label[1]/input[1]");
    By txtApellido = By.xpath("//section[1]/div[3]/div[1]/label[1]/input[1]");
    By txtCorreo = By.xpath("//input[@type='email']");


    By btnSiguiente = By.xpath("//div[contains(text(),'Siguiente')]");


    public ContactPage(WebDriver driver) {
        super(driver);
    }


    public void Paso2_Contacto(String nombre,String apellido,String correo){
        esperarXSegundos(2000);
        agregarTexto(esperaExplicita(txtNombre),nombre);
        agregarTexto(esperaExplicita(txtApellido),apellido);
        agregarTexto(esperaExplicita(txtCorreo),correo);
        click(esperaExplicita(btnSiguiente));
    }
}

