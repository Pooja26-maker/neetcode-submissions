class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] current=q.poll();
            int r=current[0];
            int c=current[1];
            for(int[] d:dir){
                int newRow=r+d[0];
                int newCol=c+d[1];

                if(newRow < 0 || newRow >= m || newCol < 0 || newCol>=n){
                    continue;
                }
                if(grid[newRow][newCol] == 2147483647){
                    grid[newRow][newCol]=grid[r][c]+1;
                    q.offer(new int[]{newRow,newCol});

                }
            }

        }
        
    }
}
