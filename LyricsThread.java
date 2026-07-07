// Sub-class
class Lyrics1Thread extends Thread{
    
    @Override
    public void run(){
        String[] lyrics = {
            "Daisy, Daisy",
            "Give me your answer do",
            "I'm half crazy",
            "All for the love of you",
            "It won't be stylish marriage",
            "I can't afford a carriage",
            "But you'll look sweet on the seat",
            "Of a bicycle built for two"
        };

        System.out.println("\n=== LYRICS 1: Daisy, Daisy ===\n");

        try {
            for (String line : lyrics) {
                System.out.println(line);
                Thread.sleep(1000); // 1 second gap between each line
            }
        } catch (InterruptedException e) {
            System.out.println("\nLyrics1 thread was interrupted!");
            Thread.currentThread().interrupt(); 
        }

        System.out.println("\n=== Lyrics 1 Complete ===\n");
    }
}

// Sub-class for printing Twinkle Twinkle lyrics
class Lyrics2Thread extends Thread {

    @Override
    public void run(){
        String[] lyrics = {
            "Twinkle, twinkle, little star",
            "How I wonder what you are",
            "Up above the world so high",
            "Like a diamond in the sky",
            "When the blazing sun is gone",
            "When he nothing shines upon",
            "Then you show your little light",
            "Twinkle, twinkle, all the night"
        };

        System.out.println("=== LYRICS 2: Twinkle Twinkle Little Star ===\n");

        try {
            for (String line : lyrics) {
                System.out.println(line);
                Thread.sleep(1000); // 1 second pause between lines
            }
        } catch (InterruptedException e) {
            System.out.println("\nLyrics2 thread was interrupted!");
            Thread.currentThread().interrupt(); // Restore interrupt status
        }

        System.out.println("\n=== Lyrics 2 Complete ===\n");
    }
}

public class LyricsThread {
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("      LYRICS THREAD PROGRAM");
        System.out.println("===========================================");
        System.out.println("Two songs will be printed sequentially");
        System.out.println("with 1 second gaps between each line.");
        System.out.println("===========================================");

        // Create thread instances 
        Lyrics1Thread lyrics1 = new Lyrics1Thread();
        Lyrics2Thread lyrics2 = new Lyrics2Thread();

        try {
            // Start the first thread
            lyrics1.start();

            // Pause for lyrics1 to complete before starting lyrics2
            lyrics1.join(); // This ensures lyrics1 finishes first

            // Now start the second thread
            lyrics2.start();

            // Paue and Continue with lyrics2 to complete
            lyrics2.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted!");
            Thread.currentThread().interrupt();
        }


        System.out.println("===================================");
        System.out.println("        ALL LYRICS COMPLETED");
        System.out.println("===================================");
    }
}