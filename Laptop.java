public class Laptop {
    // ----------------------------------------------------------
    // Основной блок с переменными

    private String manufacturer;    // Производитель
    private String model;           // Модель
    private String color;           // Цвет ноутбука
    private String cpu;             // Название установленного центрального процессора
    private int core;               // Количество ядер
    private int ram;                // Объем установленной оперативной памяти
    private int rom;                // Объем жесткого диска
    private String system;          // Наименование операционной системы
    private int price;              // Стоимость в руб.

    // ----------------------------------------------------------
    // Блок с возвратом значений get

    public String getManufacturer() {return manufacturer;}
    public String getModel() {return model;}
    public String getColor() {return color;}
    public String getCpu() {return cpu;}
    public int getCore() {return core;}
    public int getRam() {return ram;}
    public int getRom() {return rom;}
    public String getSystem() {return system;}
    public int getPrice() {return price;}
    public String getFullInfo() {
        return "Производитель: " + manufacturer
        + ", модель: " + model 
        + ", цвет: " + color 
        + ", ЦП: " + cpu 
        + ", количество ядер: " + core 
        + ", ОЗУ: " + ram 
        + ", ЖД: " + rom
        + ", система: " + system
        + ", цена: " + price;
    }

    // ----------------------------------------------------------
    // Блок с присваиванием значений переменных set
    // Данный блок может применяться для исправления ошибок

    public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}
    public void setModel(String model) {this.model = model;}
    public void setColor(String color) {this.color = color;}
    public void setCpu(String cpu) {this.cpu = cpu;}
    public void setCore(int core) {this.core = core;}
    public void setRam(int ram) {this.ram = ram;}
    public void setRom(int rom) {this.rom = rom;}
    public void setSystem(String system) {this.system = system;}
    public void setPrice(int price) {this.price = price;}

    // ----------------------------------------------------------
    // Формирвоание конструктора
    // Контруктор применятся для быстрого формирования объекта и 
    // указания его характеристик

    Laptop(String manufacturer,  String model, String color, String cpu, int core, int ram, int rom, String system, int price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
        this.cpu = cpu;
        this.core = core;
        this.ram = ram;
        this.rom = rom;
        this.system = system;
        this.price = price;
    }    
}

