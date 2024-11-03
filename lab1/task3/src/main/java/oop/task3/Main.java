package oop.task3;

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(1920, 1080, 200.0f, "Display A");
        Display display2 = new Display(2560, 1440, 300.0f, "Display B");
        Display display3 = new Display(3840, 2160, 400.0f, "Display C");

        Assistant assistant = new Assistant("Mr. Johnson");
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);

        System.out.println( assistant.getAssistantName() +  "is assisting with display comparisons:");
        assistant.assist();

        System.out.println("\nBuying Display B:");
        assistant.buyDisplay(display2);

//        System.out.println("\nRemaining displays after purchase:");
//        assistant.assist();
    }
}
