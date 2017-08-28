package leetcode.DFS;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by thd on 2017/8/28
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 总共有n门课程，从0到n - 1。
 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 一些课程可能有先决条件，例如，要采取0课程，你必须先学习1，这表示为一对：[0,1]
 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 鉴于课程总数和先决条件列表，您可以完成所有课程吗？
 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 共有2门课程。 要进行课程1，你应该完成课程0，所以这是可能的。
 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 共有2门课程。 你要完成课程1则应该完成课程0，并且0课程你也应该完成课程1.所以这是不可能的。
 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.
 注意：
 输入先决条件是由边缘列表而不是邻接矩阵表示的图形。 阅读更多关于图表的表示方式。
 您可以假设输入先决条件中没有重复的边



 拓扑排序  ！！！！！！！
 */
public class n207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {//9ms ，添加注释部分即可输出排序数组
    //public int[] canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        int[] degree = new int[numCourses];
        //int[] order = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                //order[count] = i;
                count++;
            }
        }

        while (queue.size() != 0) {
            int course = queue.poll();
            for (int i = 0; i < graph.get(course).size(); i++) {
                int pointer = graph.get(course).get(i);
                degree[pointer]--;
                if (degree[pointer] == 0){
                    queue.add(pointer);
                    //order[count] = pointer;
                    count++;
                }
            }
        }
            return count == numCourses;
            //return count == numCourses ? order : new int[0];
    }


    public boolean canFinishDfs(int numCourses, int[][] prerequisites) {//6ms
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true; //??

        // create the array lists to represent the courses
        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
        for(int i=0; i<numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }

        // create the dependency graph
        for(int i=0; i<prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];

        // dfs visit each course
        for(int i=0; i<numCourses; i++) {
            if (!dfs(i,courses, visited)) return false;
        }

        return true;
    }

    private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {

        visited[course] = 1; // mark it being visited

        List<Integer> eligibleCourses = courses.get(course); // get its children

        // dfs its children
        for(int i=0; i<eligibleCourses.size(); i++) {
            int eligibleCourse = eligibleCourses.get(i).intValue();

            if(visited[eligibleCourse] == 1) return false; // has been visited while visiting its children - cycle !!!!
            if(visited[eligibleCourse]  == 0) { // not visited
                if (!dfs(eligibleCourse,courses, visited)) return false;
            }

        }

        visited[course] = 2; // mark it done visiting
        return true;

    }


    public static void main(String[] args) {
        int n = 6;
        int[][] num = {{1,0},{2,1},{3,2},{4,1},{5,0}};
        n207CourseSchedule nn = new n207CourseSchedule();
        System.out.println(nn.canFinish(n, num));
    }
}
