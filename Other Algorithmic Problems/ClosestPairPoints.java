import java.util.*;
import java.io.*;
class Point{
    double x,y;
    Point(double x,double y){
        this.x = x;
        this.y = y;
    }
}
public class ClosestPairPoints {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[][] points = new double[N][2];
        for(int i=0;i<N;++i){
            String[] s = br.readLine().split("\\s");
            points[i][0] = Double.parseDouble(s[0]);
            points[i][1] = Double.parseDouble(s[1]);
        }
        System.out.println(closestPair(points));
    }

    private static double closestPair(double[][] points){
        Point[] ps = new Point[points.length];
        for(int i=0;i<ps.length;++i) ps[i] = new Point(points[i][0],points[i][1]);
        Arrays.sort(ps,new Comparator<Point>(){
            public int compare(Point p1,Point p2){
                return (int)(p1.x - p2.x);
            }
        });
        return Math.sqrt(closestPairHelper(ps,0,ps.length-1));
    }

    private static double closestPairHelper(Point[] ps,int low,int high){
        if(low >= high) return Double.MAX_VALUE;
        int middle = low + (high - low) / 2;
        double min_dist = Math.min(closestPairHelper(ps,low,middle),closestPairHelper(ps,middle + 1,high));
        List<Point> points_close_to_strip = new ArrayList<>();
        for(int i=low;i<=high;++i){
            double x = ps[i].x - ps[middle].x;
            double y = ps[i].y - ps[middle].y;
            if(x * x + y * y < min_dist){
                points_close_to_strip.add(ps[i]);
            }
        }

        return Math.min(min_dist,stripMinimum(points_close_to_strip)); 
    }

    private static double stripMinimum(List<Point> ps){
        int size = ps.size();
        double min_dist = Double.MAX_VALUE;
        for(int i=0;i<size;++i){
            Point p1 = ps.get(i);
            for(int j=i+1;j<size;++j){
                Point p2 = ps.get(j);
                double x  = p1.x - p2.x;
                double y  = p1.y - p2.y;
                min_dist = Math.min(min_dist,x * x + y * y);
            }
        }
        return min_dist;
    }
}
