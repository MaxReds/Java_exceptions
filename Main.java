import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a data (LastName Firstname Patronymic Birthdate(dd.mm.yyyy) PhoneNumber Gender):");
        String input = scanner.nextLine();

        String[] inputData = input.split(" ");
        if (inputData.length != 6) {
            System.out.println("Error: Invalid amount of data.");
            return;
        }

        try {
            String surname = inputData[0];
            String name = inputData[1];
            String patronymic = inputData[2];
            String birthDate = inputData[3];
            long phoneNumber = Long.parseLong(inputData[4]);
            char gender = inputData[5].charAt(0);

            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Error: Invalid gender format.");
            }

            String fileName = surname + ".txt";
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender + "\n");
            writer.close();

            System.out.println("Data successfully written to file" + fileName);

            
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid phone number format.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to file:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
