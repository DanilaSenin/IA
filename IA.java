import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class IA {

    public static void main(String[] args) {
        try {
            String inputData = "Иванов Иван Иванович 01.01.2000 1234567890 m";
            processData(inputData);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void processData(String inputData) throws Exception {
        String[] data = inputData.split(" ");
        if (data.length != 6) {
            throw new Exception("Неверное количество данных");
        }

        String lastName = data[0];
        String firstName = data[1];
        String patronymic = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}") || !phoneNumber.matches("\\d+")
                || (!gender.equals("m") && !gender.equals("f"))) {
            throw new Exception("Неверный формат данных");
        }

        String fileName = lastName + ".txt";
        String outputData = lastName + firstName + patronymic + birthDate + " " + phoneNumber + gender;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(outputData);
        } catch (IOException e) {
            throw new IOException("Ошибка записи в файл");
        }
        System.out.println("Данные успешно записаны в файл " + fileName);
    }
}