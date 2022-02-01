package Pages;

import Pages.BasePage;
import Utils.Utils;
import com.itextpdf.text.DocumentException;
import org.openqa.selenium.By;
import Utils.CreatePdf;
import Utils.Hooks;
import java.io.FileNotFoundException;

public class PesquisaPage extends BasePage {

    //Variaveis
    By pesquisaGoogle = By.name("q");
    By botaoPesquisaGoogle = By.name("btnK");
    By validarPesquisaGoogle = By.id("result-stats");
    CreatePdf pdf = new CreatePdf();
    Utils uts = new Utils();

    public PesquisaPage() throws DocumentException, FileNotFoundException {
    }

    public void preencherBarraDePesquisa(String pesquisa) throws Exception {
        driver.findElement(pesquisaGoogle).sendKeys(pesquisa);
        pdf.openDocument();
        pdf.tirarScreenshot();
        PESQUISA_GOOGLE=pesquisa;
    }

    public void botaoPesquisaGoogle() throws Exception {
        driver.findElement(botaoPesquisaGoogle).click();
        pdf.tirarScreenshot();
    }

    public boolean validarResultadoPesquisa() throws Exception {
        driver.findElement(validarPesquisaGoogle).isEnabled();
        pdf.tirarScreenshot();
        pdf.closeDocument();
        return true;
    }
}
