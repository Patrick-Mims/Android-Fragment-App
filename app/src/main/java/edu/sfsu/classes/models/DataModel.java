package edu.sfsu.classes.models;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataModel extends ViewModel {
        // private List<DataModel> results;
        private Name name;
        private Location location;
        private Login login;
        private Dob dob;
        private Registered registered;
        private Id id;
        private Pic picture;
        private String gender;
        private String email;
        private String phone;
        private String cell;
        private String nat;

        public DataModel(Name name, Location location, Login login, Dob dob, Registered registered, Id id, Pic picture, String gender, String email, String phone, String cell, String nat) {
//                results = new ArrayList<>();
                this.name = name;
                this.location = location;
                this.login = login;
                this.dob = dob;
                this.registered = registered;
                this.id = id;
                this.picture = picture;
                this.gender = gender;
                this.email = email;
                this.phone = phone;
                this.cell = cell;
                this.nat = nat;
        }

        /*
        public List<DataModel> getResults() {
                return results;
        }

        public void setResults(List<DataModel> results) {
                this.results = results;
        }
        */

        public Name getName() {
                return name;
        }

        public void setName(Name name) {
                this.name = name;
        }

        public Location getLocation() {
                return location;
        }

        public void setLocation(Location location) {
                this.location = location;
        }

        public Login getLogin() {
                return login;
        }

        public void setLogin(Login login) {
                this.login = login;
        }

        public Dob getDob() {
                return dob;
        }

        public void setDob(Dob dob) {
                this.dob = dob;
        }

        public Registered getRegistered() {
                return registered;
        }

        public void setRegistered(Registered registered) {
                this.registered = registered;
        }

        public Id getId() {
                return id;
        }

        public void setId(Id id) {
                this.id = id;
        }

        public Pic getPicture() {
                return picture;
        }

        public void setPicture(Pic picture) {
                this.picture = picture;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getCell() {
                return cell;
        }

        public void setCell(String cell) {
                this.cell = cell;
        }

        public String getNat() {
                return nat;
        }

        public void setNat(String nat) {
                this.nat = nat;
        }
}