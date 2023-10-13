package proxy_design_pattern;

// Интерфейс DatabaseExecuter определяет метод для выполнения запросов к базе данных.
interface DatabaseExecuter 
{
	public void executeDatabase(String query) throws Exception;
}

// Реализация интерфейса DatabaseExecuter для выполнения запросов к базе данных.
class DatabaseExecuterImpl implements DatabaseExecuter
{
	@Override
	public void executeDatabase(String query) throws Exception
	{
	    System.out.println("Going to execute Query: " + query);
	}
}

// Прокси-класс DatabaseExecuterProxy, который контролирует доступ к базе данных.
class DatabaseExecuterProxy implements DatabaseExecuter
{
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;
	  
	public DatabaseExecuterProxy(String name, String passwd)
	{
	    if(name.equals("Admin") && passwd.equals("Admin@123")) 
	    {
	      ifAdmin = true;
	    }
	    dbExecuter = new DatabaseExecuterImpl();
	}

    @Override
	public void executeDatabase(String query) throws Exception
    {
	    if(ifAdmin) 
	    {
	        dbExecuter.executeDatabase(query);
	    } 
	    else 
	    {
	        if(query.equals("DELETE")) 
	        {
	            throw new Exception("DELETE not allowed for non-admin user");
	        }
	        else 
	        {
	            dbExecuter.executeDatabase(query);
	        }
	    }
	}
}

public class ProxyPattern
{
	 public static void main(String[] args) throws Exception
	 {
	      // Создание прокси для пользователя с правами администратора.
	      DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
	      nonAdminExecuter.executeDatabase("DELEE"); // Опечатка в "DELETE", будет выполнено запрос "DELEE".
	    
	      // Создание прокси для пользователя с правами администратора.
	      DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
	      nonAdminExecuterDELETE.executeDatabase("DELETE"); // Выбросит исключение, так как DELETE не разрешен для non-admin.
	      
	      // Создание прокси для администратора.
	      DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
	      adminExecuter.executeDatabase("DELETE"); // Выполнит запрос DELETE, так как администратор имеет доступ.
	 }
}
