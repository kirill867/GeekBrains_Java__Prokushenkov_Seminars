package lesson_6;

//
//    Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//            Создать множество ноутбуков.
//            Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
//
//            NoteBook notebook1 = new NoteBook
//            NoteBook notebook2 = new NoteBook
//            NoteBook notebook3 = new NoteBook
//            NoteBook notebook4 = new NoteBook
//            NoteBook notebook5 = new NoteBook
//
//            Например: “Введите цифру, соответствующую необходимому критерию:
//            1 - ОЗУ
//            2 - Объем ЖД
//            3 - Операционная система
//            4 - Цвет
//
//            Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//
//            Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
//
//            Класс сделать в отдельном файле
//
//            приветствие
//            Выбор параметра
//            выбор конкретнее
//            вывод подходящих


import java.util.LinkedHashMap;

public class task {
    public static void main(String[] args) {

        NoteBookShop shop = new NoteBookShop();
        shop.addNoteBook(new NoteBook("Lenovo", "X100", "RAM: 1024, OS: AOS, SSD: 250, Color: White"));
        shop.addNoteBook(new NoteBook("Lenovo", "X200", "RAM: 1024, OS: LIN, SSD: 1000, Color: Black"));
        shop.addNoteBook(new NoteBook("Lenovo", "X300", "RAM: 4096, OS: AOS, SSD: 1000, Color: Blue"));
        shop.addNoteBook(new NoteBook("Lenovo", "X400", "RAM: 1024, OS: AOS, SSD: 250, Color: White"));
        shop.addNoteBook(new NoteBook("Lenovo", "X500", "RAM: 1024, OS: AOS, SSD: 500, Color: Black"));
        shop.addNoteBook(new NoteBook("Lenovo", "X600", "RAM: 4096, OS: AOS, SSD: 750, Color: Blue"));
        shop.addNoteBook(new NoteBook("Sony", "X700", "RAM: 1024, OS: WIN, SSD: 2000, Color: Black"));


        shop.userMenu();
    }
}
