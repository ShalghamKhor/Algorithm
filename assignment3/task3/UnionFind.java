package assignment3.task3;

public class UnionFind {
    int[] com_id;
    int[] rank;

    public UnionFind(int n) {
        com_id = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            com_id[i] = i;
            rank[i] = 0;

        }
    }

    public int find(int n){
        if (n != com_id[n]){
            com_id[n] = find(com_id[n]);
        }
        return com_id[n];
    }
    public boolean connected(int a, int b) {
        return com_id[a] == com_id[b];
    }

    public void union(int a, int b) {
        int a_id = find(a);
        int b_id = find(b);
        if (a_id != b_id){
            if (rank[a_id] < rank[b_id]){
                com_id[a_id] = b_id;
            }
            else if (rank[a_id] > rank[b_id]){
                com_id[b_id] = a_id;
            }else {
                com_id[b_id] = a_id;
                rank[a_id]++;
            }
        }
    }
}
