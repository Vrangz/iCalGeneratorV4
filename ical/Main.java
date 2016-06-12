package ical;

class Main {

    public static void main(String args[]) {
        generateICal.run();
        loadICal.run();
    }

    static Calendar calendar = new Calendar();
    static Operation generateICal = GenerateICal.instance;
    static Operation loadICal = LoadICal.instance;
}
