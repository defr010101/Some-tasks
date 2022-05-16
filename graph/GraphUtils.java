package graph;

public interface GraphUtils<T> {
    void addEdge(int a, int b); // добавление ребра между вершинами a и b
    //void deleteEdge(T a, T b);
    Iterable<Integer> getAdj(int vertex); // список всех соседей вершины
}
