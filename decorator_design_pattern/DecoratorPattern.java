package decorator_design_pattern;

// Интерфейс Dress представляет базовую одежду.
interface Dress
{
	 public void assemble();
}

// Класс BasicDress реализует интерфейс Dress и предоставляет базовые характеристики одежды.
class BasicDress implements Dress 
{
	 @Override
	 public void assemble()
	 {
	    System.out.println("Basic Dress Features");
	 }
}

// Абстрактный класс DressDecorator реализует интерфейс Dress и содержит ссылку на другой объект Dress.
abstract class DressDecorator implements Dress
{
	 protected Dress dress;
	 public DressDecorator(Dress c)
	 {
	    this.dress = c;
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    this.dress.assemble();
	 }
}

// Класс CasualDress наследуется от DressDecorator и добавляет характеристики для повседневной одежды.
class CasualDress extends DressDecorator 
{
	 public CasualDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    super.assemble();
	    System.out.println("Adding Casual Dress Features");
	 }
}

// Класс SportyDress наследуется от DressDecorator и добавляет характеристики для спортивной одежды.
class SportyDress extends DressDecorator 
{
	 public SportyDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble() 
	 {
	    super.assemble();
	    System.out.println("Adding Sporty Dress Features");
	 }
}

// Класс FancyDress наследуется от DressDecorator и добавляет характеристики для нарядной одежды.
class FancyDress extends DressDecorator
{
	 public FancyDress(Dress c) 
	 {
	    super(c);
	 }
	  
	 @Override
	 public void assemble()
	 {
	    super.assemble();
	    System.out.println("Adding Fancy Dress Features");
	 }
}

public class DecoratorPattern
{
	  public static void main(String[] args) 
	  {
	      // Создание различных комбинаций одежды с помощью паттерна Декоратор.
	      Dress sportyDress = new SportyDress(new BasicDress());
	      sportyDress.assemble();
	      System.out.println();
	     
	      Dress fancyDress = new FancyDress(new BasicDress());
	      fancyDress.assemble();
	      System.out.println();
	    
	      Dress casualDress = new CasualDress(new BasicDress());
	      casualDress.assemble();
	      System.out.println();
	    
	      Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
	      sportyFancyDress.assemble();
	      System.out.println();
	    
	      Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
	      casualFancyDress.assemble();
	  }
}
