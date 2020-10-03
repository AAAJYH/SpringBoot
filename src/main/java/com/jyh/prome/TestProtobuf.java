package com.jyh.prome;

import java.util.Arrays;

/**
 * @author jyh
 * @version 1.0
 * @date 2020/9/15
 */

public class TestProtobuf {

    public static void main(String[] args) {
        TeacherSerializer.Teacher.Builder builder = TeacherSerializer.Teacher.newBuilder();
        builder.setId(1L).setAge(22).setName("April");
        TeacherSerializer.Teacher t = builder.build();
        System.out.println(Arrays.toString(t.toByteArray()));
        System.out.println("Length = " + t.toByteArray().length);

    }

}
