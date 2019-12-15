package cn.yejh.jsstudy;/**
 * @author yejh
 * @create 2019-10_20 10:23
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.student.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: TODO
 **/
public class JSONTest {
    @Test
    public void object_json(){
        Student student = new Student();
        student.setSno(1);
        student.setSname("阿萨德");
        Gson gson = new Gson();
        String json = gson.toJson(student);
        System.out.println(json);       //{"sno":1,"sname":"阿萨德","sage":0}

        //json格式字符串转为对象
        Student student1 = gson.fromJson(json, Student.class);
        System.out.println(student1);

    }

    @Test
    public void list_json(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "对撒", 18, "北京大"));
        students.add(new Student(2, "和气", 24, "起点西安"));
        Gson gson = new Gson();
        String json = gson.toJson(students);
        System.out.println(json);       //[{"sno":1,"sname":"对撒","sage":18,"saddress":"北京大"},{"sno":2,"sname":"和气","sage":24,"saddress":"起点西安"}]

        //json格式字符串转为list
        List<Student> students1 = gson.fromJson(json, new MyType().getType());
        System.out.println(students1);      //[1-对撒-18-北京大, 2-和气-24-起点西安]
    }

    @Test
    public void map_json(){
        Map<String, Student> studentMap = new HashMap<>();
        studentMap.put("no1", new Student(1, "对撒", 18, "北京大"));
        studentMap.put("no2", new Student(2, "和气", 24, "起点西安"));
        Gson gson = new Gson();
        String json = gson.toJson(studentMap);
        System.out.println(json);   //{"no2":{"sno":2,"sname":"和气","sage":24,"saddress":"起点西安"},"no1":{"sno":1,"sname":"对撒","sage":18,"saddress":"北京大"}}

        //json格式字符串转为map
        Map<String, String> map = gson.fromJson(json, new TypeToken<Map<String, Student>>() {}.getType());
        System.out.println(map);       //{no2=2-和气-24-起点西安, no1=1-对撒-18-北京大}

    }
}
