package study.unit2.ex05;

public enum Subject {
    CHEMISTRY,
    MATH,
    PHYSICS;

    public String toString() {
        switch (this) {
            case CHEMISTRY:
                return "chemistry";
            case MATH:
                return "math";
            case PHYSICS:
                return "physics";
            default:
                return "";
        }
    }
}
