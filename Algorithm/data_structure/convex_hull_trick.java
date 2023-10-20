package Algorithm.data_structure;

import java.util.ArrayList;

public class convex_hull_trick {
    public class Line {
        long a, b;

        public Line(long a, long b) {
            this.a = a;
            this.b = b;
        }

        public long y(long x) {
            return a * x + b;
        }
    }

    private ArrayList<Line> stk;
    private int qpt;

    public convex_hull_trick() {
        this.stk = new ArrayList<>();
        this.qpt = 0;
    }

    public void pushLine(Line l) {
        while (stk.size() > 1) {
            Line l0 = stk.get(stk.size() - 1);
            Line l1 = stk.get(stk.size() - 2);
            if ((l0.b - l.b) * (l0.a - l1.a) > (l1.b - l0.b) * (l.a - l0.a)) break;
            stk.remove(stk.size() - 1);
        }
        stk.add(l);
    }

    public long query(long x) {
        while (qpt + 1 < stk.size()) {
            Line l0 = stk.get(qpt);
            Line l1 = stk.get(qpt + 1);
            if (l1.a - l0.a > 0 && (l0.b - l1.b) > x * (l1.a - l0.a)) break;
            if (l1.a - l0.a < 0 && (l0.b - l1.b) < x * (l1.a - l0.a)) break;
            qpt++;
        }
        return stk.get(qpt).y(x);
    }
}
