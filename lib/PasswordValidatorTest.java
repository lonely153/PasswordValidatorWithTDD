package lib;

public class PasswordValidatorTest{
    
    public static void run() {
        System.out.println("--- Running Password Validator Tests ---");
        
        // Test Case 1: รหัสผ่านสั้นควรจะ INVALID
        PasswordStrength result1 = PasswordValidator.validate("123");
        if (result1 == PasswordStrength.INVALID) {
            System.out.println("Test Case 1 Passed: Short password is INVALID.");
        } else {
            System.out.println("Test Case 1 FAILED: Expected INVALID but got " + result1);
        }

        // Test Case 2: รหัสผ่านมีแต่ตัวพิมพ์เล็ก
        PasswordStrength result2 = PasswordValidator.validate("abcdefgh");
        if (result2 == PasswordStrength.WEAK) {
            System.out.println("Test Case 2 Passed: All lowercase password is WEAK.");
        } else {
            System.out.println("Test Case 2 FAILED: Expected WEAK but got " + result2);
        }

        // Test Case 3: รหัสผ่านมีแต่ตัวพิมพ์ใหญ่
        PasswordStrength result3 = PasswordValidator.validate("ABCDFGHJ");
        if (result3 == PasswordStrength.WEAK) {
            System.out.println("Test Case 3 Passed: All uppercase password is WEAK.");
        } else {
            System.out.println("Test Case 3 FAILED: Expected WEAK but got " + result3);
        }

        // Test Case 4: รหัสผ่านมีแต่อักขระตัวผสมแค่ตัวเลข
        PasswordStrength result4 = PasswordValidator.validate("ABCDF123");
        if (result4 == PasswordStrength.MEDIUM) {
            System.out.println("Test Case 4 Passed: Mix upper/lowercase with number password is WEAK.");
        } else {
            System.out.println("Test Case 4 FAILED: Expected WEAK but got " + result4);
        }

        // Test Case 5: รหัสผ่านมีทั้งสามแบบ
        PasswordStrength result5 = PasswordValidator.validate("ABCDF123@");
        if (result5 == PasswordStrength.STRONG) {
            System.out.println("Test Case 5 Passed: Mix upper/lowercase with number password is STRONG.");
        } else {
            System.out.println("Test Case 5 FAILED: Expected STRONG but got " + result5);
        }

        // Test Case 6: รหัสผ่านมีแค่ความว่างเปล่า empty
        PasswordStrength result6 = PasswordValidator.validate(" ");
        if (result6 == PasswordStrength.INVALID) {
            System.out.println("Test Case 6 Passed: empty password is INVAID.");
        } else {
            System.out.println("Test Case 6 FAILED: Expected INVAID but got " + result6);
        }

        // Test Case 7: รหัสผ่านไม่มีอะไรเลยแบบ null
        PasswordStrength result7 = PasswordValidator.validate("");
        if (result7 == PasswordStrength.INVALID) {
            System.out.println("Test Case 7 Passed: null password is INVAID.");
        } else {
            System.out.println("Test Case 7 FAILED: Expected null but got " + result7);
        }

        // Test Case 8 รหัสผ่านมีแค่อักขระพิเศษ
        PasswordStrength result8 = PasswordValidator.validate("@@@@@@@@ฟก");
        if (result8 == PasswordStrength.WEAK) {
            System.out.println("Test Case 8 Passed: Only speical characters password is WEAK.");
        } else {
            System.out.println("Test Case 8 FAILED: Expected WEAK but got " + result8);
        }

        System.out.println("--------------------------------");
    }
}
