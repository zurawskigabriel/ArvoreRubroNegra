public class app {
    public static void main(String[] args) {
        rubroNegra r = new rubroNegra();
        r.add(14);
        r.add(2);
        r.add(77);
        r.add(54);
        r.add(32);
        r.add(13);
        r.add(45);
        r.add(24);
        r.add(9);
        r.add(8);

        System.out.println(r.positionsPre().toString());
        System.out.println(r.positionsPos().toString());
        System.out.println(r.positionsCentral().toString());
        System.out.println(r.positionsWidth().toString());
        System.out.println(r.contains(100));
        System.out.println(r.contains(24));
        System.out.println(r.height());
        System.out.println(r.getParent(13));

    }
}
