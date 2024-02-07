import java.util.*;
class Node {
    public int x;
    public int y;
    public int value;
    public int leftBound;
    public int rightBound;
    public Node left = null;
    public Node right = null;
    
    Node(int x, int y, int value, int leftBound, int rightBound) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }
    
    public void preorder(List<Integer> traversal) {
        traversal.add(this.value);
        if (this.left != null) this.left.preorder(traversal);
        if (this.right != null) this.right.preorder(traversal);
    }
    
    public void postorder(List<Integer> traversal) {
        if (this.left != null) this.left.postorder(traversal);
        if (this.right != null) this.right.postorder(traversal);
        traversal.add(this.value);
    }
    
    public void buildChildren(int[][] nodeinfo) {
        this.left = this.buildLeft(nodeinfo);
        this.right = this.buildRight(nodeinfo);
        
        if (this.left != null) {
            this.left.buildChildren(nodeinfo);
        }
        
        if (this.right != null) {
            this.right.buildChildren(nodeinfo);
        }
    }
    
    public Node buildLeft(int[][] nodeinfo) {
        int topY = this.right == null?-1:this.right.y;
        List<Integer> pointList = new ArrayList<Integer>();
        List<Integer> pointNumList = new ArrayList<Integer>();
        
        for (int i = 0; i < nodeinfo.length; i++) {
            int nowX = nodeinfo[i][0];
            int nowY = nodeinfo[i][1];
            if (this.y > nowY && nowX < this.rightBound && nowX > this.leftBound && nowX < this.x) {
                if (nowY > topY) {
                    topY = nowY;
                    pointList.clear();
                    pointNumList.clear();
                    pointList.add(nowX);
                    pointNumList.add(i + 1);
                } else if (nowY == topY) {
                    pointList.add(nowX);
                    pointNumList.add(i + 1);
                }
            }
        }
        
        int finalX = -1;
        int finalValue = -1;
        for (int i = 0; i < pointList.size(); i++) {
            if (finalX < pointList.get(i)) {
                finalX = pointList.get(i);
                finalValue = pointNumList.get(i);
            }
        }
        
        if (finalX == -1) return null;
        else {
            nodeinfo[finalValue - 1][1] = 100002;
            return new Node(finalX, topY, finalValue, this.leftBound, this.x);
        }
    }   
    
    public Node buildRight(int[][] nodeinfo) {
        int topY = this.left == null?-1:this.left.y;
        List<Integer> pointList = new ArrayList<Integer>();
        List<Integer> pointNumList = new ArrayList<Integer>();
        
        for (int i = 0; i < nodeinfo.length; i++) {
            int nowX = nodeinfo[i][0];
            int nowY = nodeinfo[i][1];
            if (this.y > nowY && nowX < this.rightBound && nowX > this.leftBound && nowX > this.x) {
                if (nowY > topY) {
                    topY = nowY;
                    pointList.clear();
                    pointNumList.clear();
                    pointList.add(nowX);
                    pointNumList.add(i + 1);
                } else if (nowY == topY) {
                    pointList.add(nowX);
                    pointNumList.add(i + 1);
                }
            }
        }
        
        int finalX = Integer.MAX_VALUE;
        int finalValue = -1;
        for (int i = 0; i < pointList.size(); i++) {
            if (finalX > pointList.get(i)) {
                finalX = pointList.get(i);
                finalValue = pointNumList.get(i);
            }
        }
        
        if (finalX == Integer.MAX_VALUE) return null;
        else {
            nodeinfo[finalValue - 1][1] = 100002;
            return new Node(finalX, topY, finalValue, this.x, this.rightBound);
        }
    }
    
}
class Solution {
    public Node n;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        n = new Node(100001, 100001, 0, -1, 100001);
        n.buildChildren(nodeinfo);
        
        List<Integer> preorder = new ArrayList<Integer>();
        List<Integer> postorder = new ArrayList<Integer>();
        n.left.preorder(preorder);
        n.left.postorder(postorder);
        
        answer = new int[2][preorder.size()];
        for (int i = 0; i < preorder.size(); i++) {
            answer[0][i] = preorder.get(i);
            answer[1][i] = postorder.get(i);
        }
        
        return answer;
    }
    
}