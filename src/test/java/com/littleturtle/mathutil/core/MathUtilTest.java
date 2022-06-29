/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.littleturtle.mathutil.core;

import static com.littleturtle.mathutil.core.MathUtil.*;
import org.junit.jupiter.api.Test;
//import static dành riêng cho hàm static = gọi hàm bỏ qua tên class
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Masterkien
 */
public class MathUtilTest {
    
    //ddt - tách data khỏi câu lệnh test, tham số hóa data
    public static Object[][] initData(){
        return new Integer [][]{
            {4, 24},
            {5, 120},
            {1, 1},
            {3, 6}
        };
    }
    
    @ParameterizedTest
    @MethodSource(value = "initData") //tên hàm cung cấp data, ngầm định thứ t
    public void testGetFactorialGivenRightArgReturnWell(int input, long expected){
        assertEquals(getFactorial(input), expected);
    }
    
    //bắt ngoại lệ khi đưa data cà chớn
//    @Test(expeect = ...), chỉ junit4, junit5 ko xài vậy
 //tên hàm cung cấp data, ngầm định thứ t
    @Test
    public void testGetFactorialGivenWrongArgThrowException(){
        //xài lambda
        //param 2 là 1 object/có code imple cái functional interface tên là 
        //Executable - có 1 hàm duy nhất ko code tên là execute()
        
        //chơi chậm
//        Executable exObject = new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                getFactorial(-5);
//            }
//        };
        
//        Executable exObject = () -> getFactorial(-5);
        
        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
    }
}
