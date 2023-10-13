package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Класс Vehicle реализует интерфейс Cloneable, чтобы поддерживать клонирование.
class Vehicle implements Cloneable 
{
  private List<String> vehicleList;
  
  public Vehicle() 
  {
    this.vehicleList = new ArrayList<String>();
  }
  
  public Vehicle(List<String> list) 
  {
    this.vehicleList = list;
  }
  
  public void insertData()
  {
    vehicleList.add("Honda amaze");
    vehicleList.add("Audi A4");
    vehicleList add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }
  
  public List<String> getVehicleList() 
  {
    return this.vehicleList;
  }
  
  @Override
  public Object clone() throws CloneNotSupportedException 
  {
    List<String> tempList = new ArrayList<String>();
    
    for(String s : this.getVehicleList()) 
    {
      tempList.add(s);
    }
    
    return new Vehicle(tempList);
  }
}

public class PrototypePattern
{
  public static void main(String[] args) throws CloneNotSupportedException 
  {
    Vehicle a = new Vehicle();
    a.insertData();
    
    // Создаем копию объекта 'a' с помощью метода clone().
    Vehicle b = (Vehicle) a.clone();
    List<String> list = b.getVehicleList();
    
    // Модифицируем копию.
    list.add("Honda new Amaze");
    
    // Выводим списки из исходного объекта 'a' и его копии 'b'.
    System.out.println("Original Vehicle List: " + a.getVehicleList());
    System.out.println("Modified Vehicle List (b): " + list);
    
    // Удаляем элемент из копии.
    b.getVehicleList().remove("Audi A4");
    
    // Выводим списки после удаления элемента из копии 'b'.
    System.out.println("Modified Vehicle List (b) after removal: " + b.getVehicleList());
    System.out.println("Original Vehicle List (a): " + a.getVehicleList());
  }
}
