package com.example.movses.greenpage.model;

/**
 * Created by Movses on 1/14/18.
 */


    public class Person {

        private String name;
        private String surname;
    private boolean sex;
    private String imgUrl;

        public Person(String name, String surname, boolean sex, String imgUrl) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.imgUrl = imgUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public boolean isSex() {
        return sex;
    }

        public void setSex(boolean sex) {
        this.sex = sex;
    }

        public String getImgUrl() {
        return imgUrl;
    }

        public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl;
    }



}
