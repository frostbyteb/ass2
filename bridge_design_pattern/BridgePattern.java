package bridge_design_pattern;

// Абстрактный класс TV, представляющий телевизор, имеет ссылку на объект Remote.
abstract class TV 
{
    Remote remote;
    TV(Remote r) 
    {
        this.remote = r;
    }
    abstract void on(); // Метод для включения телевизора.
    abstract void off(); // Метод для выключения телевизора.
}

// Класс Sony, расширяющий TV, представляет телевизор Sony и использует конкретный тип пульта (Remote).
class Sony extends TV
{
    Remote remoteType;
    Sony(Remote r) 
    {
        super(r);
        this.remoteType = r;
    }
  
    public void on()
    {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }
    
    public void off()
    {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}
    
// Класс Philips, также расширяющий TV, представляет телевизор Philips и использует конкретный тип пульта (Remote).
class Philips extends TV 
{
    Remote remoteType;
    Philips(Remote r) 
    {
        super(r);
        this.remoteType = r;
    }
  
    public void on()
    {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }
    
    public void off()
    {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// Интерфейс Remote определяет методы для управления телевизором (включение и выключение).
interface Remote
{
    public void on();
    public void off();
}

// Класс OldRemote реализует интерфейс Remote и предоставляет реализацию старого типа пульта.
class OldRemote implements Remote 
{
    @Override
    public void on()  
    {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() 
    {
        System.out.println("OFF with Old Remote");
    }
}

// Класс NewRemote также реализует интерфейс Remote и предоставляет реализацию нового типа пульта.
class NewRemote implements Remote 
{
    @Override
    public void on() 
    {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() 
    {
        System.out.println("OFF with New Remote");
    }
}

public class BridgePattern 
{
    public static void main(String[] args) 
    {
        // Создание экземпляра Sony TV с использованием старого пульта.
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();
    
        // Создание экземпляра Sony TV с использованием нового пульта.
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();
    
        // Создание экземпляра Philips TV с использованием старого пульта.
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();
    
        // Создание экземпляра Philips TV с использованием нового пульта.
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();  
    }
}
