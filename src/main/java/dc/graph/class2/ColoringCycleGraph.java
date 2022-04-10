package dc.graph.class2;

//Your task is to determine the minimum number of colors required to color the graph so that no two
// Adjacent vertices have the same color.
public class ColoringCycleGraph
{
    
    public static void main (String[] args)
    {
        System.out.println (coloringCycleGraph (2));
        System.out.println (coloringCycleGraph (3));
        System.out.println (coloringCycleGraph (9));
    }
    
    public static int coloringCycleGraph (int A)
    {
        if (A % 2 == 0) {
            return 2;
        }
        else {
            return 3;
        }
    }
}
