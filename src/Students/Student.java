package Students;/*
1. Создать класс Students.Student, обязательное поле класса Students.Student -
List<Students.Book> (минимум по 5 книг у каждого)

2. Создать текстовый файл со студентами и книгами

3. При помощи внутренних фреймворков и библиотек для ввода-вывода информации в
Java считать содержимое файла и заполнить List<Students.Student> этими данными
(Должен быть реализован механизм заполнения коллекции студентов из текстового файла)

4. При помощи одного (не допускается объявления никаких промежуточных переменных,
совсем никаких) стрима:

Вывести в консоль каждого студента (переопределите toString)

Получить для каждого студента список книг

Получить книги

Отсортировать книги по количеству страниц (Не забывайте про условия для сравнения объектов)

Оставить только уникальные книги

Отфильтровать книги, оставив только те, которые были выпущены после 2000 года

Ограничить стрим на 3 элементах

Получить из книг годы выпуска

При помощи методов короткого замыкания (почитайте самостоятельно что это такое)
вернуть Optional от года

При помощи методов получения значения из Optional вывести в консоль год
выпуска найденной книги, либо запись о том, что такая книга отсутствует
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student {
    private List<Book> books;
    private String name;



    public Student(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getBooks() {return books;}

    public String getName() {return name;}

    @Override
    public  String toString(){
        return String.format("Студент %s, Книги %s ", name,books);
    }

    public static void main(String[] args) {

        List<Student> students = StudentReader.readStudentsFromFile("StudentsBooks.txt");


        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(x -> x.getYear() > 2000)
                .limit(3)
                .map(Students.Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                                () -> System.out.println("Книга, выпущенная после 2000 года, не найдена")
                );




    }





}