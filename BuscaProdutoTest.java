package br.selenium.test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.selenium.page.BuscaProdutoPage;
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