package Steps;

import Api.ApiMakeUp;
import Pages.PesquisaPage;
import Utils.Hooks;
import Utils.Utils;
import com.itextpdf.text.DocumentException;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Steps {

        Hooks hs = new Hooks();
        PesquisaPage ps = new PesquisaPage();
        Utils uts = new Utils();
        ApiMakeUp api = new ApiMakeUp();
        int statusCode = 0;
        public Steps() throws DocumentException, FileNotFoundException {
        }

        @Dado("que acesso o site do google")
        public void dadoQueAcessoOGoogle() throws DocumentException, FileNotFoundException {
        hs.setUp();
        System.out.println("Acessando o site do google");
        }

        @Quando("preencher a barra de pesquisa com {string}")
        public void preencherCampoDePesquisa(String pesquisa) throws Exception {
        ps.preencherBarraDePesquisa(uts.arquivoTxt(pesquisa));
        ps.botaoPesquisaGoogle();
        }

        @Entao("visualizo o resultado da busca")
        public void visualizarResultadoDaBusca() throws Exception {
        Assert.assertTrue(ps.validarResultadoPesquisa());
         hs.tearDown();
        System.out.println("Finalizando o teste");
        }


        @Dado("que limpo as pastas")
        public void queLimpoAsPastas() {
         System.out.println("Limpando a pasta de Evidências");
         uts.deleteArquivos();
        }











        // -------------------------STEPS DOS TESTES DA API ----------------------------------------------------------------------------------//



        @Dado("que realizo uma requisicao get")
        public void queRealizoUmaRequisicaoGet() {
         statusCode = api.apiMakeUpBuscaPorMarcas("almay");
        }

        @Entao("o status code devera ser {int}")
        public void oStatusCodeDeveraSer(int statusCode) {
        Assert.assertEquals(statusCode,statusCode);
        }
}