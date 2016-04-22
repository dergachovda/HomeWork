package ua.in.dergachovda.less10.Alarm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AlarmClock clock = new AlarmClock();     // Создаём Будильник
        clock.setName("Alarm clock");
        clock.printCurrentTime();

        while (true) {
            String operation = scanner.nextLine();
            clock.setCurrentTime();
            if (clock.isAlarmTime()) clock.fireAlarm();
            switch (operation) {

                //Exit
                case "close":
                    System.exit(0);
                    break;

                //Help
                case "help":
                    System.out.println("show time - Print current time.");
                    System.out.println("set alarm - Set the alarm time.");
                    System.out.println("alarm ON");
                    System.out.println("alarm OFF");
                    System.out.println("help - Print available commands.");
                    System.out.println("close");
                    break;

                //Print current time
                case "show time":
                    clock.printCurrentTime();
                    break;

                //Set the alarm time
                case "set alarm":
                    System.out.println("Enter the alarm time in hh:mm format:");
                    String enteredTime = scanner.nextLine();
                    String[] time = enteredTime.split(":");
                    clock.setAlarmTime(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
                    break;

                case "alarm ON":
                    clock.setSwitchAlarm(true);
                    break;

                case "alarm OFF":
                    clock.setSwitchAlarm(false);
                    break;

                //Error
                default:
                    System.out.println("Unknown operation, try again");
            }
        }
    }

}