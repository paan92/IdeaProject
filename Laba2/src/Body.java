import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Body extends WorkWithBase{

    public Body() {}

    public int bodyProgram(Connection con) throws SQLException{
        WorkWithBase workWithBase = new WorkWithBase();
        int numb = 1;
        while(true){
            System.out.println("1 Вывод базы");
            System.out.println("2 Поиск по базе");
            System.out.println("3 Удаление актера");
            System.out.println("4 Изменение актера");
            System.out.println("5 Добавление актера");

            System.out.println("Выберете ЧИСЛО");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) numb = scanner.nextInt();
            else return 2;
        switch (numb) {
            case 1:
                System.out.println("1 Таблица actor");
                System.out.println("2 Таблица category");
                System.out.println("3 Таблица adress");
                scanner = new Scanner(System.in);
                while(true){
                    if (scanner.hasNextInt()) numb = scanner.nextInt();
                    else return -1;
                    switch (numb) {
                        case 1:
                            workWithBase.seeAllActors(con);
                            break;
                        case 2:
                            workWithBase.seeAllCategory(con);
                            break;
                        case 3:
                            workWithBase.seeAllAddress(con);
                            break;
                }
                }
            case 2:
                System.out.println("1 поиск по имени");
                scanner = new Scanner(System.in);
                while(true){
                    if (scanner.hasNextInt()) numb = scanner.nextInt();
                    else return -1;
                    switch (numb) {
                        case 1:
                            System.out.println("Введите имя актера\n");
                            String name = new String("");
                            Scanner scanner1 = new Scanner(System.in);
                            name = "\"" + scanner1.nextLine() + "\"";
                            workWithBase.search(con, name);
                            break;
                        }
                }
            case 3:
                int temp;
                System.out.println("Введите id актера, которого хотите удалить");
                Scanner scanner1 = new Scanner(System.in);
                do {
                    if (scanner1.hasNextInt()) {
                        temp = scanner1.nextInt();
                        break;
                    }
                } while(true);
                workWithBase.delete(con, temp);
                System.out.println("Запись удалена");
                break;
            case 4:
                temp = -1;
                System.out.println("Введите id актера, которого хотите удалить");
                scanner1 = new Scanner(System.in);
                do {
                    if (scanner1.hasNextInt()) {
                        temp = scanner1.nextInt();
                        break;
                    }
                } while(true);
                workWithBase.update(con, temp);
                System.out.println("Запись успешно изменена");
                break;
            case 5:
                temp = -1;
                workWithBase.add(con);
                System.out.println("Запись успешно добавлена");
                break;
    }}
}}
