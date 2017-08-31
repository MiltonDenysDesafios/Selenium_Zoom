# Selenium_Zoom
My automation using selenium webdriver
This Selenium automation is useful for searching things in Zoom website.

package br.selenium.param;

public class BuscaProdutoParam {
private String produto;
public String getProduto(){
return produto;
}
public void setProduto(String produto){
this.produto = produto;
}
}

package br.selenium.test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.selnium.page.BuscaProdutoPage;
import br.selenium.param.BuscaProdutoParam;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BuscaProdutoTest {
WebDriver driver;
private BuscaProdutoPage buscaProdutoPage;
private BuscaProdutoParam buscaProdutoParam;

@BeforeClass
public void setUp(){
ChromeDriverManager.getInstance().setup();
driver = new ChromeDriver();
driver.manage().window().maximize();
buscaProdutoPage = new BuscaProdutoPage(driver);
buscaProdutoParam = new BuscaProdutoParam();
}
@Test(priority = 1)
public void invalidSearch1(){
buscaProdutoParam.setProduto("celular");
buscaProdutoPage.buscaProduto(buscaProdutoParam);
Assert.assertFalse(driver.getPageSource().contains("12345"));
}
@Test(priority = 2)
public void invalidSearch2(){
buscaProdutoParam.setProduto("computadores");
buscaProdutoPage.buscaProduto(buscaProdutoParam);
Assert.assertFalse(driver.getPageSource().contains("12345"));
}
@Test(priority = 3)
public void invalidSearch3(){
buscaProdutoParam.setProduto("televisao");
buscaProdutoPage.buscaProduto(buscaProdutoParam);
Assert.assertTrue(driver.getPageSource().contains("12345"));
}
}

package br.selnium.page;
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



