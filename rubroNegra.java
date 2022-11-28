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
    private int count; // número de elementos
    private Node root; // referencia para a raiz
    private Node nil; // nodo sentinela

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

    //////////////// Métodos de rotações usados para o balanceamento

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

    //////////////// Método de balaceamento /////////////////////

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
            } else {
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
        root.cor = 'p';
    }

    //////////////// Método de inserção O(logn) /////////////////////

    public void add(Integer element) {
        // primeiro cria o nodo a ser inserido
        Node n = new Node(element, 'v');

        // procura pelo pai
        Node aux = nil;
        Node aux1 = root;
        while (aux1 != nil) {
            aux = aux1;
            if (n.element < aux1.element)
                aux1 = aux1.left;
            else
                aux1 = aux1.right;
        }
        n.father = aux; // liga o nodo ao pai

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

    //////////////// Outros métodos /////////////////////

    public boolean contains(Integer element) {
        Node n = searchNodeRef(element, root);
        return (n != null);
    }

    private Node searchNodeRef(Integer element, Node target) {
        if (element == null || target == null)
            return null;
        if (element == target.element)
            return target;
        if (element < target.element)
            return searchNodeRef(element, target.left);
        else
            return searchNodeRef(element, target.right);
    }

    public int height() {
        if (root == nil)
            return 0;
        else if (root.left == nil && root.right == nil)
            return 0;
        else
            return height(root);
    }

    private int height(Node n) {
        if (n.left == nil && n.right == nil) {
            return 0;
        } else {
            int h = 0;
            if (n.left != nil)
                h = Math.max(h, height(n.left));
            if (n.right != nil)
                h = Math.max(h, height(n.right));
            return 1 + h;
        }
    }

    public Integer getParent(Integer element) {
        Node n = searchNodeRef(element, root);
        if (n == null) {
            return 0;
        }
        return n.element;
    }

    //////////////// Positions /////////////////////

    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != nil) {
            res.add(n.element);
            positionsPreAux(n.left, res);
            positionsPreAux(n.right, res);
        }
    }

    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPosAux(root, res);
        return res;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger res) {
        if (n != nil) {
            positionsPosAux(n.left, res);
            positionsPosAux(n.right, res);
            res.add(n.element);
        }
    }

    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
        if (n != nil) {
            positionsCentralAux(n.left, res);
            res.add(n.element);
            positionsCentralAux(n.right, res);
        }
    }

    public LinkedListOfInteger positionsWidth() {
        Queue<Node> fila = new Queue<>();
        Node atual = null;
        LinkedListOfInteger res = new LinkedListOfInteger();
        if (root != nil) {
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                atual = fila.dequeue();
                if (atual.left != nil) {
                    fila.enqueue(atual.left);
                }
                if (atual.right != nil) {
                    fila.enqueue(atual.right);
                }
                res.add(atual.element);
            }
        }
        return res;
    }

    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline 
    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }
    

}