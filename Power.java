class Power {
    public void activatePrimaryPower() {
        System.out.println("DEPLOYMENT SEQUENCE 1");
        System.out.println("Power: Primary power activated.");
    }

    public void runDiagnostics() {
        System.out.println("DEPLOYMENT SEQUENCE 2");
        System.out.println("Power: System diagnostics complete. Status: GREEN.");
    }

    public void enterLowPowerMode() {
        System.out.println("Power: Entering low-power standby mode.");
    }

    public void deactivatePrimaryPower() {
        System.out.println("Power: Primary power deactivated.");
    }
}