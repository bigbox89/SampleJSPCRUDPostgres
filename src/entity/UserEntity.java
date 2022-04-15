package entity;

import javax.persistence.*;

@Entity
@Table(name = "users")

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String email;
        private String country;

        public UserEntity() {}

        public UserEntity(String name, String email, String country) {
            super();
            this.name = name;
            this.email = email;
            this.country = country;
        }

        public UserEntity(int id, String name, String email, String country) {
            super();
            this.id = id;
            this.name = name;
            this.email = email;
            this.country = country;
        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getCountry() {
            return country;
        }
        public void setCountry(String country) {
            this.country = country;
        }
}
