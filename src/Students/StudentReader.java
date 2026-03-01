package Students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentReader {
    public static List<Student> readStudentsFromFile(String filename) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            Student currentStudent = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    if (currentStudent != null && currentStudent.getBooks().size() >= 5){
                        students.add(currentStudent);
                    }
                    currentStudent = null;
                }else if (currentStudent == null){
                    currentStudent = new Student(line);
                }else {
                    String[] bookData = line.split(";");
                    if (bookData.length == 3) {
                        String title = bookData[0];
                        int pages = Integer.parseInt(bookData[1]);
                        int year = Integer.parseInt(bookData[2]);

                        Book book = new Book(title, pages, year);
                        currentStudent.addBook(book);
                    }
                }
            }

            if (currentStudent != null && currentStudent.getBooks().size() >= 5) {
                students.add(currentStudent);
            }

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        return students;
    }


}
