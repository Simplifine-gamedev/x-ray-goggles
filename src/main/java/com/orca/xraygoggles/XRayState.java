package com.orca.xraygoggles;

public class XRayState {
    private static boolean xrayEnabled = false;
    private static boolean wasSneaking = false;

    public static boolean isXrayEnabled() {
        return xrayEnabled;
    }

    public static void setXrayEnabled(boolean enabled) {
        xrayEnabled = enabled;
    }

    public static void toggle() {
        xrayEnabled = !xrayEnabled;
    }

    public static boolean wasSneaking() {
        return wasSneaking;
    }

    public static void setWasSneaking(boolean sneaking) {
        wasSneaking = sneaking;
    }
}
