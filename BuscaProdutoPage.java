package br.selenium.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.selenium.param.BuscaProdutoParam;

public class BuscaProdutoPage {
private static final Logger LOG = LoggerFactory.getLogger(BuscaProdutoPage.class);
private WebDriver driver;
public BuscaProdutoPage(WebDriver driver){
this.driver = driver;
}
public void buscaProduto(BuscaProdutoParam buscaProdutoParam){
try{
driver.get("https://www.zoom.com.br/");
WebDriverWait wait = new WebDriverWait(driver, 10);
driver.findElement(By.xpath("//*[@id='search-field']")).sendKeys(buscaProdutoParam.getProduto());
driver.findElement(By.xpath("//*[@id='search-submit']")).click();
}catch(Exception e){
LOG.error("[Busca Produto Page] Erro ao busca produto: " + e.getCause());
}
}

}

