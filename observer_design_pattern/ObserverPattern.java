package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Интерфейс Subject представляет наблюдаемый субъект.
interface Subject 
{
    void register(Observer obj); // Метод для регистрации наблюдателя.
    void unregister(Observer obj); // Метод для удаления наблюдателя.
    void notifyObservers(); // Метод для уведомления наблюдателей о изменениях.
}

// Класс DeliveryData реализует интерфейс Subject и представляет данные о доставке.
class DeliveryData implements Subject
{
    private List<Observer> observers;
    private String location;
  
    public DeliveryData() 
    {
        this.observers = new ArrayList<>();
    }
  
    @Override
    public void register(Observer obj) 
    {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) 
    {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers()
    {
      for(Observer obj : observers) 
      {
          obj.update(location);
      }
    }

    public void locationChanged()
    {
        this.location = getLocation();
        notifyObservers();
    }
  
    public String getLocation() 
    {
      return "YPlace";
    }
}

// Интерфейс Observer представляет наблюдателя.
interface Observer
{
    public void update(String location);
}

// Класс Seller реализует интерфейс Observer и представляет продавца.
class Seller implements Observer 
{
    private String location;
  
    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// Класс User также реализует интерфейс Observer и представляет пользователя.
class User implements Observer 
{
    private String location;
  
    @Override
    public void update(String location) 
    {
        this.location = location;
        showLocation();
    }

    public void showLocation() 
    {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// Класс DeliveryWarehouseCenter также реализует интерфейс Observer и представляет центр доставки.
class DeliveryWarehouseCenter implements Observer
{
    private String location;
  
    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

public class ObserverPattern
{
    public static void main(String[] args)
    {
        DeliveryData topic = new DeliveryData();
    
        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();
    
        // Регистрация наблюдателей.
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);
        
        // Изменение местоположения и уведомление наблюдателей.
        topic.locationChanged();
        
        // Отмена регистрации одного из наблюдателей.
        topic.unregister(obj3);
    
        System.out.println();
        
        // Снова изменение местоположения и уведомление остальных наблюдателей.
        topic.locationChanged();
    }
}
