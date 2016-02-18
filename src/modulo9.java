/**
 * modulo9 - searches for some unique years based on some interesting math with modulos.
 * It takes the current year and finds the modulo for 1 through 9, placing it into an array from 9 to 1.
 * It then looks at that number and figures out what number system best describes it.
 * Then it converts it to base10 and divides the year by that number we found.
 * If the result is zero, then it is a special year, and it will display the current year,
 *      the unique array that was found dividing the modulos, and the converted base 10 number.
 * Then the program will then display the number of unique years via their number system at the end.
 *
 * I did this because of an off hand calculation about the year 2016, which turns out to be the first
 *      year of it's kind to ever happen. Not to happen again till the year 7056.
 *
 * @author Kevin Falting
 * @version 1.0
 */

public class modulo9 {

    public static int binaryCount = 0;
    public static int ternaryCount = 0;
    public static int quaternaryCount = 0;
    public static int quinaryCount = 0;
    public static int senaryCount = 0;
    public static int base7Count = 0;
    public static int octalCount = 0;
    public static int base9Count = 0;

    public static void main(String[] args) {
        int year = 0;
        int endYear = 10000;

        while (year <= endYear) {
            //calculating the modulo tests
            int[] resultCollectorArray = findResultCollectorArray(year);

            //converting the results into different formats
            String findResultCollectorString = findResultCollectorString(resultCollectorArray);
            int resultCollectorInt = findResultCollectorInteger(findResultCollectorString);

            //checking what number system it is in
            boolean isBinary = isBinary(resultCollectorArray);
            boolean isTernary = isTernary(resultCollectorArray);
            boolean isQuaternary = isQuaternary(resultCollectorArray);
            boolean isQuinary = isQuinary(resultCollectorArray);
            boolean isSenary = isSenary(resultCollectorArray);
            boolean isBase7 = isBase7(resultCollectorArray);
            boolean isOctal = isOctal(resultCollectorArray);
            boolean isBase9 = isBase9(resultCollectorArray);

            //printing the results
            if (isBinary) {
                int resultCollectorInBase10 = convertToBaseTen(findResultCollectorString, 2);
                if (resultCollectorInBase10 != 0 && (year % resultCollectorInBase10) == 0) {
                    System.out.println("year: " + year + "\nbinary: " + resultCollectorInt + "\nbase10: " + resultCollectorInBase10);
                    System.out.println("It is a very special year\n");
                    binaryCount++;
                }
            } else if (isTernary) {
                int resultCollectorInBase10 = convertToBaseTen(findResultCollectorString, 3);
                if (resultCollectorInBase10 != 0 && (year % resultCollectorInBase10) == 0) {
                    System.out.println("year: " + year + "\nternary: " + resultCollectorInt + "\nbase10: " + resultCollectorInBase10);
                    System.out.println("It is a very special year\n");
                    ternaryCount++;
                }
            } else if (isQuaternary) {
                int resultCollectorInBase10 = convertToBaseTen(findResultCollectorString, 4);
                if (resultCollectorInBase10 != 0 && (year % resultCollectorInBase10) == 0) {
                    System.out.println("year: " + year + "\nquaternary: " + resultCollectorInt + "\nbase10: " + resultCollectorInBase10);
                    System.out.println("It is a very special year\n");
                    quaternaryCount++;
                }
            } else if (isQuinary) {
                int resultCollectorInBase10 = convertToBaseTen(findResultCollectorString, 5);
                if (resultCollectorInBase10 != 0 && (year % resultCollectorInBase10) == 0) {
                    System.out.println("year: " + year + "\nquinary: " + resultCollectorInt + "\nbase10: " + resultCollectorInBase10);
                    System.out.println("It is a very special year\n");
                    quinaryCount++;
                }
            } else if (isSenary) {
                int resultCollectorInBase10 = convertToBaseTen(findResultCollectorString, 6);
                if (resultCollectorInBase10 != 0 && (year % resultCollectorInBase10) == 0) {
                    System.out.println("year: " + year + "\nsenary: " + resultCollectorInt + "\nbase10: " + resultCollectorInBase10);
                    System.out.println("It is a very special year\n");
                    senaryCount++;
                }
            } else if (isBase7) {
                int resultCollectorInBase10 = convertToBaseTen(findResultCollectorString, 7);
                if (resultCollectorInBase10 != 0 && (year % resultCollectorInBase10) == 0) {
                    System.out.println("year: " + year + "\nbase7: " + resultCollectorInt + "\nbase10: " + resultCollectorInBase10);
                    System.out.println("It is a very special year\n");
                    base7Count++;
                }
            } else if (isOctal) {
                int resultCollectorInBase10 = convertToBaseTen(findResultCollectorString, 8);
                if (resultCollectorInBase10 != 0 && (year % resultCollectorInBase10) == 0) {
                    System.out.println("year: " + year + "\noctal: " + resultCollectorInt + "\nbase10: " + resultCollectorInBase10);
                    System.out.println("It is a very special year\n");
                    octalCount++;
                }
            } else if (isBase9) {
                int resultCollectorInBase10 = convertToBaseTen(findResultCollectorString, 9);
                if (resultCollectorInBase10 != 0 && (year % resultCollectorInBase10) == 0) {
                    System.out.println("year: " + year + "\nbase9: " + resultCollectorInt + "\nbase10: " + resultCollectorInBase10);
                    System.out.println("It is a very special year\n");
                    base9Count++;
                }
            }
            year++;
        }

        System.out.println("\n\nThese are the number of special years in their different counting systems\n" +
                "between year 0 and " + endYear + "\n" +
                "binary:\t\t" + binaryCount + "\n" +
                "ternary:\t" + ternaryCount + "\n" +
                "qauternary:\t" + quaternaryCount + "\n" +
                "quinary:\t" + quinaryCount + "\n" +
                "senary:\t\t" + senaryCount + "\n" +
                "base7:\t\t" + base7Count + "\n" +
                "octal:\t\t" + octalCount + "\n" +
                "base9:\t\t" + base9Count + "\n");
    }

    /**
     * findResultCollectorArray - calculates the modulo expression from 1 to 9 and returns the results
     * as an array.
     * @param currentYear - the current year that we are on
     * @return resultCollector - this is an array of the results from 9 to 1, respectively.
     */
    public static int[] findResultCollectorArray(int currentYear) {
        int modulo9 = currentYear % 9;
        int modulo8 = currentYear % 8;
        int modulo7 = currentYear % 7;
        int modulo6 = currentYear % 6;
        int modulo5 = currentYear % 5;
        int modulo4 = currentYear % 4;
        int modulo3 = currentYear % 3;
        int modulo2 = currentYear % 2;
        int modulo1 = 0;

        int[] resultCollector = {modulo9, modulo8, modulo7, modulo6, modulo5, modulo4, modulo3, modulo2, modulo1};

        return resultCollector;
    }

    /**
     * findResultCollectorString - converts the resultCollectorArray to a String
     * @param resultCollectorArray
     * @return resultCollectorString - a string version of the resultCollectorArray
     */
    public static String findResultCollectorString(int[] resultCollectorArray) {
        String resultCollectorString = new String();

        for (int i = 0; i < resultCollectorArray.length; i++) {
            resultCollectorString += resultCollectorArray[i];
        }

        return resultCollectorString;
    }

    /**
     * findResultCollectorInteger - converts the resultCollectorString to an Integer
     * @param resultCollectorString
     * @return resultCollectorInt - The converted value of resultCollectorString to an integer
     */
    public static int findResultCollectorInteger(String resultCollectorString) {
        int resultCollectorInt;

        resultCollectorInt = Integer.parseInt(resultCollectorString);

        return resultCollectorInt;
    }

    /**
     * convertToBaseTen - converts to base 10 given the number to convert and what base it is in.
     * @param resultCollectorString
     * @param base - what base numeral system are we converting from? binary: 2, ternary: 3, and so on.
     * @return
     */
    public static int convertToBaseTen(String resultCollectorString, int base) {
        int base10 = Integer.parseInt(resultCollectorString, base);
        return base10;
    }

    /**
     * isBinary - checks to see if an integer array only contains 0 and 1
     * @param number
     * @return true or false depending on whether it passes the binary test
     */
    public static boolean isBinary(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * isTernary - checks to see if an integer array only contains 0, 1, and 2
     * @param number
     * @return true or false depending on whether it passes the ternary test
     */
    public static boolean isTernary(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * isQuaternary - checks to see if an integer array only contains 0, 1, 2, and 3
     * @param number
     * @return
     */
    public static boolean isQuaternary(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 3) {
                return false;
            }
        }
        return true;
    }

    /**
     * isQuinary - checks to see if an integer array only contains 0, 1, 2, 3, and 4
     * @param number
     * @return
     */
    public static boolean isQuinary(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 4) {
                return false;
            }
        }
        return true;
    }

    /**
     * isSenary - checks to see if an integer array only contains 0, 1, 2, 3, 4, and 5
     * @param number
     * @return
     */
    public static boolean isSenary(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 5) {
                return false;
            }
        }
        return true;
    }

    /**
     * isBase7 - checks to see if an integer array only contains 0, 1, 2, 3, 4, 5 and 6
     * @param number
     * @return
     */
    public static boolean isBase7(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 6) {
                return false;
            }
        }
        return true;
    }

    /**
     * isOctal - checks to see if an integer array only contains 0, 1, 2, 3, 4, 5, 6 and 7
     * @param number
     * @return
     */
    public static boolean isOctal(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 7) {
                return false;
            }
        }
        return true;
    }

    /**
     * isBase9 - checks to see if an integer array only contains 0, 1, 2, 3, 4, 5, 6, 7 and 8
     * @param number
     * @return
     */
    public static boolean isBase9(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 8) {
                return false;
            }
        }
        return true;
    }
}
