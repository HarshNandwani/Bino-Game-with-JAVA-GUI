package BingoGame;
class Bingo{
    private int a[][]=new int[5][5],bingooA;
    private int b[][]=new int[5][5],bingooB;
    private java.util.Random r=new java.util.Random();
    public Bingo(){
        bingooA=bingooB=0;
        fillMat(a);
        fillMat(b);
        System.out.println("Player A matrix: ");
        printMat(a);
        System.out.println("Player B matrix: ");
        printMat(b);
    }
    private int getRandom(){
        return r.nextInt(26);
    }
    private boolean isPresent(int mat[][],int ele){
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                if(mat[i][j]==ele)
                    return true;
        return false;
    }
    private void fillMat(int X[][]){
        int element,i,j;
        for(i=0;i<5;i++)
            for(j=0;j<5;j++){
                element=getRandom();
                while(isPresent(X,element))
                    element=getRandom();
                X[i][j]=element;
            }
                
    }
    private void printMat(int Z[][]){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
               // System.out.print(Z[i][j]);
                if(Z[i][j]<9)
                    System.out.print(" "+Z[i][j]+"    ");
                else
                    System.out.print(Z[i][j]+"    ");
            }
            System.out.println();
        }    
    }
    public void cancel(int player,int ele){
        if(player==1)
            remove(a,ele);
        else
            remove(b,ele);
    }
    public void remove(int mat[][],int ele){
        for(int i=0;i<5;i++)
            for(int j=0;j<5;j++)
                if(mat[i][j]==ele)
                    mat[i][j]=0;
    }
    
    public static void main(String args[]){
        Bingo a=new Bingo();
        int canc;
        java.util.Scanner in=new java.util.Scanner(System.in);
        for(int i=0;i<=625;i++){
            if(i==0|i%2==0){
                System.out.println("Player 1 choice: ");
                System.out.print("Enter number to cancel: ");
                canc=in.nextInt();
                a.cancel(1,canc);
            }
            else{
                System.out.println("Player 2 choice: ");
                System.out.print("Enter number to cancel: ");
                canc=in.nextInt();
                a.cancel(2,canc);
            }
        }
    }
}