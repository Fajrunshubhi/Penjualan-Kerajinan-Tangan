package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("daftar")
public class daftar {

    public static String xml;
    @XStreamAlias("email")
    private String email;
    @XStreamAlias("username")
    private String username;
    @XStreamAlias("password")
    private String password;
    
    public daftar(){
        
    }

    public daftar(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String tampiluser(){
        return this.username;
    }
    public String tampilpw(){
        return this.password;
    }

    @Override
    public String toString() {
        return "data daftar{" + "email= " + this.email + ", username= " + this.username + ", password= " + this.password + '}';
    }
    
    
    
    
}
