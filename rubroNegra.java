public class rubroNegra {
    private static final class Node {
        public Node father;
        public Node left;
        public Node right;
        public Integer element;
        public char cor;
 
        public Node(Integer element, char cor) {
            father = null;
            left = null;
            right = null;
            this.element = element;
            this.cor = cor;
        }
    }

    // Atributos da árvore
    private int count;  // número de elementos
    private Node root;  // referencia para a raiz
    private Node nil;  // nodo sentinela

    public rubroNegra() {
        count = 0;
        nil = new Node(0, 'p');
        root = nil;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
    return root.element;
    }

    private void rightRotate(Node n) {
        Node aux = n.left;
        n.left = aux.right;
        if (aux.right != nil) 
            aux.right.father = n;

        aux.father = n.father; // liga o pai de x a y

        if (n.father == nil)
            root = aux;
        
        else if (n == n.father.right)
            n.father.right = aux;
        else
            n.father.left = aux;
        aux.right = n;
        n.father = aux;
    }

    private void leftRotate(Node n) {
        Node aux = n.right;
        n.right = aux.left;
        if (aux.left != nil) 
            aux.left.father = n;

        aux.father = n.father; // liga o pai de x a y

        if (n.father == nil)
            root = aux;
        
        else if (n == n.father.left)
            n.father.left = aux;
        else
            n.father.right = aux;
        aux.left = n;
        n.father = aux;
    }

    private void fixUp(Node n) {
        while (n.cor == 'v' && n.father != nil && n.father.cor == 'v') {
            if (n.father == n.father.father.left) {
                Node uncle = n.father.father.right;
                if (uncle.cor == 'v') {
                    n.father.cor = 'p';
                    uncle.cor = 'p';
                    n.father.father.cor = 'v';
                    n = n.father.father;
                } else {
                    if (n == n.father.right) {
                        leftRotate(n.father);
                        n = n.left;
                    }
                    rightRotate(n.father.father);
                    n.father.father.cor = 'v';
                    n.father.cor = 'p';
                    n = n.father;
                }
            }
            else {
                Node uncle = n.father.father.left;
                if (uncle.cor == 'v') {
                    n.father.cor = 'p';
                    uncle.cor = 'p';
                    n.father.father.cor = 'v';
                    n = n.father.father;
                } else {
                    if (n == n.father.left) {
                        rightRotate(n.father);
                        n = n.left;
                    }
                    leftRotate(n.father.father);
                    n.father.father.cor = 'v';
                    n.father.cor = 'p';
                    n = n.father;
                }
            }
        }
    }

    public void add(Integer element) {
        // primeiro cria o nodo a ser inserido
        Node n = new Node(element, 'v');
        
        // procura pelo pai
        Node aux = nil;
        Node aux1 = root;
        while(aux1 != nil) {
            aux =  aux1;
            if (n.element < aux1.element)
                aux1 = aux1.left;
            else
                aux1 = aux1.right;
        }
        n.father = aux;  //liga o nodo ao pai

        // se não encontrou o pai
        if (aux == nil)
            root = n;
        else if (n.element < aux1.element)
            aux.left = n;
        else 
            aux.right = n;
        n.left = nil;
        n.right = nil;
        fixUp(n);
    }

    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != nil) {
            res.add(n.element); //Visita o nodo
            positionsPreAux(n.left, res); //Visita a sub�rvore da esquerda
            positionsPreAux(n.right, res); //Visita a sub�rvore da direita
        }

    }
}