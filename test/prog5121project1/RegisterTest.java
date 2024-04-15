/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog5121project1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Joel
 */
public class RegisterTest
{
    
    public RegisterTest()
    {
    }
    
    
    @Test
    public void testValidate()
    {
        System.out.println("Validate");
    
        //var register = new Register();
        boolean expected = true;
        boolean result = Register.Validate("kyl_1","Ch&&sec@ke99!");
        assertEquals(expected, result);
       
        assertEquals(false, Register.Validate("kyle!!!!!","password" ));
    
    }
}
        

 