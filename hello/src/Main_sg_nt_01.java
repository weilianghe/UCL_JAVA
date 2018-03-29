import java.util.*;
public class Main_sg_nt_01{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int N=sc.nextInt();//������
            //answer��key��ʾ�ش��ߵ�id��valueΪ�ɸûش��߻ش������������ߵ�id���ɵ�HashSet
            HashMap<Integer,HashSet<Integer>> answer=new HashMap<Integer,HashSet<Integer>>();
            Queue<Integer> cheatQueue=new LinkedList<Integer>();
            for(int i=0;i<N;i++){
                int from=sc.nextInt();//������id
                int n=sc.nextInt();//�ش�����Ŀ
                for(int j=0;j<n;j++){
                    int to=sc.nextInt();
                    //ע���Լ��ش��Լ������ⲻ�����ף���˲��ÿ���
                    if(to!=from){
                        if(!answer.containsKey(to)){
                            answer.put(to,new HashSet<Integer>());
                        }
                        answer.get(to).add(from);
                        if(answer.containsKey(from) && answer.get(from).contains(to)){
                            cheatQueue.offer(from);
                            cheatQueue.offer(to);
                        }
                    }
                }
            }
            //����TreeSet�޳��ظ���������id����ʹ���С��������
            //�ڴ˹����У����ɶ����>2�������߻ش�����ʵ�������Ҳ���������߶��п���
            TreeSet<Integer> cheatSet=new TreeSet<Integer>();
            HashSet<Integer> cheatAnswer=new HashSet<Integer>();
            while(!cheatQueue.isEmpty()){
                int cheat=cheatQueue.poll();
                if(!cheatSet.contains(cheat)){
                    cheatSet.add(cheat);
                    if(answer.containsKey(cheat)){
                        for(Integer from:answer.get(cheat)){
                            if(cheatAnswer.contains(from)){
                                cheatSet.add(from);
                            }else{
                                cheatAnswer.add(from);
                            }
                        }
                    }
                }
            }
            //��ӡ��������Ŀ
            System.out.println(cheatSet.size());
            if(!cheatSet.isEmpty()){
                //��ӡ������id
                Iterator<Integer> iter=cheatSet.iterator();
                System.out.print(iter.next());
                while(iter.hasNext()){
                    System.out.print(" "+iter.next());
                }
                System.out.println();
            }
        }
    }
}