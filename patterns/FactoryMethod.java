Фабричный метод - это порождающий паттерн проектирования, который
определяет общий интерфейс для создания объектов в суперклассе, 
позволяя подклассам изменятьтип создаваемых объектов.

- Сперва вы рассчитываете перевозить товары только на автомобилях. 
Поэтому весь ваш код работает с объектами класса Грузовик.
В какой-то момент ваша программа становится настолько известной, 
что морские перевозчики выстраиваются в очередь и просят добавить 
поддержку морской логистики в программу.

-Чтобы эта система заработала, все возвращаемые объекты должны иметь общий интерфейс.  


package patterns;

/**В этом примере определены интерфейсы Animal и AnimalFactory.
 * Классы Cat и Dog реализуют интерфейс Animal,
 * а классы CatFactory и DogFactory реализуют интерфейс AnimalFactory.
 * Таким образом, CatFactory и DogFactory могут создавать объекты Cat и Dog соответственно.
 * В методе main мы создаем экземпляры DogFactory и CatFactory, 
 * затем используя эти фабрики создаем объекты dog и cat. 
 * Наконец, мы вызываем метод makeSound() для каждого из них, 
 * чтобы произвести звук, свойственный этому животному. 
 */

interface Animal {
    void makeSound();
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

interface AnimalFactory {
    Animal createAnimal();
}

class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        AnimalFactory catFactory = new CatFactory();

        Animal dog = dogFactory.createAnimal();
        Animal cat = catFactory.createAnimal();

        dog.makeSound(); // Output: Woof!
        cat.makeSound(); // Output: Meow!
    }
}