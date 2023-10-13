package singleton_design_pattern;

// Вариант "Эгер" (Eager) с созданием экземпляра в момент загрузки класса.
class SingletonEagar 
{
  private static SingletonEagar instance = new SingletonEagar(); 
  private SingletonEagar()
  {
    // Приватный конструктор.
  }
  
  public static SingletonEagar getInstance()
  {
    return instance;
  }
}

// Вариант "Ленивый" (Lazy) с двойной проверкой блокировки.
class Singleton 
{
  private static Singleton instance; 
  private Singleton()
  {
    // Приватный конструктор.
  }
  
  public static Singleton getInstance() 
  {
    if(instance == null) 
    {
      synchronized (Singleton.class) 
      {
        if(instance == null) 
        {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}

// Вариант "Ленивый" (Lazy) с синхронизированным методом.
class SingletonSynchronizedMethod
{
  private static SingletonSynchronizedMethod instance; 
  private SingletonSynchronizedMethod()
  {
    // Приватный конструктор.
  }
  
  public static synchronized SingletonSynchronizedMethod getInstance() 
  {
    if(instance == null) 
    {
      instance = new SingletonSynchronizedMethod();
    }
    return instance;
  }
}

// Вариант "Ленивый" (Lazy) с синхронизированным блоком.
class SingletonSynchronized 
{
  private static SingletonSynchronized instance; 
  private SingletonSynchronized()
  {
    // Приватный конструктор.
  }
  
  public static SingletonSynchronized getInstance() 
  {
    if(instance == null) 
    {
      synchronized (SingletonSynchronized.class) 
      {
        if(instance == null) 
        {
          instance = new SingletonSynchronized();
        }
      }
    }
    return instance;
  }
}

public class SingletonPattern 
{
  public static void main(String[] args) 
  {
    // Пример использования паттерна Singleton с синхронизированным блоком.
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);
    
    SingletonSynchronized instance1 = SingletonSynchronized.getInstance(); 
    System.out.println(instance1);
  }
}
