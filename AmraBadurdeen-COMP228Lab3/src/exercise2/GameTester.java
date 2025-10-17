package exercise2;

public abstract class GameTester {

    protected String name;
    protected boolean isFullTime;

    public GameTester(String name, boolean isFullTime) {
        this.name = name;
        this.isFullTime = isFullTime;
    }

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Game Tester: %s%nStatus: %s",
                getName(), isFullTime ? "Full-time" : "Part-time");
    }
}
