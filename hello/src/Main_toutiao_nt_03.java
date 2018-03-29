import java.util.*;
/**
 * Created by seu on 2017/9/6.
 */
public class Main_toutiao_nt_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = scanner.next();
            }
            System.out.println(getNumWeightK(n, k, strs));
        }
    }
    public static int getNumWeightK(int n, int K, String[] strs) {
        int count = 0;
        ArrayList<String> strings = new ArrayList<String>();
        //����ȫ���У��洢��strings�У�k��ʾ��ǰҪ��ӵ��ǵڼ���Ԫ�أ�0-n-1��
        permutation(strings, strs, 0);
        for (int i = 0; i < strings.size(); i++) {
            int weightTemp = getWeight(strings.get(i));
            if (weightTemp == K) {
                count++;
            }
        }
        return count;
    }

    //��һ���ַ���Ȩ��
    public static int getWeight(String s) {
        int weight = 0;
        int len = s.length();
        for(int i=0;i<s.length();i++){
            if(s.substring(0, i).equals(s.substring(len - i, len)) && s.substring(0, len-i).equals(s.substring(i, len))){
                //ͨ����ʼ����ƶ���i�������൱�ڽ��������λ��ֳ������Σ�
                // ԭ����len-i,len���ƶ�����(0, i)
                // ԭ����0��len-i���ƶ����ˣ�i,len��
                weight++;
            }
        }
        return weight;
    }

    // ȫ����
    public static void permutation(ArrayList<String> strings, String[] strs, int k) {
        if (k == strs.length) {
            String temp = ""; //һ��ʼ��StringBuffer�������棬�ͳ�ʱ�ˡ����Ծ�����Ҫ��StringBuffer
            for (int i = 0; i < strs.length; i++) {
                temp += strs[i];
            }
            strings.add(temp);
        } else{
            for (int i = k; i < strs.length; i++) {
                swap(strs, i, k);
                permutation(strings, strs, k + 1);
                swap(strs, i, k);
            }
        }
    }

    public static void swap(String[] strs, int i, int j) {
        if (i != j) {
            String t = strs[i];
            strs[i] = strs[j];
            strs[j] = t;
        }
    }
}