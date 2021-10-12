package co.edu.unbosque.dtos;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class User {


        @CsvBindByName
        private String email;

        @CsvBindByName
        private String password;

        @CsvBindByName
        private int role;

        @CsvBindByName
        private int id;

        public User() {
        }

    public User(String email, String password, int role, int id) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
         return id;
    }

    public void setId(int id) {
         this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User country = (User) o;
            return id == country.id &&
                    Objects.equals(password, country.password)&&
                    Objects.equals(email, country.email)&&
                    role == country.role;
        }

        @Override
        public int hashCode() {
            return Objects.hash(email,password,role,id);
        }
    }