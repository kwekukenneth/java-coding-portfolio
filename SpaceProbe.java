public class SpaceProbe {
    public static void main(String[] args) {
        
        SpaceProbeController controller = new SpaceProbeController();


        controller.deployProbe();
        controller.stabiliseOrbit();

        System.out.println("Mission control: Probe deployment successful!");
    }
}
/* I used the Facade design pattern because it simplifies interation with several complex subsystems by offering a single unified interface */