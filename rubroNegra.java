public class rubroNegra {
    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        public Integer element;
        public char cor;
 
        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
            cor = 'v';
        }
    }

    // Atributos da árvore
    private int count;  // número de elementos
    private Node root;  // referencia para a raiz
    private Node nil;  // nodo sentinela

    public rubroNegra() {
        count = 0;
        root = null;
        nil.element = null;
        nil.cor = 'p';
    }


}