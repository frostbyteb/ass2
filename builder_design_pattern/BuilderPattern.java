package builder_design_pattern;

// Класс Vehicle представляет транспортное средство с несколькими параметрами.
class Vehicle 
{
  private String engine;
  private int wheel;
  private int airbags;
  
  // Геттеры для получения параметров.
  public String getEngine() 
  {
    return this.engine;
  }
  
  public int getWheel() 
  {
    return this.wheel;
  }
  
  public int getAirbags()
  {
    return this.airbags;
  }
  
  // Приватный конструктор класса Vehicle, доступный только из внутреннего класса VehicleBuilder.
  private Vehicle(VehicleBuilder builder)
  {
    this.engine = builder.engine;
    this.wheel = builder.wheel;
    this.airbags = builder.airbags;
  }
  
  // Внутренний класс VehicleBuilder используется для пошагового конструирования объектов Vehicle.
  public static class VehicleBuilder
  {
    private String engine;
    private int wheel;
    private int airbags;
    
    // Конструктор класса VehicleBuilder принимает обязательные параметры для транспортного средства.
    public VehicleBuilder(String engine, int wheel)
    {
      this.engine = engine;
      this.wheel = wheel;
    }
    
    // Метод для установки необязательного параметра airbags и возврата объекта VehicleBuilder (для цепочного вызова).
    public VehicleBuilder setAirbags(int airbags) 
    {
      this.airbags = airbags;
      return this;
    }
    
    // Метод build() создает объект Vehicle с параметрами, заданными в объекте VehicleBuilder.
    public Vehicle build() 
    {
      return new Vehicle(this);
    }
  }
}

public class BuilderPattern
{
  public static void main(String[] args) 
  {
    // Создание объектов Vehicle с использованием паттерна строителя.
    Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
    Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();
    
    // Вывод параметров созданных транспортных средств.
    System.out.println(car.getEngine());
    System.out.println(car.getWheel());
    System.out.println(car.getAirbags());
    
    System.out.println(bike.getEngine());
    System.out.println(bike.getWheel());
    System.out.println(bike.getAirbags());
  }
}
