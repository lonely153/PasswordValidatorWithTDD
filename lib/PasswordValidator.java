package lib;

public class PasswordValidator {

    /**
     * ตรวจสอบความยากง่ายของรหัสผ่านที่เป็น String
     * @param ส่ง String ที่เป็นรหัสผ่านเข้าโปรแกรมเพื่อตรวจสอบความถูกต้องและความยากในการคาดเดา
     * @return ส่งกลับความยากของรหัสผ่านหรือความถูกต้อง(Invaild)
     * @throws IllegalArgumentException ถ้ารหัสผ่านมีค่า null หรือ empty
     */
    public static PasswordStrength validate(String password) {
        
        if(password == null || password.length() < 8){
            return PasswordStrength.INVALID;
        }

        boolean digit = false;
        boolean uppercase = false;
        boolean special = false;

        for(char c : password.toCharArray()){
            if(Character.isDigit(c)){
                digit = true;
            } else if(Character.isUpperCase(c)){
                uppercase = true;
            } else if(!Character.isLetterOrDigit(c)){
                special = true;
            }
        }

        if (digit && uppercase && special) {
            return PasswordStrength.STRONG;
        } else if ((digit && uppercase) || (digit && special) || (uppercase && special)) {
            return PasswordStrength.MEDIUM;
        } else if (digit || uppercase || special) {
            return PasswordStrength.WEAK;
        } else if(!digit || !uppercase || !special){
            return PasswordStrength.WEAK;
        } else {
            return PasswordStrength.INVALID;
        }

        
    }
}