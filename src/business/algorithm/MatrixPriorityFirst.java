package business.algorithm;

public class MatrixPriorityFirst {

    /**
     * value which is used for the initialization
     */
    private final int infinite = Integer.MAX_VALUE - 1;
    /**
     * Prim: distance from the vertex with the index to the parent vertex
     *
     * Dijkstra: distance from the root to the vertex with the index
     */
    private float[] priority;
    /**
     * parent of the vertex with the index
     */
    private int[] parent;
    /**
     * output adjacency matrix
     */
    private float[][] output;


    /**
     *do Prim's algorithm with the input and print the MST as an adjacency matrix
     * @param input: input graph as an adjacency matrix
     *
     */
    public void doPrim(int input[][])
    {

        System.out.println("Prim's algorithm");

        int n = input.length+1;
        parent = new int[n];
        priority = new float[n];
        output = new float[n-1][n-1];

        Init();


        int min=0;
        int k;
        float prio;
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
            output[i][parent[i]]=priority[i];
            output[parent[i]][i]=priority[i];
        }
        printMatrix(output);
    }

    /**
     *do Dijkstra's algorithm with the input and print the new graph as an adjacency matrix
     * @param input: input graph as an adjacency matrix
     *
     */
    public void doDijkstra(int input[][])
    {
        System.out.println("Dijkstra's algorithm");

        int n = input.length+1;
        parent = new int[n];
        priority = new float[n];
        output = new float[n-1][n-1];

        Init();


        int min=0;
        int k;
        float prio;
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
                prio=-(input[k][t] + priority[k]);

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

        for (int i=0;i<n-1;i++)
        {
            System.out.println("Der kürzeste Weg von der Wurzel zu " +i+" hat die Länge "+priority[i]);
            output[i][parent[i]]=priority[i]-priority[parent[i]];
            output[parent[i]][i]=priority[i]-priority[parent[i]];
        }
        printMatrix(output);
    }

    /**
     * Initialize both arrays and the output matrix
     */
    private void Init() {
        for (int i=0;i<priority.length;i++)
        {
            priority[i]=-infinite;
            parent[i]=0;
        }
        priority[priority.length-1]=-(infinite+1);

        for(int i=0;i<output.length;i++)
        {
            for(int j=0;j<output.length;j++) {
                output[i][j] = -infinite;
            }
        }
    }

    /**
     * print an matrix on the console
     * @param output: an adjacency matrix
     */
    private void printMatrix(float[][] output)
    {
        System.out.println("Print adjacency matrix");
        for(int i = 0;i<output.length;i++)
        {
            for(int j=0;j<output.length;j++)
            {
                if(output[i][j]==-infinite)
                {
                    System.out.print("inf ");
                }
                else {
                    System.out.print(output[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }

}
