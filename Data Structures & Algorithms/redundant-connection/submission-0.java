class Solution {
    public int find(int x, int[] parent){
        if(parent[x]!=x){
            parent[x]=find(parent[x],parent);
        }
        return parent[x];
    }


    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int rootu=find(u,parent);
            int rootv=find(v,parent);
            if(rootu == rootv){
                return edge;
            }
            parent[rootu]=rootv;


        }
        return new int[0];
       
        
        
    }
    
}
