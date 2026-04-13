/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
package logintest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
    }

    // ─── checkUserName ───────────────────────────────────────────────

    @Test
    public void testCheckUserNameValid() {
        assertTrue(login.checkUserName("dlu1_1"),
                "Username with underscore and <= 5 chars should be valid");
    }

    @Test
    public void testCheckUserNameNoUnderscore() {
        assertFalse(login.checkUserName("dlu1"),
                "Username without underscore should be invalid");
    }

    @Test
    public void testCheckUserNameTooLong() {
        assertFalse(login.checkUserName("dlu1_1"),
                "Username longer than 5 characters should be invalid");
    }

    @Test
    public void testCheckUserNameTooLongWithUnderscore() {
        assertFalse(login.checkUserName("ab_cde"),
                "Username with underscore but > 5 chars should be invalid");
    }

    @Test
    public void testCheckUserNameOnlyUnderscore() {
        assertTrue(login.checkUserName("_"),
                "A single underscore is <= 5 chars and contains underscore");
    }

    // ─── checkPasswordComplexity ──────────────────────────────────────

    @Test
    public void testCheckPasswordValid() {
        assertTrue(login.checkPasswordComplexity("Passw0rd!"),
                "Valid password with uppercase, digit, and special char should pass");
    }

    @Test
    public void testCheckPasswordTooShort() {
        assertFalse(login.checkPasswordComplexity("Pa1!"),
                "Password shorter than 8 characters should be invalid");
    }

    @Test
    public void testCheckPasswordNoCapital() {
        assertFalse(login.checkPasswordComplexity("passw0rd!"),
                "Password without uppercase letter should be invalid");
    }

    @Test
    public void testCheckPasswordNoNumber() {
        assertFalse(login.checkPasswordComplexity("Password!"),
                "Password without a digit should be invalid");
    }

    @Test
    public void testCheckPasswordNoSpecialChar() {
        assertFalse(login.checkPasswordComplexity("Password1"),
                "Password without a special character should be invalid");
    }

    @Test
    public void testCheckPasswordAllRequirementsMet() {
        assertTrue(login.checkPasswordComplexity("Admin@123"),
                "Password meeting all requirements should be valid");
    }

    // ─── checkCellPhoneNumber ─────────────────────────────────────────

    @Test
    public void testCheckCellPhoneValid10Digits() {
        assertTrue(login.checkCellPhoneNumber("+27831234567"),
                "Valid +27 number with 9 digits after code should pass");
    }

    @Test
    public void testCheckCellPhoneValid11Digits() {
        assertTrue(login.checkCellPhoneNumber("+278312345678"),
                "Valid +27 number with 10 digits after code should pass");
    }

    @Test
    public void testCheckCellPhoneNoCountryCode() {
        assertFalse(login.checkCellPhoneNumber("0831234567"),
                "Number without +27 prefix should be invalid");
    }

    @Test
    public void testCheckCellPhoneWrongCountryCode() {
        assertFalse(login.checkCellPhoneNumber("+26831234567"),
                "Number with wrong country code should be invalid");
    }

    @Test
    public void testCheckCellPhoneTooShort() {
        assertFalse(login.checkCellPhoneNumber("+2783123"),
                "Number with too few digits should be invalid");
    }

    @Test
    public void testCheckCellPhoneWithLetters() {
        assertFalse(login.checkCellPhoneNumber("+27abc123456"),
                "Number containing letters should be invalid");
    }

    // ─── returnLoginStatus ────────────────────────────────────────────

    @Test
    public void testReturnLoginStatusSuccess() {
        login.username = "dll_1";
        login.password = "Passw0rd!";
        String result = login.returnLoginStatus(true);
        assertEquals("Welcome kyl, 1 it is great to see you again", result,
                "Successful login should return welcome message");
    }

    @Test
    public void testReturnLoginStatusFailed() {
        login.username = "kyl_1";
        login.password = "Passw0rd!";
        String result = login.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again", result,
                "Failed login should return error message");
    }

    @Test
    public void testReturnLoginStatusNoLastName() {
        login.username = "kyle_";
        String result = login.returnLoginStatus(true);
        assertEquals("Welcome kyle,  it is great to see you again", result,
                "Username with nothing after underscore should still return welcome");
    }
}
    

