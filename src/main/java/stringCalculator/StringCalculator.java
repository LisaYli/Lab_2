package stringCalculator;


public class StringCalculator {


    public int add(String numbers) {
        String delimiter = ",|/|\n|;";
        String[] numbersArray = numbers.split(delimiter);
        int result = 0;
        int numbersParsedToInt = 0;

        for (String number : numbersArray) {
            // regex: "-\\d+" matchar alla negativa number
            boolean matchesNegativeNumbers = number.matches("-\\d+");

            if (!number.trim().isEmpty() && !matchesNegativeNumbers) {
                numbersParsedToInt = Integer.parseInt(number.trim());
                if (numbersParsedToInt <= 1000) {
                    result += numbersParsedToInt;
                }
            } else if (matchesNegativeNumbers) {
                negativeNumbersGivesRuntimeException(number);
            }

        }
        return result;
    }

    private static void negativeNumbersGivesRuntimeException(String numbers) {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                System.out.println("** Negative numbers like " + numbers + " are not allowed! **");
            }
        }
    }


