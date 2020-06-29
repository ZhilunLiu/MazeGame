import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int x;
    int y;
    int count;
    public Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Scratch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        int startIdx1 = -1, startIdx2 = -1;
        int endIdx1 =-1, endIdx2 =-1;
        char list[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            for (int j = 0; j < n; j++) {
                list[i][j] = line.charAt(j);
                if (list[i][j] == 'S') {
                    startIdx1 = i;
                    startIdx2 = j;
                }
                if(list[i][j]=='E'){
                    endIdx1 = i;
                    endIdx2 = j;
                }
            }
        }
        if(startIdx1 == -1 || startIdx2 ==-1){
            System.out.println("-1");
        }
        if(endIdx1 == -1 || endIdx2 ==-1){
            System.out.println("-1");
        }
        input.close();

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(startIdx1,startIdx2,0));
        int x =-1; int y = -1;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.x== endIdx1 &&node.y==endIdx2){
                System.out.print(node.count);
                return;
            }
            //top
            x = node.x==0? n-1:node.x-1;
            y = node.y;
            if(list[x][y]!='#'){
                queue.offer(new Node(x,y,node.count+1));
                list[x][y] = '#';
            }
            //bottom
            x = node.x==(n-1)?0:node.x+1;
            y= node.y;
            if(list[x][y]!='#'){
                queue.offer(new Node(x,y,node.count+1));
                list[x][y] = '#';
            }

            //left
            y = node.y==0?n-1:node.y-1;
            x = node.x;
            if(list[x][y]!='#'){
                queue.offer(new Node(x,y,node.count+1));
                list[x][y] = '#';
            }

            //right
            y = node.y ==(n-1)?0:node.y+1;
            x = node.x;
            if(list[x][y]!='#'){
                queue.offer(new Node(x,y,node.count+1));
                list[x][y] = '#';
            }
        }
        System.out.print(-1);
    }

}