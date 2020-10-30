package StepDefinition;

//import java.sql.Connection;
import java.sql.DriverManager;


import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given; 
import cucumber.api.java.en.Then; 
import cucumber.api.java.en.When; 



public class Steps {
	
	private WebDriver driver;	
	//private connection;
	
	@Given("abrir navegador") 
	public void abrir_chrome() { 
	// Write code here that turns the phrase above into concrete actions 
   // System.setProperty("webdriver.gecko.driver","D:\\01-Programacion\\Drivers\\geckodriver.exe");	
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Marcelo\\Desktop\\IPLACEX\\IntegracionContinua\\geckodriver.exe");
		System.out.println("En este paso abre el navegador google chrome"); 
		driver = new FirefoxDriver(); 
		driver.manage().window().maximize(); 
		driver.get("http://localhost:8080/EVA2/faces/login.jsp");		
	} 
	
	@When("ingresa Username {string} y Password {string}") 
	public void ingresa_Username_y_Password(String string, String string2) { 
	// Write code here that turns the phrase above into concrete actions 
		System.out.println("En ete paso ingresa las credenciales de usuario"); 
		driver.findElement(By.id("j_id_jsp_32452787_1:userName")).sendKeys(string);
		driver.findElement(By.id("j_id_jsp_32452787_1:password")).sendKeys(string2);
	}
	
	@Then("inicia sesion") 
	public void inicia_sesion() {
	// Write code here that turns the phrase above into concrete actions 
		System.out.println("En este paso inicia sesion con los datos ingresados desde nuestro archivo Mytest.feature"); 
		driver.findElement(By.id("j_id_jsp_32452787_1:loginbtn")).click();
	}
	
	@And("Cerrar navegador")
	public void cerrar_navegador() {
		driver.close();
	}
	
	
	@When("Probar conexion BD {string}")
	public void conexionBD(String url) {
		
		try {
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection(url,"root","root");		
        System.out.println("OK");
		}catch(Exception ex) {
			System.out.println("FALLO");
		}
		
	}
	
}
