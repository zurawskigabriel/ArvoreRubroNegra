public class App {
    public static void main(String[] args) {
        // instanciar a árvore
        RubroNegra r1 = new RubroNegra();
        System.out.println("Árvore instanciada\n");

        // adicionar elementos
        r1.add(1);
        r1.add(2);
        r1.add(3);
        r1.add(4);
        r1.add(5);
        r1.add(6);
        r1.add(7);
        r1.add(8);
        r1.add(9);
        System.out.println("Elementos adicionados\n");

        // Apresentar altura
        System.out.println("Altura da árvore: " + r1.height() + "\n");

        // geraDot
        System.out.println("geraDot:");
        r1.GeraDOT();
        System.out.println();

        // limpar árvore
        r1.clear();
        System.out.println("Árvore limpa\n");

        // adicionar novos elementos
        r1.add(9);
        r1.add(8);
        r1.add(7);
        r1.add(6);
        r1.add(5);
        r1.add(4);
        r1.add(3);
        r1.add(2);
        r1.add(1);
        System.out.println("Elementos adicionados\n");

        // Mostrar caminhamento central
        LinkedListOfInteger posCentral = r1.positionsCentral();
        System.out.println("Caminhamento Central: ");
        System.out.println(posCentral);

        // Clonar a Árvore
        System.out.println("r1 clonado em r2:\n");
        RubroNegra r2 = r1.clone();

        // Geradot do clone
        System.out.println("geraDot do clone:");
        r2.GeraDOT();

        r1.GeraDOT();

    }
}
