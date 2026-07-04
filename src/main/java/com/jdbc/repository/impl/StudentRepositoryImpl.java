package com.jdbc.repository.impl;

import com.jdbc.connection.DBConnectionUtil;
import com.jdbc.dto.StudentDTO;
import com.jdbc.repository.StudentRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public boolean saveStudent(StudentDTO student) {

        String sql = "INSERT INTO student(id,first_name,last_name,gender,city,state,mobile_number,email_id,course_id,course_name,enrollment_date,course_type,grade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, student.getId());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getGender().name());
            ps.setString(5, student.getCity());
            ps.setString(6, student.getState());
            ps.setString(7, student.getMobileNumber());
            ps.setString(8, student.getEmailId());
            ps.setInt(9, student.getCourseId());
            ps.setString(10, student.getCourseName());
            ps.setDate(11, Date.valueOf(student.getEnrollmentDate()));
            ps.setString(12, student.getCourseType().name());
            ps.setString(13, student.getGrade().name());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public StudentDTO findStudentById(int id) {

        String sql = "SELECT * FROM student WHERE id=?";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                StudentDTO student = new StudentDTO();

                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setGender(com.jdbc.enums.Gender.valueOf(rs.getString("gender")));
                student.setCity(rs.getString("city"));
                student.setState(rs.getString("state"));
                student.setMobileNumber(rs.getString("mobile_number"));
                student.setEmailId(rs.getString("email_id"));
                student.setCourseId(rs.getInt("course_id"));
                student.setCourseName(rs.getString("course_name"));
                student.setEnrollmentDate(rs.getDate("enrollment_date").toLocalDate());
                student.setCourseType(com.jdbc.enums.CourseType.valueOf(rs.getString("course_type")));
                student.setGrade(com.jdbc.enums.Grade.valueOf(rs.getString("grade")));

                return student;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean updateCourse(int id, int courseId, String courseName) {

        String sql = "UPDATE student SET course_id=?,course_name=? WHERE id=?";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, courseId);
            ps.setString(2, courseName);
            ps.setInt(3, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteStudent(int id) {

        String sql = "DELETE FROM student WHERE id=?";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<StudentDTO> findAllStudents() {

        List<StudentDTO> list = new ArrayList<>();

        String sql = "SELECT * FROM student";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                StudentDTO student = new StudentDTO();

                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));

                list.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public StudentDTO findByEmailAndEnrollmentDate(String emailId, LocalDate enrollmentDate) {

        String sql = "SELECT * FROM student WHERE email_id=? AND enrollment_date=?";

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, emailId);
            ps.setDate(2, Date.valueOf(enrollmentDate));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                StudentDTO student = new StudentDTO();

                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setGender(com.jdbc.enums.Gender.valueOf(rs.getString("gender")));
                student.setCity(rs.getString("city"));
                student.setState(rs.getString("state"));
                student.setMobileNumber(rs.getString("mobile_number"));
                student.setEmailId(rs.getString("email_id"));
                student.setCourseId(rs.getInt("course_id"));
                student.setCourseName(rs.getString("course_name"));
                student.setEnrollmentDate(rs.getDate("enrollment_date").toLocalDate());
                student.setCourseType(com.jdbc.enums.CourseType.valueOf(rs.getString("course_type")));
                student.setGrade(com.jdbc.enums.Grade.valueOf(rs.getString("grade")));

                return student;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
