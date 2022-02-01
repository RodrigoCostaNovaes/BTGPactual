package Utils;

import Pages.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class Utils extends BasePage {


        public void screenShot() {
            //Take the screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //Copy the file to a location and use try catch block to handle exception
            try {
                FileUtils.copyFile(screenshot, new File("./src/test/resources/Evidencias/EvidenciasBTGPactual"+dataDoarquivo()+".png"));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

            public String arquivoTxt(String comparar) throws IOException {
                Path path = Paths.get("./src/test/resources/Massa/Dados.txt");
                List<String> linhasArquivo = Files.readAllLines(path);
                for (String linha : linhasArquivo) {
                    comparar = comparar.replace("<", "");
                    comparar = comparar.replace(">", "");
                    if (linha.equalsIgnoreCase(comparar)) {
                        System.out.println("Buscando por : "+linha);
                        return linha;
                    }
                }
                return null;
}

    public static String insertDateNow() {
        SimpleDateFormat formatDate = new SimpleDateFormat("ddMMyyyy");
        Date dataAtual = new Date();
        String data = formatDate.format(dataAtual);
        System.out.println(data);
        return data;
    }

    public String dataDoarquivo() {
        SimpleDateFormat formatDate = new SimpleDateFormat("ddMMyyyy_HHmmss");
        Date dataAtual = new Date();
        String data = formatDate.format(dataAtual);
        System.out.println(data);
        return data;
    }

    public void deleteArquivos() {
        File pasta = new File("./src/test/resources/Evidencias/");
        File[] arquivos = pasta.listFiles();

        for (File arquivo : arquivos) {
            if (arquivo.getName().endsWith(".pdf")) {
                arquivo.delete();
            }
        }

    }
}

