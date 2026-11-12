class Solution {

  public int orangesRotting(int[][] grid) {
    int n=grid.length;
    int m=grid[0].length;
    int fresh=0;
    int count=0;
    Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                
                }
            }
        }
        int[][] direction={
            {-1,0},{1,0},{0,-1},{0,1}
        };
        while(!q.isEmpty() && fresh > 0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] current=q.poll();
                for(int[] d:direction){
                    int row=current[0]+d[0];
                    int col=current[1]+d[1];
                    if(row >=0 && row < n && col >= 0 && col < m && grid[row][col] == 1){
                        grid[row][col] =2;
                        fresh--;

                        q.offer(new int[]{row,col});

                    }

                }

            }
            count++;
        }
        return fresh == 0?count:-1;
    
    }
}
