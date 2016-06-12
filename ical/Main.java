package ical;

class Main {

    public static void main(String args[]) {
        generateICal.run();
        loadICal.run();
    }

    private static Calendar calendar = new Calendar();
    private static Operation generateICal = GenerateICal.instance;
    private static Operation loadICal = LoadICal.instance;
}
