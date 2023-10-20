package Algorithm.data_structure;

public class binary_indexed_tree {
    private static final int TSIZE = 100000;
    private int[] tree = new int[TSIZE + 1];

    // Returns the sum from index 1 to p, inclusive
    public int query(int p) {
        int ret = 0;
        while (p > 0) {
            ret += tree[p];
            p -= p & -p;
        }
        return ret;
    }

    // Adds val to element with index pos
    public void add(int p, int val) {
        while (p <= TSIZE) {
            tree[p] += val;
            p += p & -p;
        }
    }
}
