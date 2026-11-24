class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p : prerequisites){
            int current=p[0];
            int next=p[1];
            adj.get(next).add(current);
            indegree[current]++;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int finishedCourse = 0;
        while(!q.isEmpty()){
            int course=q.poll();
            finishedCourse++;
            for(int nei:adj.get(course)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                    
                }
            }
        }
        return finishedCourse == numCourses;

        
      
        
    }
}
