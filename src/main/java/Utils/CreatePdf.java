package Utils;

import java.io.*;
import Pages.BasePage;
import com.itextpdf.text.*;

import com.itextpdf.text.pdf.PdfWriter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class CreatePdf extends BasePage {


    public CreatePdf() throws FileNotFoundException, DocumentException {
    }

    Utils uts = new Utils();
    Document document = new Document();
    String output = "./src/test/resources/Evidencias/EvidenciasBTGPactual-"+PESQUISA_GOOGLE+uts.dataDoarquivo()+".pdf";
    FileOutputStream fos = new FileOutputStream(output);
    PdfWriter writer = PdfWriter.getInstance(document, fos);

    public  byte[] takeScreenshot(){
        byte[] input = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        return input;
    }

    public String getStringPesquisa(String pesquisas){
        String Pesquisas = pesquisas;
        return Pesquisas;
    }
    public void closeDocument(){
        //close the files and write to local system
        document.close();
        writer.close();
    }

    public void openDocument() throws DocumentException {
        document.open();
        document.add(new Chunk(""));
        writer.open();
    }

    public void tirarScreenshot() throws Exception {
        document.add(new Paragraph("Evidência : "+"\n"));
        takeScreenshot();
        openAndAddImageToPdf();
    }

    public void openAndAddImageToPdf() throws Exception
    {
        // process content into image
        Image im = Image.getInstance(takeScreenshot());

        //set the size of the image
        im.scaleToFit(PageSize.A4.getWidth()/2, PageSize.A4.getHeight()/2);

        // add the captured image to PDF
        document.add(im);
    }
}
