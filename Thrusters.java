class Thrusters {
    public void performPreBurnCheck() {
        System.out.println("DEPLOYMENT SEQUENCE 6");
        System.out.println("Thrusters: Pre-burn system check initiated.");
    }

    public void alignBurnVectors() {
        System.out.println("DEPLOYMENT SEQUENCE 7");
        System.out.println("Thrusters: Burn vectors aligned for deployment.");
    }

    public void engageMainEngine() {
        System.out.println("DEPLOYMENT SEQUENCE 8");
        System.out.println("ThrusterControl: WARNING! Main engine engaged. Deployment Burn sequence started!");
    }

    public void shutDownThrusters() {
        System.out.println("STABILISATION SEQUENCE 3");
        System.out.println("Thrusters: Thrusters safely shut down and cooled.");
    }
}