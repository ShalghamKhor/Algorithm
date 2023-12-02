import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        timer t = new timer();
        unionFind unionfind = new unionFind(10);
        System.out.println(Arrays.toString(unionfind.com_id));
        /*
         * System.out.println(unionfind.connected(0, 1));
         * 
         * System.out.println(unionfind.com_id);
         * System.out.println(unionfind.connected(0, 1));
         * sfs
         */
        System.out.println("List length 10");
        t.starttime();
        unionfind.union(0, 1);
        t.endtime();
        t.duration();
        System.out.println("List length 100");
        unionfind = new unionFind(100);
        t.starttime();
        unionfind.union(0, 1);
        t.endtime();
        t.duration();
        System.out.println("List length 1000");
        unionfind = new unionFind(1000);
        t.starttime();
        unionfind.union(0, 1);
        t.endtime();
        t.duration();
        System.out.println("List length 10000");
        unionfind = new unionFind(1000);
        t.starttime();
        unionfind.union(0, 1);
        t.endtime();
        t.duration();
        System.out.println("List length 100000");
        unionfind = new unionFind(1000);
        t.starttime();
        unionfind.union(0, 1);
        t.endtime();
        t.duration();
        System.out.println("List length 1000000");
        unionfind = new unionFind(1000);
        t.starttime();
        unionfind.union(0, 1);
        t.endtime();
        t.duration();
        // QuickUnion q = new QuickUnion(1000000);

        // System.out.println(q.comp_id);
        // System.out.println(q.connected(1,3));
        // t.starttime();
        // q.union(0,1);
        // t.endtime();
        // t.duration();
        // q.union(1,2);
        // System.out.println(q.comp_id);
        // q.union(3,4);
        // System.out.println(q.comp_id);
        // System.out.println(q.connected(1,2));

    }

}