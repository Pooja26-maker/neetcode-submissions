class Solution {
    public void dfs(int node,List<List<Integer>> adj,boolean[] visited){
        visited[node]=true;
        for(int neigh:adj.get(node)){
            if(!visited[neigh]){
                dfs(neigh,adj,visited);
            }

        }
    }
    public int countComponents(int n, int[][] edges) {
        int connected=0;
        boolean[] visited=new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                connected++;
                dfs(i,adj,visited);
            }
        }
        return connected;

    }
}
