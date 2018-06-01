package business.algorithm;

public class Prim {
    
    private final int infinite = Integer.MAX_VALUE - 1;
    private int[] priority;
    private int[] parent;
    
    //Prim's algorithm with an adjacency matrix as input
    public void MatrixPriorityFirst(int input[][])
    {

        int n = input.length+1;
        parent = new int[n];
        priority = new int[n];

        Init();

        int min=0;
        int k;
        int prio;
        do {
            k=min;
            priority[k]=-priority[k];
            min=n-1;
            if(priority[k]==infinite)
            {
                priority[k]=0;
            }
            for(int t = 0;t<n-1;t++)
            {
                prio=-input[k][t];

                if(priority[t]<0)
                {
                    if(input[k][t]>0 && (priority[t]<prio))
                    {
                        priority[t]=prio;
                        //Graph starts with 0
                        parent[t]=k;
                    }
                    if(priority[t]>priority[min])
                    {
                        min=t;
                    }
                }
            }
        }while(min!=input.length);

        System.out.println("Edges       Weights");

        for (int i=1;i<n-1;i++)
        {
            System.out.println(i+" - "+parent[i]+"           " + priority[i]);
        }
    }


    //Initialize both arrays
    private void Init() {
        for (int i=0;i<priority.length;i++)
        {
            priority[i]=-infinite;
            parent[i]=Integer.MAX_VALUE;
        }
        priority[priority.length-1]=-(infinite+1);
    }

}
