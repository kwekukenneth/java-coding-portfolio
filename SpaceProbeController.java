class SpaceProbeController {
    // References to all subsystems
    private Power pow;
    private Communications comms;
    private Navigation nav;
    private Thrusters thrust;

    public SpaceProbeController() {
        this.pow = new Power();
        this.comms = new Communications();
        this.nav = new Navigation();
        this.thrust = new Thrusters();
    }

    //Simplified interface for deployment 
    public void deployProbe() {
        System.out.println("\n=== BEGIN PROBE DEPLOYMENT ===");

        // Deployment Sequence in a strict order of 8 steps
        pow.activatePrimaryPower();
        pow.runDiagnostics();
        comms.extendAntennas();
        nav.loadTrajectoryData();
        nav.checkStarTrackers();
        thrust.performPreBurnCheck();
        thrust.alignBurnVectors();
        thrust.engageMainEngine();

        System.out.println("=== DEPLOYMENT COMPLETE ===\n");
    }

    //Simplified interface for stabilisation
    public void stabiliseOrbit() {
        System.out.println("\n=== BEGIN ORBIT STABILISATION ===");

        // Stabilisation sequence in order of 4 steps
        comms.establishUplink();
        nav.activateGyroscope();
        thrust.shutDownThrusters();
        comms.switchToLowerBandwidth();

        System.out.println("=== ORBIT IS STABLE ===\n");
    }
}
