public class QuickUnion {
    int[] comp_id;

    public QuickUnion(int n) {
        comp_id = new int[n];
        for (int i = 0; i < n; i++) {
            comp_id[i] = i;
        }

    }

    public int root(int a) {
        while (a != comp_id[a]) {
            a = comp_id[a];

        }
        return a;
    }

    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    public void union(int a, int b) {
        int root_a = root(a);
        int root_b = root(b);
        comp_id[root_a] = root_b;
    }
}
