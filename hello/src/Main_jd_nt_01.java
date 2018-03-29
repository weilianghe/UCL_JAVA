import java.util.*;
/**
 * ˼·˵�� 1.�������Ϊ5���֣�x1,m,x2,n,x3��
 * 2.mΪ��һ����Ҫ�жϵ��nΪ�ڶ����ж��x1Ϊmǰ������ļ���,x2Ϊm��n֮��������ļ���,x3Ϊn��*������ļ��ϣ�����x1,x2��x3���п����ǿռ��������д���
 * 3.Ҫ���ܿ����Է��������Ϊ���֣�m>=max(x2)&&n>=max(x2)||m>max(x1,x3)&&n>max(x1,x3); ���������������������Ӽ������ؿ��ǣ�
 *
 * @author Levi_Lin
 *
 */
public class Main_jd_nt_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int result = 0;// ����������׼����������
            int n = sc.nextInt();
            int[] hill = new int[n];
            for (int i = 0; i < n; i++)
                hill[i] = sc.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int x1 = getMax(hill, 0, i);
                    int x2 = getMax(hill, i + 1, j);
                    int x3 = getMax(hill, j + 1, n);
                    if ((hill[i] >= x2 && hill[j] >= x2) || (hill[i] >= getMax(x1, x3) && hill[j] >= getMax(x1, x3)))
                        result++;
                }
            }
            System.out.println(result);
        }
    }

    /**
     * ���������ֵ��������ĺ������أ�
     *
     * @return ��������ֵ
     */
    public static int getMax(int a, int b) {
        return a >= b ? a : b;
    }

    /**
     * ˵����left>=rightʱ˵���ü���Ϊ�ռ�������-1��˵��֮��û�����ϣ��������⴩Խ�ü��Ϲۿ�
     *
     * @param arr ��Ҫ�ҳ��ϴ�ֵ������
     * @param left����Ǳ���߽磨������
     * @param right����Ǳ��ұ߽磨��������
     * @return���ؽϴ�ֵ��
     */
    public static int getMax(int[] arr, int left, int right) {
        if (left >= right)
            return -1;
        int max = arr[left];
        for (int i = left + 1; i < right; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
}