import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/9/9 20:36
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class Problem_01 {
    static HashMap<Integer,ArrayList<Integer>> map = new HashMap <>();
    static int count = 1;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);;
        Scanner first = new Scanner(input.nextLine());
        Scanner second = new Scanner(input.nextLine());
        ArrayList<Integer> pid = new ArrayList <>();
        ArrayList<Integer> ppid = new ArrayList <>();
        while (first.hasNextInt()) {
            pid.add(first.nextInt());
        }
        while (second.hasNextInt()) {
            ppid.add(second.nextInt());
        }

        for (int i = 0; i < pid.size(); i++) {
            if (map.containsKey(ppid.get(i))) {
                map.get(ppid.get(i)).add(pid.get(i));
            } else {
                ArrayList<Integer> arrayList = new ArrayList <>();
                arrayList.add(pid.get(i));
                map.put(ppid.get(i),arrayList);
            }
        }
        int n = input.nextInt();
        ArrayList<Integer> res = process(n);
        while (res.size() > 0) {
            ArrayList<Integer> tem = new ArrayList <>();
            tem.addAll(res);
            for (int i = 0; i < tem.size(); i++) {
                ArrayList<Integer> t = process(res.get(i));
                if (t == null) {
                    res = new ArrayList <>();
                } else {
                    res.addAll(t);
                }
            }
        }
        System.out.println(count);
    }
    public static ArrayList<Integer> process(int n) {
        ArrayList<Integer> arrayList = map.get(n);
        ArrayList<Integer> res = new ArrayList <>();
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                count++;
                if (map.containsKey(arrayList.get(i))) {
                    for (int j = 0; j < map.get(arrayList.get(i)).size(); j++) {
                        count++;
                    }
                    res.addAll(map.get(arrayList.get(i)));
                }
            }
            return res;
        }
        return null;
    }
}
