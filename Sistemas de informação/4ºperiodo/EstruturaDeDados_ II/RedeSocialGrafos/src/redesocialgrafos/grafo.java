package redesocialgrafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class grafo {
    
    private Map<String, LinkedList<Aresta>> meuGrafo;
    private ArrayList visitados;
   
    public grafo() {
        this.meuGrafo = new HashMap<>();
    }

    // Método para adicionar um vértice ao grafo
    public void adicionarVertice(String nome) {
        if (!meuGrafo.containsKey(nome)) {
            meuGrafo.put(nome, new LinkedList<>());
        }
    }
    
    public void adicionarAresta(String origem, String destino) {
        if (!meuGrafo.containsKey(origem) || !meuGrafo.containsKey(destino)) {
            throw new IllegalArgumentException("Os vértices de origem e destino devem existir no grafo.");
        }
        meuGrafo.get(origem).add(new Aresta(destino));
    }
    
    public boolean alcance(String origem, String destino) {
        ArrayList<String> visitados = new ArrayList<>();
        return existeCaminho(origem, destino, visitados);
    }
    
    private boolean existeCaminho(String verticeAtual, String destino, ArrayList<String> visitados) {
        if (verticeAtual.equals(destino)) {
            System.out.println("Caminho: " + visitados);
            return true;
        }

        visitados.add(verticeAtual);
        LinkedList<Aresta> adjacencias = meuGrafo.get(verticeAtual);

        if (adjacencias != null) {
            for (Aresta vizinho : adjacencias) {
                if (!visitados.contains(vizinho.vertice) && existeCaminho(vizinho.vertice, destino, visitados)) {
                    return true;
                }
            }
        }
        System.out.println("Caminho: " + visitados);
        return false;
    }
    
    
    public void confereConexoes(String usuario) {
        if (!meuGrafo.containsKey(usuario)) {
            System.out.println("Usuário não existente!");
            return;
        }

        System.out.println("Usuário Encontrado!\nOutras Conexões: ");
        LinkedList<Aresta> conexoes = meuGrafo.get(usuario);

        for (Aresta conexao : conexoes) {
            System.out.println("Conectado a: " + conexao.vertice);
        }
    }
    
    
    
    public void imprimirGrafo() {
        for (Map.Entry<String, LinkedList<Aresta>> entry : meuGrafo.entrySet()) {
            String vertice = entry.getKey();
            LinkedList<Aresta> vizinhos = entry.getValue();
            System.out.print(vertice + " -> ");
            for (Aresta vizinho : vizinhos) {
                System.out.print(vizinho.vertice + " -> ");
            }
            System.out.println();
        }
    }
    
    public void salvarGrafo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("grafoUsuarios.txt"))) {
            for (Map.Entry<String, LinkedList<Aresta>> entry : meuGrafo.entrySet()) {
                String vertice = entry.getKey();
                LinkedList<Aresta> vizinhos = entry.getValue();
                for (Aresta vizinho : vizinhos) {
                    writer.println(vertice + " " + vizinho.Aresta + " -> ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      
    // Método para carregar os dados do grafo de um arquivo texto
    public void carregarGrafo() {
        try (Scanner scanner = new Scanner(new File("listaUsuarios.txt"))) {
            while (scanner.hasNext()) {
                String origem = scanner.nextLine();
                String destino = scanner.nextLine();

                adicionarVertice(origem);
                adicionarVertice(destino);
                adicionarAresta(origem, destino);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
