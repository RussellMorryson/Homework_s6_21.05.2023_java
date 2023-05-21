import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        System.out.println("База данный с ноутбуками");

        Laptop laptop1 = new Laptop("ASUS", "VivoBook PRO", "blue", "AMD Ryzen 5 5600H", 6, 6, 512, "None", 69999);
        Laptop laptop2 = new Laptop("MSI","Modern 15:B12M-215XRU", "black", "Intel Core i3-1215U", 6, 8, 256, "None", 34999);
        Laptop laptop3 = new Laptop("MSI","Katana GF76 11SC-853XRU", "black", "Intel Core i5-11400H", 6, 16, 512, "None", 76999);
        Laptop laptop4 = new Laptop("ASUS","VivoBook PRO", "blue", "AMD Ryzen 5 5600H", 6, 8, 512, "None", 54999);
        Laptop laptop5 = new Laptop("Apple","MacBook Air", "gray", "Apple M1", 8, 8, 256, "macOS", 81899);
        Laptop laptop6 = new Laptop("Maibenben","M543", "silver", "AMD Ryzen 3 4300U", 4, 8, 256, "Linux", 30999);
        Laptop laptop7 = new Laptop("HUAWEI","MateBook D16 RLEF-X", "gray", "Intel Core i7-12700H", 14, 16, 512, "Windows 11 Home", 99999);
        Laptop laptop8 = new Laptop("GIGABYTE","G5 GE", "black", "Intel Core i5-12500H",12, 16, 512, "None", 77999);
        Laptop laptop9 = new Laptop("MSI","Crosshair 17 C12VG-287XRU", "black", "Intel Core i7-12650H", 12, 16, 1000, "None", 154999);
        Laptop laptop10 = new Laptop("ARDOR","GAMING NEO G17-ISND205", "black", "Intel Core i5-12500H", 12, 16, 512, "None", 86999);
        
        Set<String> laps = new HashSet<String>();
        laps.add(laptop1.getFullInfo());
        laps.add(laptop2.getFullInfo());
        laps.add(laptop3.getFullInfo());
        laps.add(laptop4.getFullInfo());
        laps.add(laptop5.getFullInfo());
        laps.add(laptop6.getFullInfo());
        laps.add(laptop7.getFullInfo());
        laps.add(laptop8.getFullInfo());
        laps.add(laptop9.getFullInfo());   
        laps.add(laptop10.getFullInfo());   
             
        Scanner scanner = new Scanner(System.in);
        System.out.println("Начать поиск ноутбуков по критериям 1-да / 0-нет ?");
        int agree = scanner.nextInt();
        if (agree == 1) {
            Map <Integer, String> map = new HashMap<Integer, String>();   
            map = createSearchMap();
            int count = 0;
            for(Map.Entry<Integer, String> pair : map.entrySet()) {
                String value = pair.getValue();
                if (value != "") {
                    count+=1;
                }
            }
            
            int counter = 0;
            int index = 0;
            for(String temp : laps) {            
                for(Map.Entry<Integer, String> pair : map.entrySet()) {                    
                    int key = pair.getKey();
                    String value = pair.getValue();
                    if (key != 5 && key != 6 && key != 7 && key != 9) {
                        index = temp.indexOf(value);
                        if (index != -1) {
                            counter+=1;
                        }
                    } else {
                        if (key == 5) {
                            index = temp.indexOf("количество ядер: " + value);
                            if (index != -1) {
                                counter+=1;
                            }
                        }
                        if (key == 6) {
                            index = temp.indexOf("ОЗУ: " + value);
                            if (index != -1) {
                                counter+=1;
                            }
                        }
                        if (key == 7) {
                            index = temp.indexOf("ЖД: " + value);
                            if (index != -1) {
                                counter+=1;
                            }
                        }
                        if (key == 9) {
                            index = temp.indexOf("цена: " + value);
                            if (index != -1) {
                                counter+=1;
                            }
                        }
                    }                    
                }
                if (counter == count) {
                    System.out.println(temp);
                }
                counter = 0;
            } 
        } else {
            System.out.println("Отмена поиска, программа закрыта!" );
        }
        scanner.close();
    }   

    static Map <Integer, String> createSearchMap() {        
        Scanner scanner = new Scanner(System.in);

        Map <Integer, String> map = new HashMap<Integer,String>(); 
        boolean search = true;
        System.out.println("Поиск ноутбука по критериям!");

        while(search) {
            System.out.println("Введите номер категории для указания критерий: ");
            ArrayList<String> list = new ArrayList<String>();
            list.add(0, "1 - Производитель");
            list.add(1, "2 - Модель");
            list.add(2, "3 - Цвет ноутбука");
            list.add(3, "4 - Название центрального процессора");
            list.add(4, "5 - Количество ядер");
            list.add(5, "6 - Объем оперативной памяти");
            list.add(6, "7 - Объем жесткого диска");
            list.add(7, "8 - Название операционной системы");
            list.add(8, "9 - Стоимость");
            
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

            int number = scanner.nextInt();
            if (number > 0 && number < 9) {
                System.out.println("Выбрана категория: " + list.get(number-1));
            } else {
                System.out.println("Ошибка, повторите попытку!");
                System.out.println("Было введено неверное число или текст");
                continue;
            }
            System.out.println("Введите критерий для поиска: ");
            String criteria = scanner.next();
            map.put(number, criteria);            

            System.out.println("Указаны следующие критерии:");
            for (Map.Entry<Integer, String> pair : map.entrySet()) {
                Integer key = pair.getKey();            // ключ
                String value = pair.getValue();         // значение
                System.out.println(key + ":" + value);
            }

            System.out.println("Хотите указать дополнительные критерии 1-да / 0-нет?");
            int agree = scanner.nextInt();
            if (agree == 0) {
                break;
            }
        }
        scanner.close();
        return map;
    }
}
