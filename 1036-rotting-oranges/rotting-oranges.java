class Solution {
    static class Pair{
        int i, j, t;
        Pair(int i, int j, int t){
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                   q.add(new Pair(i,j,0));
                   vis[i][j] = true;
                }
            }
        }
        int ans = 0;

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int i = curr.i;
            int j = curr.j;
            int t = curr.t;

            ans = Math.max(ans,t);

            if(i-1 >= 0 && !vis[i-1][j] && grid[i-1][j] == 1){
                q.add(new Pair(i-1,j,t+1));
                vis[i-1][j] = true;
            }

            if(i+1 < n && !vis[i+1][j] && grid[i+1][j] == 1){
                q.add(new Pair(i+1,j,t+1));
                vis[i+1][j] = true;
            }

            if(j-1 >= 0 && !vis[i][j-1] && grid[i][j-1] == 1){
                q.add(new Pair(i,j-1,t+1));
                vis[i][j-1] = true;
            }

            if(j+1 < m  && !vis[i][j+1] && grid[i][j+1] == 1){
                q.add(new Pair(i,j+1,t+1));
                vis[i][j+1] = true;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    return -1;
                }
            }
        }
        return ans;
    }
}