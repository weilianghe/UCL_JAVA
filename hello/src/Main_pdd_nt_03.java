/**
 * Created by zhang_cs on 2017/9/3.
 */

import java.util.Scanner;

public class Main_pdd_nt_03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] h=new int[n];
            for(int i=0;i<n;i++){
                h[i]=sc.nextInt();
            }
            int m=sc.nextInt();
            int[] w=new int[m];
            for(int i=0;i<m;i++){
                w[i]=sc.nextInt();
            }
            System.out.println(getMax(h,w));
        }
    }

    private static int getMax(int[] h,int[] w) {
        //���ÿ�������h��w������С��������
        fastSort(h,0,h.length-1);
        fastSort(w,0,w.length-1);
        int j=0;
        int res=0;
        // iΪ�ǹ������±꣬�����ǰ�ǹ��ܹ����㵱ǰС������Ҫ���ǹ��±���ƣ�
        // ����������㵱ǰС������Ҫ����ô������������һ��С���ѵ���Ҫ��ҲҪ����
        // ��С�����±꼰����ֻ���ܹ�����ʱ����
        for(int i=0;i<w.length;i++){
            if(j<h.length && w[i]>=h[j]){
                j++;
                res++;
            }
        }
        return res;
    }

    private static void fastSort(int[] nums,int begin,int end) {
        if(begin>=end){
            return;
        }
        int index=partition(nums,begin,end);
        fastSort(nums,begin,index-1);
        fastSort(nums,index+1,end);
    }

    private static int partition(int[] nums, int begin, int end) {
        int key = nums[begin];
        while(begin<end){
            while(nums[end]>=key && begin<end){
                end--;
            }
            nums[begin]=nums[end];
            while(nums[begin]<=key && begin<end){
                begin++;
            }
            nums[end]=nums[begin];
        }
        nums[begin]=key;
        return begin;
    }
}
