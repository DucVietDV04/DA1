package edusys;


import Model.taiKhoanNV;

public class Auth {
    public static taiKhoanNV user = null;
    
    public static void clear(){
        Auth.user = null;
    }
    
    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    public static boolean isManager(){
        return Auth.isLogin() && user.isVaiTro();
    }
}
