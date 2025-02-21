package bmiindex;

import java.util.Scanner;

public class BMIindex {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BMIfeladat();
    }

    public static void BMIfeladat() {
        kiir("BMI kiszámítás\n------------------\n");
        double m = beker("Testmagasság");
        double t = beker("Testsúly");
        kiir("--------------------\n");
        double bmi = bMISzamitas(t, m);
        ertekeles(bmi);
    }

    public static void kiir(String szoveg) {
        System.out.print(szoveg);
    }

    public static double beker(String kerdes) {
        double adat = 0;
        boolean eldont = false;

        while (!eldont) {
            kiir(kerdes + " (100-200 cm között):");
            adat = sc.nextDouble();

            if (kerdes.equals("Testmagasság")) {
                if (adat >= 100 && adat <= 200) {
                    eldont = true;
                } else {
                    kiir("\nHibás adat! Kérjük, adja meg újra a helyes magasságot.\n");
                }
            } else if (kerdes.equals("Testsúly")) {
                if (adat >= 40 && adat <= 150) {
                    eldont = true;
                } else {
                    kiir("\nHibás adat! Kérjük, adja meg újra a helyes testsúlyt.\n");
                }
            }
        }

        return adat;
    }

    public static double bMISzamitas(double t, double m) {
        m = m / 100;
        return t / (m * m);
    }

    public static void ertekeles(double bmi) {
        if (bmi < 20) {
            kiir("Sovány\n");
        } else if (bmi >= 20 && bmi < 25) {
            kiir("Normál súlyú\n");
        } else if (bmi >= 25 && bmi < 30) {
            kiir("Túlsúlyos\n");
        } else if (bmi >= 30 && bmi < 40) {
            kiir("Elhízott\n");
        } else {
            kiir("Kórosan elhízott\n");
        }
    }
}
