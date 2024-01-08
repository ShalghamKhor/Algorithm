package assignment1;

public class unionFind {
    int[] com_id;

    public unionFind(int n) {
        com_id = new int[n];
        for (int i = 0; i < n; i++) {
            com_id[i] = i;

        }
    }

    public boolean connected(int a, int b) {
        return com_id[a] == com_id[b];
    }

    public void union(int a, int b) {
        int a_id = com_id[a];
        int b_id = com_id[b];
        for (int i = 0; i < com_id.length; i++) {
            if (com_id[i] == a_id) {
                com_id[i] = b_id;
            }

        }
    }

}
