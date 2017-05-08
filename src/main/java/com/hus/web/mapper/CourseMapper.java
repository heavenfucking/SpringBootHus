package com.hus.web.mapper;

import com.hus.common.consts.Url;
import com.hus.web.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zhh on 2017/5/5.
 */
public interface CourseMapper {
    List<Map<String, String>> selectAll();

    Integer insert(Course course);

    Integer update(Course course);

    List<Map<String, String>> selectByteacherId(Integer teacherId);

    Course selectByPrimaryKey(Integer id);

    Integer delete(Integer id);

    String generateCourseSno();

    Integer studentChoosedCourse(@Param(value = "studentId") Integer studentId,
                                 @Param(value = "courseId") Integer courseId);

    List<Map<String, String>> selectAllStudentUnChoosed(Integer studentId);

    List<Map<String, String>> selectAllStudentChoosed(Integer studentId);

    Integer addChoosedQuota(@Param(value = "num") Integer num,
                            @Param(value = "courseId")Integer courseId);
    Integer deleteStudentCourseByStudentIdAndCourseId(@Param(value = "studentId") Integer studentId,
                                         @Param(value = "courseId")Integer courseId);

}
