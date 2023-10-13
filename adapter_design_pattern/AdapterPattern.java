package adapter_design_pattern;

// Интерфейс WebDriver определяет общие методы для всех водителей браузера.
interface WebDriver 
{
	public void getElement(); // Метод для получения элемента на веб-странице.
	public void selectElement(); // Метод для выбора элемента на веб-странице.
}

// Класс ChromeDriver реализует интерфейс WebDriver и предоставляет конкретную реализацию для водителя браузера Chrome.
class ChromeDriver implements WebDriver 
{
	@Override
	public void getElement() 
	{
	    System.out.println("Get element from ChromeDriver");
	}

	@Override
	public void selectElement() 
	{
	    System.out.println("Select element from ChromeDriver");
	}
}

// Класс IEDriver представляет другой водитель браузера, который не реализует интерфейс WebDriver, но имеет свои собственные методы.
class IEDriver
{
	public void findElement() 
	{
	    System.out.println("Find element from IEDriver");
	}

	public void clickElement()
	{
	    System.out.println("Click element from IEDriver");
	}
}

// Класс WebDriverAdapter реализует интерфейс WebDriver и позволяет адаптировать IEDriver к интерфейсу WebDriver.
class WebDriverAdapter implements WebDriver 
{
	IEDriver ieDriver;

	// Конструктор принимает объект IEDriver, который будет адаптирован к интерфейсу WebDriver.
	public WebDriverAdapter(IEDriver ieDriver) 
	{
	    this.ieDriver = ieDriver;
	}
	  
	@Override
	public void getElement() 
	{
	    // Адаптер вызывает метод findElement() объекта IEDriver, чтобы реализовать метод getElement() интерфейса WebDriver.
	    ieDriver.findElement();
	}

	@Override
	public void selectElement() 
	{
	    // Адаптер вызывает метод clickElement() объекта IEDriver, чтобы реализовать метод selectElement() интерфейса WebDriver.
	    ieDriver.clickElement();
	}
}

public class AdapterPattern
{
    public static void main(String[] args) 
	{
	    ChromeDriver a = new ChromeDriver();
	    a.getElement();
	    a.selectElement();
	    
	    IEDriver e = new IEDriver();
	    e.findElement();
	    e.clickElement();
	    
	    // Создается объект WebDriverAdapter, который позволяет использовать IEDriver как реализацию интерфейса WebDriver.
	    WebDriver wID = new WebDriverAdapter(e);
	    wID.getElement();
	    wID.selectElement();
	}
}
