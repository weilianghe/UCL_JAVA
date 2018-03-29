import java.util.*;

/**
 * ���ӳ��
    �� n ���ַ�����ÿ���ַ��������� A-J �Ĵ�д�ַ����ɡ������㽫ÿ���ַ�ӳ��Ϊһ�� 0-9 �����֣���ͬ�ַ�ӳ��Ϊ��ͬ�����֡�����ÿ���ַ����Ϳ��Կ���һ��������Ψһ��Ҫ������Щ���������������������ǵ��ַ���������ǰ���㡣������������ӳ���ַ�����ʹ����Щ�ַ�����ʾ������֮�����

        ��������:
            ÿ���������������һ�����ݣ�ÿ�����ݵ�һ��Ϊһ�������� n �� �������� n �У�ÿ��һ�����Ȳ����� 12 �ҽ�������д��ĸ A-J ���ַ����� n ������ 50�������ٴ���һ���ַ������κ��ַ���������ĸ��

        �������:
            ���һ��������ʾ�����Ƕ��١�
        ʾ��1
            ����
                 2
                 ABC
                 BCA
            ���
                1875

 ����˼·��
     ���ַ����е�ÿ���ַ�һ��Ȩ�أ����磺�ַ��� ABC ���� A ��Ȩ��Ϊ 100 �� B ��Ȩ��Ϊ 10 �� C ��Ȩ��Ϊ 1 ����ʵ���ǰ�����������λ���趨Ȩ�صġ�
 �����Ļ�����������ַ�����ÿ���ַ��ͻ�õ����Ȩֵ��Ȼ���ÿ���ַ�����Ȩֵ�����������Ȩֵ��ÿ���ַ��Ӵ�С����
     ���磺  ABC �� BCA �����ַ�����
             ABC �� A=100 �� B=10 �� C=1
             BCA �� B=100 �� C=10 �� A=1
        �ۼӣ� A=100+1=101 �� B=10+100=110 �� C=1+10=11 ����Ȩֵ�Ӵ�С������ B �� 110 �� A �� 101 �� C �� 11 ��
        ������Ϊ�� 110 �� B ���� 101 �� A ���� 11 �� C ����ôӳ�� B Ϊ 9 �� A Ϊ 8 �� C Ϊ 7 ���������Ϊ 9*110+8*101+7*11=1875.

 * Created by seu on 2017/9/6.
 */
public class Main_toutiao_nt_01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = scanner.next();
            }
            System.out.println(maxSum(n, strs));
        }
    }
    public static long maxSum(int n, String[] strs) {
        long sum = 0; // ���ص�����
        HashMap<Character, Long> map = new HashMap<Character, Long>();
        ArrayList<Character> headList = new ArrayList<Character>();
        for (int i = 0; i < n; i++) {
            setWeight(strs[i], map, headList);
        }
        // ���ո����ַ���Ȩ�ؽ�������
        ArrayList<Map.Entry<Character, Long>> list = new ArrayList<Map.Entry<Character, Long>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Long>>() {
            @Override
            public int compare(Map.Entry<Character, Long> arg0, Map.Entry<Character, Long> arg1) {
                // TODO Auto-generated method stub
                return arg0.getValue() > arg1.getValue() ? -1 : 1; // �����ַ���Ȩ�ؽ��дӴ�С����
            }
        });
        int number = 9;// ��������
        // ��ȥͷԪ��Ϊ0����� �취����Ȩ����С���Ҳ���ͷԪ�صĵ�һ���ַ�������ӳ��ֵΪ0��λ��
        if (list.size() == 10) {
            for (int i = 9; i >= 0; i--) {
                if (!headList.contains(list.get(i).getKey())) {// ����Ȩ����С���Ҳ���ͷԪ�صĵ�һ���ַ�
                    list.remove(i); // ȥ�����൱�ڷ�����ӳ��ֵΪ0��λ��
                    break;
                }
            }
        }
        for (Map.Entry<Character, Long> entry : list) {
            sum += entry.getValue() * number;
            number--;
        }
        return sum;
    }

    // ����ÿ���ַ�����ÿ���ַ���Ȩ�أ����������ַ�
    public static void setWeight(String string, HashMap<Character, Long> map, ArrayList<Character> headList) {
        char[] cs = string.toCharArray();
        long init = 1;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (map.containsKey(cs[i])) {
                map.put(cs[i], map.get(cs[i]) + init);
            } else {
                map.put(cs[i], init);
            }
            init *= 10;
        }
        headList.add(cs[0]);
    }
}