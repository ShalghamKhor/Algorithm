package assignment3.task5;

import assignment3.task1.DirectedGraph;
import assignment3.task1.Graph;

import java.io.*;
import java.util.*;

public class CourseSort {
    Map<String, Integer> courseToIndex = new HashMap<>();
    Map<Integer, String> indexToCourse = new HashMap<>();
    int index = 0;


    public int getCourseIndex(String course){
        if (!courseToIndex.containsKey(course)){
            courseToIndex.put(course, index);
            indexToCourse.put(index, course);
            index++;
        }
        return courseToIndex.get(course);
    }

    public List<String> getCourse(List<String> data){
        Sort sort = new Sort();
        Graph graph = new DirectedGraph();

        for (String pairs :data){
            String[] parts = pairs.split(";");
            int course = getCourseIndex(parts[0]);
            int prerequisite = getCourseIndex(parts[1]);
            graph.addDefaultWeight(prerequisite, course);
        }
        List<Integer> sorted = sort.topologicalSort(graph);

        List<String> sortedCourses = new ArrayList<>();
        if (sorted != null){
            for (Integer i : sorted){
                sortedCourses.add(indexToCourse.get(i));
            }
        }
        return sortedCourses;

    }


    public List<String> readContent(String path){
        List<String> coursePairs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
           String line;
           while ((line = reader.readLine()) != null){
               coursePairs.add(line);
           }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return coursePairs;
    }

    public void result(){
        CourseSort c = new CourseSort();
        String path = "assignment3/task5/data.txt";
        String result = "assignment3/task5/result.txt";
        List<String> sorted  = c.getCourse(c.readContent(path));
        try(PrintWriter write = new PrintWriter(new FileWriter(result))) {
            for (String cors: sorted ){
                write.println(cors);
            }
        }catch (IOException e){
            e.printStackTrace();
        }


        System.out.println(sorted.size());
    }
}
