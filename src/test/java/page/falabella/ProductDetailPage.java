package page.falabella;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ClaseBase;

public class ProductDetailPage extends ClaseBase {
    //Definir atributos (Localizadores)

    By btnAgregarAlCarro = By.xpath("//button[contains(text(),'Agregar al Carro')]");
    By btnIrAlCarro = By.xpath("//a[@id='linkButton']");
    By productoEnCarrito = By.xpath("//span[contains(text(),'(1 productos)')]");
    By lblNombreProducto = By.xpath("//span[@data-testid='name']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void agregarAlCarro(){
        click(esperaExplicita(btnAgregarAlCarro));
        esperarXSegundos(2000);
    }

    public void IrAlCarro(){
        click(esperaExplicita(btnIrAlCarro));
        esperarXSegundos(2000);
    }

    public String obtenerProductosEnCarrito(){
        return obtenerTexto(esperaExplicita(productoEnCarrito));
    }

    public String obtenerNombreProducto(){
        return obtenerTexto(esperaExplicita(lblNombreProducto));
    }


}

