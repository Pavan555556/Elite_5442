class Solution {
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
            
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && search(grid, grid[i][j], i, j, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][] grid, char target, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != target) {
            return false;
        }
        
        if (visited[i][j]) {
            return true;
        }
        
        visited[i][j] = true;
        grid[i][j] = '#';
        
        boolean found =  search(grid, target, i + 1, j, visited)
                    ||  search(grid, target, i - 1, j, visited)
                    ||  search(grid, target, i, j - 1, visited)
                    ||  search(grid, target, i, j + 1, visited);

        grid[i][j] = target;
        
        return found;
    }
}