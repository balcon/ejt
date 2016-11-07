package study.unit2.ex06;

import study.unit2.ex07.AboutSubmarine;

@AboutSubmarine(
        author = "Me",
        isTrue = true
)

public class NuclearSubmarine {
    private boolean isReady = false;
    NuclearEngine nuclearEngine = new NuclearEngine();

    private class NuclearEngine {
        boolean turnOn() {
            if (isReady == true) {
                System.out.println("Engine started.");
                return true;
            } else {
                System.out.println("Engine can't started. Crew isn't ready");
                return false;
            }
        }

        void turnOff() {
            System.out.println("Engine stopped.");
        }
    }

    public void setCrewReady(boolean isReady) {
        this.isReady = isReady;
    }

    public boolean isReady() {
        return isReady;
    }

    public void sailAway() {
        System.out.println();
        System.out.println("Startin engine...");
        if (nuclearEngine.turnOn()) System.out.println("Sailing away");
    }
}
