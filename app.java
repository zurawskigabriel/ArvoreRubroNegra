public class app {
    public static void main(String[] args) {
        rubroNegra r = new rubroNegra();
        rubroNegra r1 = new rubroNegra();

        /*
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

        System.out.println("R ////////////////////////////////////////////////////////");
        System.out.println(r.positionsPre().toString());
        System.out.println(r.positionsPos().toString());
        System.out.println(r.positionsCentral().toString());
        System.out.println(r.positionsWidth().toString());
        System.out.println(r.contains(100));
        System.out.println(r.contains(24));
        System.out.println(r.height());
        System.out.println(r.getParent(13));
        */

        /*
        System.out.println("R2 ////////////////////////////////////////////////////////");
        System.out.println(r1.positionsPre().toString());
        System.out.println("\npositions pos:");
        System.out.println(r1.positionsPos().toString());
        System.out.println("\npositions central:");
        System.out.println(r1.positionsCentral().toString());
        System.out.println("\npositions width:");
        System.out.println(r1.positionsWidth().toString());
        System.out.println("\ncontem o 100?:");
        System.out.println(r1.contains(100));
        System.out.println("\ncontem o 5?:");
        System.out.println(r1.contains(5));
        System.out.println("\naltura da árvore:");
        System.out.println(r1.height());
        System.out.println("\npai do elemento 8:");
        System.out.println(r1.getParent(8));*/

        //r1.add(1);
        //r1.add(2);
        //r1.add(3);
        //r1.add(4);
        //r1.add(5);
        //r1.add(6);
        //r1.add(7);
        //r1.add(8);
        //r1.add(9);

        r1.add(9);
        r1.add(8);
        r1.add(7);
        r1.add(6);
        //r1.add(5);
        //r1.add(4);
        //r1.add(3);
        //r1.add(2);
        //r1.add(1);
        System.out.println(r1.getRoot());
        r1.GeraDOT();

    }
}
