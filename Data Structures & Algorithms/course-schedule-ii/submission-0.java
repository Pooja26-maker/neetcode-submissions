class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q= new LinkedList<>();
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());

        }
        for(int[] p :prerequisites){
            int course=p[0];
            int next=p[1];
            adj.get(next).add(course);
            indegree[course]++;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]== 0){
                q.offer(i);
            }
        }
        int[] result=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int current=q.poll();
            result[index++]=current;
            for(int nei:adj.get(current)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        if(index == numCourses){
            return result;
        }
        return new int[0];

        
    }
}
