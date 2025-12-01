import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {

    @Override
    public int compare(Visitor v1, Visitor v2) {
        if (v1 == null && v2 == null) return 0;
        if (v1 == null) return 1;   // null 放后面
        if (v2 == null) return -1;

        //The first step is to sort by membershipType: put VIP in front of Standard
        //Custom weight: VIP=0, Standard=1, others=2
        int t1 = getTypeOrder(v1.getMembershipType());
        int t2 = getTypeOrder(v2.getMembershipType());
        if (t1 != t2) {
            return Integer.compare(t1, t2);
            //The small number comes first and the large number comes last, forming a sort
        }

        //If the value of membershipType is the same, sort by height
        return Double.compare(v1.getHeight(), v2.getHeight());
    }

    private int getTypeOrder(String type) {
        if (type == null) return 2;
        String t = type.trim().toLowerCase();
        if (t.equals("vip")) return 0;
        if (t.equals("standard")) return 1;
        return 2;
    }
}
